package br.com.tcc.webgreenservice.Repository;

import br.com.tcc.webgreenservice.Entity.Usuarios;
import br.com.tcc.webgreenservice.Entity.enums.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    boolean existsByEmail(String email);
    Usuarios findByEmail(String email);
    List<Usuarios> findByPerfil(Perfil perfil);
    Usuarios findByCpf(String cpf);
    List<Usuarios> findByNome(String nome);
    List<Usuarios> findByNomeContaining(String parteDoNome);
}


