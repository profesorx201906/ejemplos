package com.backend.banca.users.Repository;

import java.util.ArrayList;
import java.util.List;

import com.backend.banca.users.Entity.User;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    public List<User> findAll() {
        return users;
    }
    public User findById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public User save(User user) {
        users.add(user);
        return user;
    }
    public User update(User user) {
        int index = getUserIndex(user.getId());
        if (index != -1) {
            users.set(index, user);
            return user;
        }
        return null;
    }
    public boolean delete(String id) {
        int index = getUserIndex(id);
        if (index != -1) {
            users.remove(index);
            return true;
        }
        return false;
    }
    private int getUserIndex(String id) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
