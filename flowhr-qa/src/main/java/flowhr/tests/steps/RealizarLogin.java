package flowhr.tests.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import flowhr.core.BaseTest;
import flowhr.core.MySQLConnect;
import flowhr.tests.auxiliares.GerarString;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RealizarLogin extends BaseTest {

    String jwtCurrent = "";
    Response response;
    RequestSpecification requestSpecification = RestAssured.given();
    GerarString gerarString = new GerarString();
    String bodyjson = gerarString.generateStringFromResource("src/main/java/flowhr/tests/arquivosbody/authenticate.json");
    ArrayList resultadoList = new ArrayList();
    Connection conn = MySQLConnect.getConnection();
    Statement stmt = conn.createStatement();

    public RealizarLogin() throws SQLException, IOException {
    }

    @Given("^que informei o usuário e senha corretamente$")
    public void buscarDadosLogin() throws IOException, SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE USUARIO = 'Jack'");
        while (rs.next()) {
            resultadoList.add(rs.getString("SENHA"));
        }
        bodyjson = bodyjson.replace("senhapadrao", resultadoList.get(0).toString());
        conn.close();
    }

    @When("^realizar o login$")
    public void realizarLogin() {
        response = requestSpecification
                .headers("Content-Type", "application/json")
                .body(bodyjson)
                .when().post("/authenticate");
    }


    @Given("^que não informei os dados$")
    public void que_não_informei_os_dados() throws Throwable {
        bodyjson = bodyjson.replace("senhapadrao","").replace("Jack","");
    }

    @Given("^que informei dados invalidos$")
    public void que_informei_dados_invalidos() throws Throwable {
        ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE USUARIO = 'Jack'");
        while (rs.next()) {
            resultadoList.add(rs.getString("SENHA"));
        }
        if (resultadoList.get(0).equals("senhapadrao")) {
            bodyjson = bodyjson.replace("senhapadrao", "senhainvalida");
        }
        conn.close();
    }

    @Then("^não deve acessar minha conta no sistema$")
    public void não_deve_acessar_minha_conta_no_sistema() throws Throwable {
        Assert.assertEquals(401, response.getStatusCode());
    }

    @Then("^deve acessar minha conta no sistema$")
    public void validarAcesso() throws SQLException {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().get("jwt").toString());
        jwtCurrent = response.jsonPath().get("jwt").toString();
    }
}
