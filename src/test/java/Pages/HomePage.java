package Pages;


import Helpers.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import static Helpers.Utils.*;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "com.slava.buylist:id/button1")
    private WebElement btnPreferences;

    @FindBy(id = "com.slava.buylist:id/editText1")
    private WebElement textField;

    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement btnAdd;

    @FindBy(id = "com.slava.buylist:id/imageView2")
    private WebElement btnEdit;

    @FindBy(id = "com.slava.buylist:id/title")
    private WebElement listName;

    @FindBy(id = "com.slava.buylist:id/str1")
    private WebElement listInfo;

    @FindBys(@FindBy(id = "com.slava.buylist:id/imageView1"))
    private List<WebElement> listDelete;

    @FindBy(id = "android:id/button1")
    private WebElement Yes;

    @FindBy(id = "android:id/button2")
    private WebElement No;

    @FindBys(@FindBy(id = "com.slava.buylist:id/title"))
    private List<WebElement> listLists;

    @FindBy(className = "android.widget.EditText")
    private WebElement listChangeNameField;

    @FindBy(id = "com.slava.buylist:id/str1")
    private WebElement stringInfoList;

    @FindBys(@FindBy(id = "com.slava.buylist:id/title"))
    private List<WebElement> listOfList;


    @FindBy(className = "android.widget.LinearLayout")
    private WebElement settings;

    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement exitFromApp;

    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement btnDone;


    public int buylists() {
        return listLists.size();
    }

    public boolean isContainList(String name) {
        return  listLists.stream().anyMatch(element -> element.getAttribute("text").matches(name));
    }


    public CreateList createNewList(String listName, String orientation) {
        textField.sendKeys(listName);
        if ("Horizontal".equals(orientation)) {
            tap(0.901, 0.266);
            tap(0.9, 0.3);
        } else {
            btnAdd.click();
        }
        return new  CreateList();
    }

    public HomePage deleteList() {
        listDelete.get(1).click();
        Yes.click();
        return  this;
    }

    public HomePage renameList(String newNameList) {
        btnEdit.click();
        listChangeNameField.clear();
        listChangeNameField.sendKeys(newNameList);
        Yes.click();
        return this;
    }

    public String infoList() {
        return stringInfoList.getText();
    }

    public CreateList openList(String name) {
        listOfList.stream().filter(item -> item.getText().equals(name)).forEach(item -> item.click());
        return new CreateList();
    }


    public SettingsPage clickButtonSet() {
        btnPreferences.click();
        settings.click();
        return new SettingsPage();
    }

   public HomePage backButtonTwiceZ(){
        backButtonTwice();
        return this;
    }

    public HomePage backButtonZ(){
        backButton();
        return this;
    }


}



