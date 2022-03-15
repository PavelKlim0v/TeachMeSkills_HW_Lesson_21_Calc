package com.teachmeskills.lesson_21.calc.service;

import com.teachmeskills.lesson_21.calc.entity.User;
import com.teachmeskills.lesson_21.calc.storage.UserStorage;

public class UserService {

    private static final UserStorage userStorage = new UserStorage();

    public boolean add(User user) {
        if(userStorage.isExistsByLogin(user.getLogin())) {
            return false;
        }
        userStorage.save(user);
        return true;
    }

    public User findUserByLogin(String login) {
        return userStorage.findByLogin(login);
    }

}
