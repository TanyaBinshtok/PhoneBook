package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class UserModel {

    String email;
    String password;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
