package com.pedroreis.Managers;

import com.pedroreis.Models.UserModel;

import java.util.HashMap;

public class UserManager {

    public HashMap<Character, UserModel> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public UserModel createUser(Character userId, Character userTag) {
        UserModel user = new UserModel(userId, userTag);
        this.users.put(userId, user);
        return user;
    }

    public UserModel getUser(Character userId) {
        if(this.users.containsKey(userId)) {
            return this.users.get(userId);
        }
        return null;
    }

    public UserModel deleteUser(Character userId) {
        if(this.users.containsKey(userId)) {
            return this.users.remove(userId);
        }

        return null;
    }
}
