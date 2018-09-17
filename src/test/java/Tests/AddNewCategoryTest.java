package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class AddNewCategoryTest extends  BaseTest {
    @Test(priority = 9, description = "Add new category in the products category list")
    public void test9() {
        app.homePage.clickButtonSet();
        app.homePage.scroll();
        app.settingsPage.setCategory("Categories List");
        boolean d= app.settingsPage.setCategoryGood("Alfa");
        Assert.assertTrue(d);
        app.commonHeler.backButtonTwice();
        app.commonHeler.backButton();
        app.homePage.createNewList("Victory");
        int u = app.createList.addNewproductToList("Cat food", "22", "1", "box", "For my kitty", "Alfa");
        Assert.assertEquals(u, app.createList.getCheckPrice());
        app.commonHeler.backButtonTwice();




    }
}