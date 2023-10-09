package tests;

import manager.ProviderData;
import models.User;
import models.UserModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition (){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test(groups = {"positive"})
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withEmail("vitya"+i+"@mail.com").withPassword("Oo54321$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(5000);
        logger.info("registrationPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }
    @Test(groups = {"positive"}, dataProvider = "registrationCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveTestCSV(UserModel userModel) {
        String email = userModel.getEmail();
        String password = userModel.getPassword();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        logger.info("registrationPositiveTest starts with:" + email + " & " + password);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("vitya"+i+"mail.com","Oo54321$");
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}

