package pe.isil.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("canje")
public class CanjeController {

    @GetMapping
    public String Canje(){
        return "canje";
    }
}
