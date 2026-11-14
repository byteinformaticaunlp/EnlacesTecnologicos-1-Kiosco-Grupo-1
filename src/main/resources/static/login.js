/* Comportamiento de la pantalla de ingreso (demostración).
   El HTML y el CSS funcionan solos; este archivo solo les da vida.
   TODO: reemplazar validar() por una llamada a la API de login. */
(() => {
    const PIN_LARGO = 4;
    const PIN_DEMO = '1234';

    const USUARIOS = {
        david: { nombre: 'David', roles: ['ADMIN'] },
        clara: { nombre: 'Clara', roles: ['CAJERO', 'REPOSITOR'] },
        alann: { nombre: 'Alann', roles: ['CAJERO'] },
        leandro: { nombre: 'Leandro', roles: ['REPOSITOR'] },
    };
    const MODOS = {
        CAJERO: { titulo: 'Cajero', detalle: 'Cobros, devoluciones y caja' },
        REPOSITOR: { titulo: 'Repositor', detalle: 'Carga de stock' },
        ADMIN: { titulo: 'Administrador', detalle: 'Panel, personal y reportes' },
    };

    const $ = (s) => document.querySelector(s);
    const lugares = document.querySelectorAll('.pin__lugar');
    let actual = null;
    let pin = '';

    function mensaje(texto, tipo = '') {
        const m = $('#mensaje');
        m.textContent = texto;
        m.className = 'mensaje ' + tipo;
    }

    function pintarPin() {
        lugares.forEach((l, i) => l.classList.toggle('lleno', i < pin.length));
    }

    function elegirUsuario(id) {
        actual = id;
        pin = '';
        pintarPin();
        mensaje('');
        document.querySelectorAll('.usuario').forEach((b) =>
            b.setAttribute('aria-pressed', String(b.dataset.usuario === id)));
    }

    function agregar(digito) {
        if (!actual) return mensaje('Elegí tu usuario primero', 'error');
        if (pin.length >= PIN_LARGO) return;
        pin += digito;
        pintarPin();
        if (pin.length === PIN_LARGO) validar();
    }

    function borrar() {
        pin = pin.slice(0, -1);
        pintarPin();
    }

    function validar() {
        if (pin === PIN_DEMO) return mostrarModos();
        const caja = $('#pin');
        caja.classList.add('error');
        mensaje('PIN incorrecto', 'error');
        setTimeout(() => { caja.classList.remove('error'); pin = ''; pintarPin(); }, 450);
    }

    function mostrarModos() {
        const u = USUARIOS[actual];
        // El administrador entra a los tres modos; los demás, solo a los suyos.
        const roles = u.roles.includes('ADMIN') ? ['REPOSITOR', 'CAJERO', 'ADMIN'] : u.roles;
        if (roles.length === 1) return entrar(roles[0]);

        $('#saludo').textContent = 'Hola, ' + u.nombre;
        $('#estado-modo').textContent = '';
        const cont = $('#modos');
        cont.innerHTML = '';
        roles.forEach((r) => {
            const b = document.createElement('button');
            b.type = 'button';
            b.className = 'modo' + (r === 'ADMIN' ? ' modo--admin' : '');
            b.innerHTML = '<strong>' + MODOS[r].titulo + '</strong><small>' + MODOS[r].detalle + '</small>';
            b.addEventListener('click', () => entrar(r));
            cont.appendChild(b);
        });
        $('#pantalla-ingreso').hidden = true;
        $('#pantalla-modos').hidden = false;
    }

    function entrar(rol) {
        // Acá se redirige a la pantalla del modo elegido.
        $('#pantalla-ingreso').hidden = true;
        $('#pantalla-modos').hidden = false;
        $('#saludo').textContent = 'Hola, ' + USUARIOS[actual].nombre;
        $('#estado-modo').className = 'mensaje ok';
        $('#estado-modo').textContent = 'Entrando como ' + MODOS[rol].titulo.toLowerCase() + '…';
    }

    function volver() {
        $('#pantalla-modos').hidden = true;
        $('#pantalla-ingreso').hidden = false;
        elegirUsuario(null);
    }

    document.querySelectorAll('.usuario').forEach((b) =>
        b.addEventListener('click', () => elegirUsuario(b.dataset.usuario)));
    $('#teclado').addEventListener('click', (e) => {
        const t = e.target.closest('[data-tecla]');
        if (t) agregar(t.dataset.tecla);
    });
    $('#borrar').addEventListener('click', borrar);
    $('#volver').addEventListener('click', volver);
    document.addEventListener('keydown', (e) => {
        if ($('#pantalla-ingreso').hidden) return;
        if (/^[0-9]$/.test(e.key)) agregar(e.key);
        else if (e.key === 'Backspace') borrar();
    });
})();