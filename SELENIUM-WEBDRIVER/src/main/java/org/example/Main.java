package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {

    WebDriver driver;
    String urln11 = "https://www.n11.com/urun/scrikss-graph-x-metal-versatil-kalem-07-mm-kursun-gri-13155859?magaza=ofisinn&utm_source=comp_cimri&utm_medium=cpc&utm_campaign=cimri_genel";
    String urlAmazon = "https://www.amazon.com.tr/Scrikss-Graph-x-Mekanik-Kur%C5%9Fun-Kalem/dp/B01DRXDLRU/ref=sr_1_5?adgrpid=118345525645&dib=eyJ2IjoiMSJ9.KDKALHZ6nECYGjgXq2PppkB6ITYEY39xQDl__xGOv8i_ZyTku5LEo9N4B0FNqZnVXwxV6wx-BVDEqPXqCDxiVmZ5eAHj0kwOQxLKacfX0scBreNIK4udtS5-i59tTjcdxt95QuPH1TPbyJs7H3QHbHPt9uVyfVFavEx0fLfQJ38ZS9878AlUcL_Oo0RRNyxQqxwR8BM6qPG3Liv3VtFNYRIZgqKCwWUWduixTo8-BG4m1o3SeM3WezqV-KkAqYrZ0RKMtLwA72nT3l0513g8EeBPX4KCGilofa6elKrlZZM.lMtM-OIZeOQNPlcH14mpgq0LWaPoSAf59bMiVLtCH8U&dib_tag=se&hvadid=599764260705&hvdev=c&hvlocphy=1012763&hvnetw=g&hvqmt=b&hvrand=283998168278106585&hvtargid=kwd-315029080270&hydadcr=8055_2265079&keywords=scrikss%2Bgraph%2Bx&qid=1716714735&sr=8-5&th=1";
    String urltrendyol = "https://www.trendyol.com/scrikss/versatil-kalem-metal-graph-x-0-7mm-kursun-gri-p-1797005";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZEYNEP BÖLÜKBAŞI\\OneDrive\\Masaüstü\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void comparePrices() {
        // Get price from n11
        driver.get(urln11);
        WebElement pricen11Element = driver.findElement(By.cssSelector("#unf-p-id > div > div:nth-child(2) > div.unf-p-cvr > div.unf-p-left > div > div.unf-p-detail > div.unf-price-cover > div.price-cover > div.price > div > div > div.newPrice > ins"));
        double pricen11 = parsePrice(pricen11Element.getText());

        // Get price from Amazon
        driver.get(urlAmazon);
        WebElement priceAmazonElement = driver.findElement(By.cssSelector("#corePriceDisplay_desktop_feature_div > div.a-section.a-spacing-none.aok-align-center.aok-relative > span.a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay > span:nth-child(2) > span.a-price-whole"));
        double priceAmazon = parsePrice(priceAmazonElement.getText());

        // Get price from Trendyol
        driver.get(urltrendyol);
        WebElement pricetrendyolElement = driver.findElement(By.cssSelector("#product-detail-app > div > div.flex-container > div > div:nth-child(2) > div:nth-child(2) > div > div.product-detail-wrapper > div.pr-in-w > div > div > div.product-price-container > div > div > span"));
        double pricetrendyol= parsePrice(pricetrendyolElement.getText());

        // Compare prices
        double minPrice = Math.min(Math.min(pricen11, priceAmazon), pricetrendyol);
        double maxPrice = Math.max(Math.max(pricen11, priceAmazon), pricetrendyol);
        double avgPrice = (pricen11 + priceAmazon + pricetrendyol) / 3;


        System.out.println("Prices of the pencil *Scrikss* from three different sites:");
        System.out.println("n11: TL " + pricen11);
        System.out.println("Amazon: TL " + priceAmazon);
        System.out.println("Trendyol: TL " + pricetrendyol);
        System.out.println("***********************************************************");
        System.out.println("Cheapest Price: TL " + minPrice);
        System.out.printf("Average Price: TL %.2f \n", avgPrice);
        System.out.println("Most Expensive Price: TL " + maxPrice);

        // Assert that prices were found and compared
        Assert.assertTrue(pricen11 > 0);
        Assert.assertTrue(priceAmazon > 0);
        Assert.assertTrue(pricetrendyol > 0);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private double parsePrice(String priceText) {
        // Example parsing method, should be adapted to the actual price format
        priceText = priceText.replaceAll("[^\\d,]", "").replace(",", ".");
        return Double.parseDouble(priceText);
    }
}
