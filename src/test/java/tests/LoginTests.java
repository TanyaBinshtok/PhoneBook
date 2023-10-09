package tests;

import manager.NGListener;
import manager.ProviderData;
import models.UserModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class LoginTests extends TestBase {


    @Test(groups = {"positive"})
    public void loginPositiveTest(){

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vitya@mail.com","Oo54321$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"positive"})
    public void loginPositiveTestModel(){
        UserModel userModel = UserModel.builder().build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vitya@mail.com","Oo54321$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }
    @Test(groups = {"positive"},dataProvider = "userDTO",dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(UserModel userModel){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(userModel.getEmail(),userModel.getPassword());
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }
    @Test(groups = {"positive"})
    public void loginPositiveTestProps(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(app.getEmail(),app.getPassword());
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"negative","smoke"})
    public void loginNegativeTestWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vityamail.com","Oo54321$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void loginNegativeTestWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vity@amail.com","Oo54321");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }

}

