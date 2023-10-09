package manager;

import models.Contact;
import models.User;
import models.UserModel;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserModel.builder()
                        .email("vitya@mail.com")
                        .password("Oo54321$")
                        .build()});
        list.add(new Object[]{
                UserModel.builder()
                        .email("vitya@mail.com")
                        .password("Oo54321$")
                        .build()});
        list.add(new Object[]{
                UserModel.builder()
                        .email("vitya@mail.com")
                        .password("Oo54321$")
                        .build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactDTO(){
        List<Object[]> list = new ArrayList<>();
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        list.add(new Object[]{
                Contact.builder()
                        .name("Sema" + i)
                        .lastName("Abramov")
                        .phone("7534568" + i)
                        .address("Rehovot")
                        .description("Freand")
                        .email("ab_"+i+"@gmail.com")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Sema" + i)
                        .lastName("Abramov")
                        .phone("7534568" + i)
                        .address("Rehovot")
                        .description("Freand")
                        .email("ab_"+i+"@gmail.com")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/reg_dataset.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    UserModel.builder()
                            .email(split[0])
                            .password(split[1])
                            .build()
            });
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}
