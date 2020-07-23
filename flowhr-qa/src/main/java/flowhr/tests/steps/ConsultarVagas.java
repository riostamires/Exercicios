package flowhr.tests.steps;

import flowhr.core.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import flowhr.core.MySQLConnect;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import flowhr.tests.auxiliares.GerarString;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultarVagas extends BaseTest {

    String jwtCurrent = "";
    Response responseget;

    @Given("^que tenho o jwt correto para acessar a API$")
    public void gerarJwt() throws IOException, SQLException {

        GerarString gerarString = new GerarString();

        String bodyjson = gerarString.generateStringFromResource("src/main/java/flowhr/tests/arquivosbody/authenticate.json");

        ArrayList resultadoList = new ArrayList();

        Connection conn = MySQLConnect.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE USUARIO = 'Jack'");

        while (rs.next()) {
            resultadoList.add(rs.getString("SENHA"));
        }

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                .headers("Content-Type", "application/json")
                .body(bodyjson.replace("senhapadrao", resultadoList.get(0).toString()))
                .when().post("/authenticate");

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().get("jwt").toString());

        jwtCurrent = response.jsonPath().get("jwt").toString();

        conn.close();

    }

    @When("^executar o servico de Consultar Vaga$")
    public void executarConsultaVaga() {

        RequestSpecification requestSpecification = RestAssured.given();
        responseget = requestSpecification
                .headers("Content-Type", "application/json","Authorization", "Bearer "+jwtCurrent)
                .when().get("/vagas");

    }

    @Then("^deve mostrar as vagas disponíveis$")
    public void validarConsultaVaga() {
        Assert.assertEquals(200, responseget.getStatusCode());
    }


}

