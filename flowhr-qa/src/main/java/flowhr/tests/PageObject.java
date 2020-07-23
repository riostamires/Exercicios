package flowhr.tests;

import flowhr.core.DriverManagerFactory;

public class PageObject extends DriverManagerFactory {
    DriverManagerFactory driverManager = new DriverManagerFactory();

    public void escolherDriver() {
        driver = driverManager.getDriver();
    }

    public void clicarConsultarVaga() {

        driver.findElement(consultarVaga).click();
    }

    public void fecharPagina() {
        driver.quit();
    }
}


