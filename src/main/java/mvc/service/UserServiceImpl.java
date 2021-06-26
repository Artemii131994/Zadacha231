package mvc.service;

import mvc.dao.UserDAOImpl;
import mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOImpl userDAO;

    @Override

    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override

    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override

    public void update(User user) {
        userDAO.update(user);
    }

    @Override

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
