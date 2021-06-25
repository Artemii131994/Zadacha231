package mvc.dao;

import mvc.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();
    public void saveUser(User user);
    public User getUser(Long id);
    public void update(User user);
    public void deleteUser(Long id);
}
