package com.aulaquatro.response;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {
    

    @GetMapping("/formulario")
    public String formulario() {

        return "formulario";
    }

    @PostMapping("/resultado")
    public String resultado(@RequestParam String nome,
                            @RequestParam double preco,
                            @RequestParam int quantidade,
                            Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("preco", preco);
        model.addAttribute("quantidade", quantidade);

        double total = preco * quantidade;
        model.addAttribute("total", total);

                                
        return "resultado";
    }
}
