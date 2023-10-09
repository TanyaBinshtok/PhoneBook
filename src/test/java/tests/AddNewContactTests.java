package tests;

import manager.ProviderData;
import models.Contact;
import models.User;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if (!app.getHelperUser().isLogged())
            app.getHelperUser().login (new UserModel(
        app.getEmail(),app.getPassword()));
    }

    @Test(invocationCount = 5, groups = {"positive","smoke"})
    public void addNewContactPositive (){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("John")
                .lastName("Silver")
                .phone("12345678" + i)
                .email("john" + i + "@mail.com")
                .address("Rehovot")
                .description("Pirate")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }
    @Test(groups = {"positive","smoke"},dataProvider = "contactDTO",dataProviderClass = ProviderData.class)
    public void addNewContactPositiveDTO (Contact contact){
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }

}
