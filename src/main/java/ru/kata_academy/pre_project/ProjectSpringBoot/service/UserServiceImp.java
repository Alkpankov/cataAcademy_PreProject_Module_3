package ru.kata_academy.pre_project.ProjectSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata_academy.pre_project.ProjectSpringBoot.dao.UserDao;
import ru.kata_academy.pre_project.ProjectSpringBoot.model.User;
import ru.kata_academy.pre_project.ProjectSpringBoot.repositories.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
//        return userRepository.findAll();
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
//        userRepository.save(user);
        userDao.add(user);
    }
    @Transactional
    @Override
    public void update(long id, User updatedUser) {
//        updatedUser.setId(id);
//        userRepository.save(updatedUser);
        userDao.update(id, updatedUser);
    }
    @Transactional
    @Override
    public void delete(long id) {
//        userRepository.deleteById(id);
        userDao.delete(id);
    }

    @Override
    public User get(long id) {
//        Optional<User> user = userRepository.findById(id);
//        return user.orElse(null);
        return userDao.get(id);
    }
}
