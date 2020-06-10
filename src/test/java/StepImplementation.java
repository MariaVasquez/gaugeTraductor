import Common.ConfigurationDriver;
import Traductor.TraductorPage;
import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class StepImplementation {

    private static WebDriver driver;

    @BeforeSpec
    public void setup() {
        ConfigurationDriver configurationDriver = new ConfigurationDriver();
        driver = configurationDriver.chromeConfiguration();
    }

    @AfterSpec
    public void closed(){
        driver.close();
    }

    @Step("Navigate to <https://translate.google.com/?hl=es>")
    public void implementation1(String url){
        driver.get(url);
    }

    @Step("Enter hello <hello> in the field to translate")
    public void implementation2(String word){
        TraductorPage traductorPage = new TraductorPage(driver);
        traductorPage.writeWord(word);
    }

    @Step("See hola <Hola> as the translated word")
    public void implementation4(String wortExpected) {
        TraductorPage traductorPage = new TraductorPage(driver);
        String result = traductorPage.translatedWord();
        assertEquals(wortExpected, result);
    }
    
}
