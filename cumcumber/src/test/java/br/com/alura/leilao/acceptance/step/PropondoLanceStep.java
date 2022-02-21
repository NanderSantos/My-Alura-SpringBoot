package br.com.alura.leilao.acceptance.step;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropondoLanceStep {

    private Lance lance;
    private List<Lance> lances = new ArrayList<>();
    private Leilao leilao;

    @Before
    public void setup() {
        this.lances = new ArrayList<>();
        this.leilao = new Leilao("Tablet XPTO");
        System.out.println("Running scenario... ");
    }

    @After
    public void tearDown() {
        System.out.println("Scenario done!\n");
    }

    @BeforeStep
    public void runningStep() {
        System.out.print("Running step... ");
    }

    @AfterStep
    public void finishedStep() {
        System.out.println("Done!");
    }

    @Dado("um lance válido")
    public void umLanceValido() {
        this.lance = new Lance(new Usuario("fulano"), BigDecimal.TEN);
    }

    @Quando("propõe ao leilão")
    public void propoeAoLeilao() {
        this.leilao.propoe(this.lance);
    }

    @Então("o lance é aceito")
    public void oLanceEAceito() {
        Assert.assertEquals(1, this.leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, this.leilao.getLances().get(0).getValor());
    }

    @Dado("um lance de {double} reais do usuário {string}")
    public void umLanceDeReaisDoUsuario(Double valor, String nomeUsuario) {
        this.lances.add(new Lance(new Usuario(nomeUsuario), new BigDecimal(valor)));
    }

    @Quando("propõe vários lances ao leilão")
    public void propoeVariosLancesAoLeilao() {
        this.lances.forEach(lance -> this.leilao.propoe(lance));
    }

    @Então("os lances são aceitos")
    public void osLancesSaoAceitos() {
        Assert.assertEquals(2, this.leilao.getLances().size());
        Assert.assertEquals(this.lances.get(0).getValor(), this.leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lances.get(1).getValor(), this.leilao.getLances().get(1).getValor());
    }

    @Dado("um lance inválido de {double} reais e do usuario {string}")
    public void umLanceInvalidoDeValorReaisEDoUsuarioNomeUsuario(Double valor, String nomeUsuario) {
        System.out.print(nomeUsuario + " ");
        this.lance = new Lance(new BigDecimal(valor));
    }

    @Então("o lance não é aceito")
    public void oLanceNaoEAceito() {
        Assert.assertEquals(0, this.leilao.getLances().size());
    }

    @Dado("dois lances")
    public void doisLances(DataTable dataTable) {

        List<Map<String, String>> valores = dataTable.asMaps();
        valores.forEach(mapa -> {
            this.lances.add(new Lance(
                    new Usuario(mapa.get("nomeUsuario")),
                    new BigDecimal(mapa.get("valor"))
            ));
        });
    }

    @Então("o segundo lance não é aceito")
    public void oSegundoLanceNaoEAceito() {
        Assert.assertEquals(1, this.leilao.getLances().size());
        Assert.assertEquals(this.lances.get(0).getValor(), this.leilao.getLances().get(0).getValor());
    }
}
