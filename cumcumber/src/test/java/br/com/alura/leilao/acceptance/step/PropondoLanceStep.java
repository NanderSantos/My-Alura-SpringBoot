package br.com.alura.leilao.acceptance.step;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;

public class PropondoLanceStep {

    private Lance lance;
    private Leilao leilao;

    @Dado("um lance valido")
    public void um_lance_valido() {
        this.lance = new Lance(new Usuario("fulano"), BigDecimal.TEN);
    }

    @Quando("propoe o lance")
    public void propoe_o_lance() {
        this.leilao = new Leilao("Tablet XPTO");
        this.leilao.propoe(this.lance);
    }

    @Então("o lance eh aceito")
    public void o_lance_eh_aceito() {
        Assert.assertEquals(1, this.leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }
}
