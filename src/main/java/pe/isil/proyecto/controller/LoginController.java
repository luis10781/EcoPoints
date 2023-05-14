package pe.isil.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.isil.proyecto.model.Usuario;
import pe.isil.proyecto.repository.UsuarioRepository;

import java.util.Optional;

@Controller()
@RequestMapping(value = {"login"})
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping()
    public String CargaLogin(Usuario usuario, Model model){
        model.addAttribute(usuario);
        return "login";
    }

    @PostMapping()
    public String Login(Usuario usuario, RedirectAttributes ra,Model model){
        try {
            Optional<Usuario> usuariofind = usuarioRepository.findByEmail(usuario.getEmail());
            if (usuariofind.isPresent()&&usuario.getPassword().equals(usuariofind.get().getPassword())){
                ra.addFlashAttribute("loginUser",usuariofind.get().getNombres());
                ra.addFlashAttribute("pointsUser",usuariofind.get().getPuntos());
                return "redirect:/";
            }else {
                model.addAttribute("mensaje","Mensaje o usuario incorrecto ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "login";
    }
}
