import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ConsultarJogosSteps {

    private WebDriver driver;

    @Given("^que acessei a URL SofaScore corretamente$")
    public void que_acessei_a_URL_SofaScore_corretamente() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.sofascore.com/pt/");

    }

    @Given("^informei o time que quero assistir$")
    public void informei_o_time_que_quero_assistir() throws Throwable {
        for (int i = 1; i <= 100; i++) {
            driver.findElement(By.xpath("[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div["+i+
                    "]/div[1]/div[2]/div[1]/a/span/text()")).getText().equals("Espanha");
        }
    }

    @When("^clicar em pesquisar$")
    public void clicar_em_pesquisar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^deve mostrar se tera jogo hoje$")
    public void deve_mostrar_se_tera_jogo_hoje() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

}