package br.edu.imepac.controller;

import br.edu.imepac.model.Cliente;
import br.edu.imepac.model.Orcamento;
import br.edu.imepac.repository.ClienteRepository;
import br.edu.imepac.repository.OrcamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoController {

    private final OrcamentoRepository orcRepo;
    private final ClienteRepository cliRepo;

    public OrcamentoController(OrcamentoRepository orcRepo, ClienteRepository cliRepo){
        this.orcRepo = orcRepo;
        this.cliRepo = cliRepo;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("orcamentos", orcRepo.findAll());
        return "orcamentos/list";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("orcamento", new Orcamento());
        model.addAttribute("clientes", cliRepo.findAll());
        return "orcamentos/form";
    }

    @PostMapping("/salvar")
    public String salvar(Orcamento orcamento){
        orcRepo.save(orcamento);
        return "redirect:/orcamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        var o = orcRepo.findById(id).orElse(new Orcamento());
        model.addAttribute("orcamento", o);
        model.addAttribute("clientes", cliRepo.findAll());
        return "orcamentos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        orcRepo.deleteById(id);
        return "redirect:/orcamentos";
    }
}
