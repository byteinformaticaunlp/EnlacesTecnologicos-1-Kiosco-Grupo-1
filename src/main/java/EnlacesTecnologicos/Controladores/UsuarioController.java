package EnlacesTecnologicos.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EnlacesTecnologicos.Modelo.Usuario;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @GetMapping
    public String listarUsuarios() {
        return "lista de usuarios";
    }

    public void AgregarUsuario(Usuario usuario) {

    }

    public void EliminarUsuario(Usuario usuario) {
    }

    public void ModificarUsuario(Usuario usuario) {

    }
}
