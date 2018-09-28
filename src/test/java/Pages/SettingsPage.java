package Pages;


import Helpers.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


public class SettingsPage extends Utils {

    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement btnAddCategory;

    @FindBy(className = "android.widget.EditText")
    private WebElement textNameCategory;

    @FindBy(id = "android:id/button1")
    private WebElement btnOk;

    @FindBys(@FindBy(id = "com.slava.buylist:id/title"))
    private List<WebElement> listCategory;

    @FindBys(@FindBy(id = "android:id/title"))
    private List<WebElement> listRemoveSettings;

    @FindBys(@FindBy(id = "android:id/text1"))
    private List<WebElement> choseOrientation;

    @FindBys(@FindBy(id = "android:id/title"))
    private List<WebElement> categorySettings;

    @FindBys(@FindBy(id = "android:id/text1"))
    private List<WebElement> currencyList;


    public SettingsPage clickListRemoveSettings() {
        for (int i = 0; i < listRemoveSettings.size(); i++) {
            String d = listRemoveSettings.get(i).getText();
            if ("Units".equals(d)) {
                listRemoveSettings.get(i).click();
                listRemoveSettings.get(i + 1).click();
                listRemoveSettings.get(i + 2).click();
            }
        }
        return new SettingsPage();
    }

    public HomePage ChangeOrientation(String name) {
        for (int i = 0; i < listRemoveSettings.size(); i++) {
            String d = listRemoveSettings.get(i).getText();
            if ("Orientation".equals(d)) {
                listRemoveSettings.get(i).click();
            }
        }
        if ("Horizontal".equals(name)) {
            choseOrientation.get(0).click();
        } else if ("Vertical".equals(name)) {
            choseOrientation.get(1).click();
        }
        return new HomePage();
    }

    public HomePage addNewCategoryGoods(String category, String option) {
        scroll();
        categorySettings.stream().filter(item -> item.getText().equals(category)).forEach(item -> item.click());
        btnAddCategory.click();
        textNameCategory.sendKeys(option);
        btnOk.click();
        backButton();
        return backButtonTwice();
    }


    public SettingsPage setCategoryCurrency(String category, String option) {
        categorySettings.stream().filter(item -> item.getText().trim().equals(category)).findFirst().get().click();
        currencyList.stream().filter(items -> items.getText().trim().equals(option)).findFirst().get().click();
        return new SettingsPage();
    }

}














