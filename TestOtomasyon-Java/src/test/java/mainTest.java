import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class mainTest {

    WebDriver driver;

    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.a101.com.tr/");
    }
    @Test(dependsOnMethods = "setUp")
    public void cookies(){
        WebElement cookies = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookies.click();
    }
    //@Test(dependsOnMethods = "cookies")
    //public void popUp(){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //WebElement popup = driver.findElement(By.xpath("/html/body/div[1]/div[1]"));
        //popup.click();

    //}
    @Test(dependsOnMethods = "cookies")
    public void searchBox(){
        WebElement searchBox = driver.findElement(By.xpath("/html/body/section/header/div[2]/div[1]/div[2]/div/div[2]/div[1]/form/input"));
        searchBox.sendKeys("Süt Tozu" + Keys.ENTER);
    }
    @Test(dependsOnMethods = "searchBox")
    public void choiceProduct(){
        WebElement choice = driver.findElement(By.xpath("//*[@id=\"personaclick_search_products\"]/div/div[2]/a[1]/div[2]"));
        choice.click();
    }
    @Test(dependsOnMethods = "choiceProduct")
    public void addToCart(){
        WebElement addToCart = driver.findElement(By.xpath("/html/body/section/section[2]/div[2]/div[1]/div/div[3]/div[2]/div[1]/button"));
        addToCart.click();
    }
    @Test(dependsOnMethods = "addToCart")
    public void goToCart(){
        WebElement goToCart = driver.findElement(By.xpath("//*[@id=\"js-modal-basket\"]/div[3]/a[3]"));
        goToCart.click();
    }
    @Test(dependsOnMethods = "goToCart")
    public void acceptCart (){
        WebElement acceptCart = driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div/div[2]/div/a"));
        acceptCart.click();
    }
    @Test(dependsOnMethods = "acceptCart")
    public void noSignIn(){
        WebElement noSingIn = driver.findElement(By.xpath("/html/body/section/div[1]/div/div[1]/div[1]/div[2]/a"));
        noSingIn.click();
    }
    @Test(dependsOnMethods = "noSignIn")
    public void continuE(){
        WebElement continuE = driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div/div/form/div[1]/input"));
        continuE.sendKeys("muratsinmez06@gmail.com");
        WebElement submit = driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div/div/form/button"));
        submit.click();
    }
    @Test(dependsOnMethods = "continuE")
    public void newAddress(){
        WebElement newAddress = driver.findElement(By.xpath("/html/body/section/section/div/div[2]/div/div[1]/div/div[1]/div[2]/ul[2]/li/a"));
        newAddress.click();
        WebElement addressName = driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[2]/div/div/label/input"));
        addressName.sendKeys("Ev");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[3]/div[1]/div/label/input"));
        name.sendKeys("Murat");
        WebElement surName = driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[3]/div[2]/div/label/input"));
        surName.sendKeys("Sinmez");
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[4]/div/div/label/input"));
        phoneNumber.sendKeys("5317466020");
        WebElement dropdown = driver.findElement(By.name("city"));
        dropdown.findElement(By.xpath("//option[. = 'ANKARA']")).click();
        WebElement dropdownT = driver.findElement(By.name("township"));
        dropdownT.findElement(By.xpath("//option[. = 'MAMAK']")).click();
        WebElement dropdownC = driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[6]/label/div/select"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        dropdownC.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[6]/label/div/select/option[59]")).click();
        WebElement address = driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[7]/label/textarea"));
        address.sendKeys("x Mah. x sok. x/x");
        WebElement save = driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/button[1]"));
        save.click();
        WebElement saveAll = driver.findElement(By.xpath("/html/body/section/section/div/div[2]/div/div[1]/div/div[2]/form/div[2]/button"));
        saveAll.click();
        driver.quit();
    }
}

