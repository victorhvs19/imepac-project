package br.edu.imepac.controller;

import br.edu.imepac.model.Cliente;
import br.edu.imepac.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repo;
    public ClienteController(ClienteRepository repo){ this.repo = repo; }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("clientes", repo.findAll());
        return "clientes/list";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes/form";
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente){
        repo.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        var c = repo.findById(id).orElse(new Cliente());
        model.addAttribute("cliente", c);
        return "clientes/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        repo.deleteById(id);
        return "redirect:/clientes";
    }
}
