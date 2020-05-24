package test.ui.ru.yandex;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import test.CustimUtils;

import java.util.List;
import java.util.Map;

public class Steps {
    @Step
            ("Проверка наличия ссылки {link}")
    public static void checkContainsLink(WebDriver driver,List<Map<String, Object>> resultsSearch, String link){
        Assert.assertTrue("URL not found",
                resultsSearch.stream().anyMatch(x -> x.get("URL").toString().contains(link))
        );
        CustimUtils.getScreen(driver);
    }
}
