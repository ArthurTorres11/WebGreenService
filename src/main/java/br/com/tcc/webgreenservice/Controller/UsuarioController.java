package br.com.tcc.webgreenservice.Controller;

import br.com.tcc.webgreenservice.Entity.Usuarios;
import br.com.tcc.webgreenservice.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Usuarios> recuperarUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuarios recuperarUsuarioPorId(@PathVariable int id){
        return usuarioRepository.findById(id).orElseThrow(()
        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios cadastrarUsuario(@RequestBody @Valid Usuarios usuario){
        if(usuarioRepository.existsByCpf(usuario.getCpf())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
        }
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuarios atualizarUsuario(@PathVariable int id, @RequestBody @Valid Usuarios usuario){
        if (!usuarioRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable int id){
        if(!usuarioRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
