package org.example.service;



import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    void updateUser(User user);
}

