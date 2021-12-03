package br.com.alura.auction.util.builder;

import br.com.alura.auction.model.Usuario;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioBuilder {

    private String nome;
    private String senha;
    private String email;

    public UsuarioBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder comSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario criar() {
        return new Usuario(
                this.nome,
                this.email,
                this.senha
        );
    }

    public Usuario criarEPersistir(EntityManager em) {

        Usuario usuario = new Usuario(
                this.nome,
                this.email,
                this.senha
        );

        em.persist(usuario);

        return usuario;
    }
}
