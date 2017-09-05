package br.una.revisao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

@Controller
public class MeuController {
    @GetMapping("/")
    public String get() {
        return "formulario";
    }

    @PostMapping("/")
    public String post(Model modelo, String texto) {
        modelo.addAttribute("texto_original", texto);
        StringBuilder textoInvertido = new StringBuilder(texto).reverse();
        modelo.addAttribute("texto_invertido", textoInvertido);
        return "resposta";
    }

    @GetMapping("/numeros")
    public String numeros() {
        return "numeros";
    }

    @PostMapping("/enviarNumeros")
    public String processarNumeros(Model model, Integer x, Integer y) {
        List<Integer> numeros = rangeClosed(x, y)
                .boxed()
                .collect(toList());
        model.addAttribute("meus_numeros", numeros);
        return "mostranumeros";
    }

}
