package manager;

import models.User;
import models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//*[.='Sign Out']"));
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();
    }

    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys(password);
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
//        type(By.xpath("input[2]"), password);
    }
    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[1]"),user.getEmail() );
        type(By.xpath("//input[2]"),user.getPassword());
    }
    public void fillLoginRegistrationForm(UserModel userModel) {
        type(By.xpath("//input[1]"),userModel.getEmail() );
        type(By.xpath("//input[2]"),userModel.getPassword());
    }

//    public void fillRegistrationForm(String text,String text1, String password) {
//        typeRegistration(By.xpath("//input[1]"), text, text1);
//        type(By.xpath("//input[2]"), password);
//    }


    public void openLoginRegistrationForm() {
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }
    public void login (UserModel userModel){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(userModel);
        submitLogin();
    }
    public void login (String email, String password){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
    }

}
