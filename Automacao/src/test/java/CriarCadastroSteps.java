import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CriarCadastroSteps {

    private WebDriver driver;

    @Given("^que acessei a URL correta$")

    public void que_acessei_a_URL_correta() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chrome\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://cliente.submarino.com.br/simple-login/cadastro/pf");
        Thread.sleep(5000);
    }

    @Given("^preenchi o email com \"([^\"]*)\"$")
    public void preenchi_o_email_com(String arg1) throws Throwable {
        driver.findElement(By.id("email-input")).sendKeys(arg1);
    }

    @Given("^preenchi a senha com \"([^\"]*)\"$")
    public void preenchi_a_senha_com(String arg1) throws Throwable {
        driver.findElement(By.id("password-input")).sendKeys(arg1);
    }

    @Given("^preenchi o cpf com \"([^\"]*)\"$")
    public void preenchi_o_cpf_com(String arg1) throws Throwable {
        driver.findElement(By.id("cpf-input")).sendKeys(arg1);
    }

    @Given("^preenchi o nome e sobrenome com \"([^\"]*)\"$")
    public void preenchi_o_nome_e_sobrenome_com(String arg1) throws Throwable {
        driver.findElement(By.id("name-input")).sendKeys(arg1);
    }

    @Given("^preenchi a data de nascimento com \"([^\"]*)\"$")
    public void preenchi_a_data_de_nascimento_com(String arg1) throws Throwable {
        driver.findElement(By.id("birthday-input")).sendKeys(arg1);
    }

    @Given("^cliquei no sexo corretamente$")
    public void cliquei_no_sexo_corretamente() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"gender\"]/div[1]/label")).click();
    }

    @Given("^preenchi o telefone com \"([^\"]*)\"$")
    public void preenchi_o_telefone_com(String arg1) throws Throwable {
        driver.findElement(By.id("phone-input")).sendKeys(arg1);
    }

    @When("^clicar em criar seu cadastro$")
    public void clicar_em_criar_seu_cadastro() throws Throwable {
        WebElement botao = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button"));
        botao.click();
    }

    @Then("^deve mostrar a mensagem \"([^\"]*)\"$")
    public void deve_mostrar_a_mensagem(String arg1) throws Throwable {
        String verificar = driver.findElement(By.xpath("//*[@id=\"recaptcha-verify-button\"]")).getText();
        Assert.assertEquals("VERIFICAR", verificar);
        driver.quit();
    }

    @Then("^devo ser alertado \"([^\"]*)\"$")
    public void devo_ser_alertado(String arg1) throws Throwable {
String texto = driver.findElement(By.xpath("//*[@id=\"email\"]/div")).getText();
        Assert.assertEquals("Campo obrigatório", texto);
    }
}