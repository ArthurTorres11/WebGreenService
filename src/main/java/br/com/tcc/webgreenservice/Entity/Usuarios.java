package br.com.tcc.webgreenservice.Entity;

import br.com.tcc.webgreenservice.Entity.enums.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private int id;

    @Column(name = "cpf_usuario", unique = true, nullable = false)
    @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter apenas números")
    private String cpf;

    @Column(name = "nome_usuario", nullable = false)
    private String nome;

    @Column(name = "email_usuario", nullable = false)
    @Email(message = "Email inválido")
    private String email;

    @Column(name = "senha_usuario", nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil_usuario", nullable = false)
    private Perfil perfil;

    @Column(name = "setor_usuario", nullable = false)
    private String setor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
