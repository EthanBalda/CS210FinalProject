package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean login(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void createGroup(String name) {
        new Group(name, this);
    }

    public void joinGroup(Group group) {
        group.addUser(this);
    }

    public void leaveGroup(Group group) {
        group.removeUser(this);
    }

    public void invitePeople(List<User> people, Group group) {
        for (User user : people) {
            group.addUser(user);
        }
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() { return username; }

}

