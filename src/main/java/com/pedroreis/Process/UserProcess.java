package com.pedroreis.Process;

import com.pedroreis.Database.Database;
import com.pedroreis.Main;
import com.pedroreis.Managers.UserManager;
import com.pedroreis.Models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProcess {

    private static Database database = Main.getMain().getDatabase();
    private static UserManager manager = Main.getMain().getUserManager();

    public static void loadUsers() {
        try {
            PreparedStatement stm = database.getConnection().prepareStatement(
                    "select * from discordbot_users"
            );

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String userId = rs.getString("userId");
                String userTag = rs.getString("userTag");

                manager.createUser(userId, userTag);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean containsUsersSQL(String userId) {
        try {
            PreparedStatement stm = database.getConnection().prepareStatement(
                    "select * from discordbot_users where userId = ?"
            );
            stm.setString(1, userId);
            return stm.executeQuery().next();
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void saveUsers() {
        PreparedStatement stm;
        try {
            for(UserModel user : manager.users.values()) {
                if(containsUsersSQL(user.getUserId())) {
                    stm = database.getConnection().prepareStatement(
                            "update discordbot_users set userTag = ? where userId = ?"
                    );

                    stm.setString(1, user.getUserTag());
                    stm.setString(2, user.getUserId());

                    stm.executeUpdate();
                }else {
                    stm = database.getConnection().prepareStatement(
                            "insert into discordbot_users(userId,userTag) VALUES(?,?)"
                    );

                    stm.setString(1, user.getUserId());
                    stm.setString(2, user.getUserTag());

                    stm.executeUpdate();
                }
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
