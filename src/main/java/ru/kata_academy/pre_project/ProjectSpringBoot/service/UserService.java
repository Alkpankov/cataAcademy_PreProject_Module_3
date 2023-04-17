package ru.kata_academy.pre_project.ProjectSpringBoot.service;


import ru.kata_academy.pre_project.ProjectSpringBoot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void update(long id, User user);
    void delete(long id);
    User get (long id);
}
