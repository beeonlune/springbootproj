package com.mysite.springbootproj.repository;

import com.mysite.springbootproj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Long>{
    List<User> findByLastName(String lastName);
}

/*
Этот код объявляет интерфейс UserRepo, который расширяет интерфейс JpaRepository
для сущности User и типа первичного ключа Long.
Интерфейс JpaRepository предоставляет готовые методы
для выполнения операций CRUD (create, read, update, delete)
с сущностями базы данных. Например, он содержит методы
для сохранения сущности, удаления по идентификатору,
поиска сущности по идентификатору и другие.
 */