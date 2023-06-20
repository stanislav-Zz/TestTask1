package org.example.dao;




import org.example.entity.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    void updateUser(User user);
}
