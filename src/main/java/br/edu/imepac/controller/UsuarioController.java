package br.edu.imepac.controller;

import br.edu.imepac.model.Usuario;
import br.edu.imepac.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repo;
    public UsuarioController(UsuarioRepository repo){ this.repo = repo; }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("usuarios", repo.findAll());
        return "usuarios/list";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario){
        repo.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        var u = repo.findById(id).orElse(new Usuario());
        model.addAttribute("usuario", u);
        return "usuarios/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        repo.deleteById(id);
        return "redirect:/usuarios";
    }
}
