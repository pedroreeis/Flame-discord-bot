package com.pedroreis.Managers;

import com.pedroreis.Models.UserModel;

import java.util.HashMap;

public class UserManager {

    public HashMap<String, UserModel> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public UserModel createUser(String userId, String userTag) {
        UserModel user = new UserModel(userId, userTag);
        this.users.put(userId, user);
        return user;
    }

    public UserModel getUser(String userId) {
        if(this.users.containsKey(userId)) {
            return this.users.get(userId);
        }
        return null;
    }

    public UserModel deleteUser(String userId) {
        if(this.users.containsKey(userId)) {
            return this.users.remove(userId);
        }

        return null;
    }
}
