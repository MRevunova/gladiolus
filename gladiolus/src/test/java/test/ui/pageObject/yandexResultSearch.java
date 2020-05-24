package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class yandexResultSearch {

  //  private String sectorSearchItem = "//li[@class=\"serp-item\"]";
    private String sectorSearchItem = "//div[@class=\"wrapper wrapper_thumb-position_right\"]";

    private String selectorURL = ".//a[@href]";
    private String selectorNamePage = ".//h2";
    private String selectorDiscription = ".//div[@class=\"text-container typo typo_text_m typo_line_m organic__text\"]";
// //div[@class='wrapper__cell wrapper__cell_type_content clearfix']//h2
    private WebDriver driver;
    private List<WebElement> webSearchItem = new ArrayList();
    private List<Map<String,Object>> collectResult = new ArrayList<>();

    public yandexResultSearch (WebDriver driver, String search) {
        this.driver = driver;
        driver.get("https://yandex.ru/search/?text="+search);
        webSearchItem = driver.findElements(By.xpath(sectorSearchItem));
    }

    public yandexResultSearch (WebDriver driver) {
        this.driver = driver;
        webSearchItem = driver.findElements(By.xpath(sectorSearchItem));
    }

    public List<Map<String, Object>> getCollectResult() {
        for (WebElement result : webSearchItem){
         //   System.out.println("result = "+result);
          // System.out.println("selectorURL "+selectorURL);
            collectResult.add(Map.of(
                    "WEB_ELEMENT", result,
                    "URL", result.findElement(By.xpath(selectorURL)).getAttribute("href"),
                    "NAME_PAGE", result.findElement(By.xpath(selectorNamePage)).getText(),
                    "DISCRIPTION", result.findElement(By.xpath(selectorDiscription)).getText()
            ));
        }
        return collectResult;
    }
}
