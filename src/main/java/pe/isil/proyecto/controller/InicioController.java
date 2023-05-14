package pe.isil.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.isil.proyecto.model.Usuario;
import pe.isil.proyecto.repository.UsuarioRepository;

import java.util.Optional;

@Controller
@RequestMapping(value = {"/","inicio"})
public class InicioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public String Login(Usuario usuario, Model model){
        model.addAttribute(usuario);
        return "index";
    }


}
