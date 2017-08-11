package com.soft.model;

import lombok.Data;

import java.util.List;

/**
 * Created by admin on 2017/8/1.
 */
@Data
public class User {

    private Integer id;

    private String userName;

    private String password;

    private String nickName;

    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void printList (List<User> list) {
        if (null == list || 0 == list.size()) {
            System.out.println("no data!!");
            return;
        }

        for (User user: list) {
            System.out.println(user.toString());
        }
    }
}
