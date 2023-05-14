package pe.isil.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.isil.proyecto.model.Usuario;
import pe.isil.proyecto.repository.UsuarioRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String register(Model model, Usuario usuario){
        model.addAttribute("usuario",usuario);
        return "register";
    }

    @PostMapping
    public String registrar(Usuario usuario) throws Exception{
        try {
            if (usuario!= null && !usuarioRepository.existsByEmail(usuario.getEmail())){
                usuarioRepository.save(usuario);
                return "redirect:/login";}
        }catch (Exception e){
            e.printStackTrace();
        }
        return "register";
    }

}
