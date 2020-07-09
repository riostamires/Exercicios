import com.sun.org.apache.xpath.internal.operations.NotEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ConsultarJogosSteps {

    private WebDriver driver;
    String jogo;

    @Given("^que acessei a URL SofaScore corretamente$")
    public void que_acessei_a_URL_SofaScore_corretamente() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.sofascore.com/pt/");
    }

    @When("^clicar em Espanha$")
    public void clicar_em_Espanha() throws Throwable {

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(
                (By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div[1]" +
                        "/div[1]/div[2]/div[1]/a/span"))));

        int i = 1;
        String element = "";
        WebElement webElement = null;

        while (!element.equals("Espanha")) {
            webElement = driver.findElement(By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div["
                    + i + "]/div[1]/div[2]/div[1]/a/span"));
            element = webElement.getText();
            i++;
        }
        webElement.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(
                (By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]"))));

        WebElement webElementJogo = driver.findElement(By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]"));
        jogo = webElementJogo.getText();
    }

    @Then("^deve mostrar se tera jogo hoje$")
    public void deve_mostrar_se_tera_jogo_hoje() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        if (jogo.contains("Barcelona")) {
            System.out.println("Hoje tem jogo do Barça!");
        } else {
            System.out.println("hoje não tem jogo do Barça!");
        }
    }

    @Test
    public void barcelona() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sofascore.com/pt/");

        int liga = 1;
        int time;
        int bloco;
        int contaBloco;
        int contaTime = 0;
        ArrayList<String> timesHoje = new ArrayList<String>();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div["+liga+"]/div[1]/div[2]/div[1]/a/span")));

        while (!driver.findElement(By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div[" + liga + "]/div[1]/div[2]/div[1]/a/span")).getText().equals("Espanha")) {
            liga++;
        }

        contaBloco = driver.findElements(By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div[" + liga + "]/div[2]/a")).size();

        for (time = 1; time <= 2; time++) {
            for (bloco = 1; bloco <= contaBloco; bloco++) {
                timesHoje.add(driver.findElement(By.xpath("//*[@id=\"pjax-container-main\"]/div/div[2]/div/div[2]/div[2]/div/div["+liga+"]/div[2]/a["+bloco+"]/div[3]/div["+time+"]")).getText());
            }
        }

        if(timesHoje.contains("Barcelona")) {
            System.out.println("O Barcelona joga hoje! GO GO BARÇA!!");
        } else {
            System.out.println("O Barcelona não joga hoje!");
            while (contaTime < timesHoje.size()) {
                System.out.println("Os times que jogam hoje são: " + timesHoje.get(contaTime));
                contaTime++;
            }
            System.out.println("Lhes deixo um abraço e camegol!");
        }

        driver.quit();
    }
}
