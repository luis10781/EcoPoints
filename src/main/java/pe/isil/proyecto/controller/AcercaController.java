package pe.isil.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acerca")
public class AcercaController {

    @GetMapping
    public String Acerca(){
        return "acerca";
    }
}
