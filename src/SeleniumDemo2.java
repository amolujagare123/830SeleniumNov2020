import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo2 {

    public static void main(String[] args) {

        // 1. open a browser
        System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //2. maximize a browser
        driver.manage().window().maximize();

       // 3. open url
        driver.get("http://scriptinglogic.com");


        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getTitle());

        System.out.println(driver.getPageSource());

        // 4. navitate to another link

        driver.navigate().to("http://gmail.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();


    }


}
