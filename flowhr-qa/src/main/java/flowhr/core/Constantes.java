package flowhr.core;
import io.restassured.http.ContentType;


public interface Constantes {

    String APP_BASE_URL = "http://192.168.0.68:9090";
    String APP_BASE_PATH = "";
    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 5000L;
    String CHROMEDRIVER = "src/main/java/flowhr/tests/arquivosbody/chromedriver.exe";

}
