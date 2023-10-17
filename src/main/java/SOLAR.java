import com.google.common.annotations.VisibleForTesting;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SOLAR {

    public static  WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearResolutionCache();
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.navigate().to("http://solar.schoolnewgen.com/websolar/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("super_admin@gmail.com");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        Select company = new Select(driver.findElement(By.name("company")));
        company.selectByValue("5");
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        String expValue= "Dashboard";
        String actValue=driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
        if(expValue==actValue){
            System.out.println("script passed");
        }else{
            System.out.println("script failed");
        }

        driver.findElement(By.xpath("//h3[contains(text(),'40')]")).click();
     //   = driver.findElement(By.xpath("//h3[contains(text(),'Companies')]")).getText();
        WebDriverWait e= new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement bo= e.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Companies')]")));
        String val= bo.getText();
        if(val=="Companies")
        {
            System.out.println("companies is displayed successfully");
        }else
        {
            System.out.println("no able to found");
        }
        driver.close();



    }
}
