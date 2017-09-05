package br.una.revisao.controller;

import br.una.revisao.entity.Contato;
import br.una.revisao.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContatoController {
    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping("/contato")
    public String listar(Model model){
        model.addAttribute("contatos", contatoRepository.findAll());
        return "contato/listar";
    }

    @GetMapping("/contato/novo")
    public String novo(Model model){
        Contato contato = new Contato();
        model.addAttribute("contato", contato);
        return "contato/novo";
    }
    @PostMapping("/contato/salvar")
    public String salvar(@ModelAttribute Contato contato){
        contatoRepository.save(contato);
        return "redirect:/contato";
    }
}
