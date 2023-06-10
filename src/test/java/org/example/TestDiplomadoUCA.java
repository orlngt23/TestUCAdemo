package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDiplomadoUCA {
    public WebDriver driver;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void loginSaudemo(){
        WebElement btnlogin, user,password;
        user = driver.findElement(By.cssSelector("#user-name"));
        user.sendKeys("standard_user");
        password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        btnlogin = driver.findElement(By.cssSelector("#login-button"));
        btnlogin.click();

    }

    public void agregarCarrito(){
        WebElement btnAgregar1, btnAgregar2;
        btnAgregar1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        btnAgregar1.click();
        btnAgregar2 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        btnAgregar2.click();

    }

    public void clickCarrito(){
        WebElement btnCarrito;
        btnCarrito = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        btnCarrito.click();
    }

    public void quitarArticulo(){
        WebElement btnQuitar;
        btnQuitar = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
        btnQuitar.click();
    }

    public void clickCheckout(){
        WebElement btnCheckout;
        btnCheckout = driver.findElement(By.cssSelector("#checkout"));
        btnCheckout.click();
    }


    @Test(priority = 1)
    public void testLogin(){
        setUp();
        loginSaudemo();
        agregarCarrito();
        clickCarrito();
        quitarArticulo();
        clickCheckout();

    }


}
