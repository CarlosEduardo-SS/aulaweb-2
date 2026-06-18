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
    //Questão 3: O erro acontece pois o @RequestParam que foi definido no controller não está de acordo com o que está na página HTML.

    @PostMapping("/resultado")
    public String resultado(@RequestParam String nome,
                            @RequestParam String email,
                            Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("email", email);

                                
        return "resultado";
    }

    @GetMapping("/cadastro")
    public String cadastro() {

        return "cadastro";
    }

    @PostMapping("/cadastro-resultado")
    public String cadastroResultado(@RequestParam String nome,
                            @RequestParam int idade,
                            @RequestParam String curso,
                            Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("idade", idade);
        model.addAttribute("curso", curso);

                                
        return "cadastro-resultado";
    }

    @GetMapping("/soma")
    public String soma() {

        return "soma";
    }

    @PostMapping("/soma-resultado")
    public String somaResultado(@RequestParam double num1,
                                @RequestParam double num2,
                                Model model) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);

        double somaResultado = num1 + num2;
        model.addAttribute("soma", somaResultado);

                        
        return "soma-resultado";
    }

    @GetMapping("/calculadora")
    public String calculadora() {

        return "calculadora";
    }

    @PostMapping("/calculadora-resultado")
    public String calculadoraResultado(@RequestParam double num1,
                                @RequestParam double num2,
                                Model model) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);

        double soma = num1 + num2;
        model.addAttribute("soma", soma);

        double subtração = num1 - num2;
        model.addAttribute("subtração", subtração);
        
        double multi = num1 * num2;
        model.addAttribute("multi", multi);

        if (num2 <= 0) {
            model.addAttribute("erro", "Não é possível dividir por 0.");
        }else {
            double divisao = num1 / num2;
            model.addAttribute("divisao", divisao);
        }
                         
        return "calculadora-resultado";
    }

     @GetMapping("/produto")
    public String produto() {

        return "produto";
    }

    @PostMapping("/produto-cadastro")
    public String produtoCadastro(@RequestParam String nome,
                            @RequestParam double preco,
                            @RequestParam int quantidade,
                            Model model) {
        model.addAttribute("nome", nome);

        if (preco <= 0) {
            model.addAttribute("erroPreco", "Erro! número inválido.");
        }else {
            model.addAttribute("preco", preco);
        }

        if (quantidade <= 0) {
            model.addAttribute("erroQuantidade", "Erro! número inválido.");
        }else {
            model.addAttribute("quantidade", quantidade);
        }
  
        double total = preco * quantidade;
        model.addAttribute("total", total);

                                
        return "produto-cadastro";
    }
}
