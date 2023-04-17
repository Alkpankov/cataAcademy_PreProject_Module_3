package ru.kata_academy.pre_project.ProjectSpringBoot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata_academy.pre_project.ProjectSpringBoot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
