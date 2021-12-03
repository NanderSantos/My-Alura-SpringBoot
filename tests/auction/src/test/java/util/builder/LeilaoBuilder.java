package util.builder;

import br.com.alura.auction.model.Leilao;
import br.com.alura.auction.model.Usuario;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LeilaoBuilder {

    private String nome;
    private BigDecimal valorInicial;
    private LocalDate data;
    private Usuario usuario;

    public LeilaoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LeilaoBuilder comValorInicial(String valorInicial) {
        this.valorInicial  = new BigDecimal(valorInicial);
        return this;
    }

    public LeilaoBuilder comData(LocalDate data) {
        this.data = data;
        return this;
    }

    public LeilaoBuilder comUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Leilao criar() {
        return new Leilao(
                this.nome,
                this.valorInicial,
                this.data,
                this.usuario
        );
    }

    public Leilao criarEPersistir(EntityManager em) {

        Leilao leilao = new Leilao(
                this.nome,
                this.valorInicial,
                this.data,
                this.usuario
        );

        em.persist(leilao);

        return leilao;
    }
}
