package test.ui.ru.yandex;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import test.ui.WebDriverSettings;
import test.ui.pageObject.yandexResultSearch;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings {
    @Test
    public void testWithStep() {
        yandexResultSearch yandexPage= new yandexResultSearch(driver, "Гладиолус");
        List<Map<String,Object>> resultsSearch = yandexPage.getCollectResult();
        Steps.checkContainsLink(driver,resultsSearch, "wikipedia.org");
    }

   // @Test
    public void chekExchangeRate (){
        yandexResultSearch yandexPage= new yandexResultSearch(driver, "Гладиолус");
        List<Map<String,Object>> resultsSearch = yandexPage.getCollectResult();
    //    System.out.println(resultsSearch);
        Assert.assertTrue("URL not found",
                resultsSearch.stream().anyMatch(x ->x.get("URL").toString().contains("wikipedia.org"))
                );

    //    System.out.println(resultsSearch.size());
        for (Map<String, Object> we:resultsSearch)
            System.out.println(we);
    }

}
