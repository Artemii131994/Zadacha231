package mvc.service;

import mvc.dao.UserDAOImpl;
import mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {


    private UserDAOImpl userDAO;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
