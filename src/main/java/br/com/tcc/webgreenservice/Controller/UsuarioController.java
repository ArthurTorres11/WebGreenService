package br.com.tcc.webgreenservice.Controller;

import br.com.tcc.webgreenservice.Entity.Usuarios;
import br.com.tcc.webgreenservice.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuarios> recuperarUsuarios(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuarios cadastrarUsuario(@RequestBody @Valid Usuarios usuario){
        return usuarioRepository.save(usuario);
    }

}
