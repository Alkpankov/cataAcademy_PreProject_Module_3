package ru.kata_academy.pre_project.ProjectSpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata_academy.pre_project.ProjectSpringBoot.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final EntityManager entityManager;
    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void update(long id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        User user = get(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }
}
