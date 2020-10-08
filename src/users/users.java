package users;

import java.sql.Struct;

public class users {

    private String userName = "";
    private String userSurname = "";
    private String email = "";

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserSurname(String newUserSurname) {
        this.userSurname = newUserSurname;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getEmail() {
        return email;
    }
}
