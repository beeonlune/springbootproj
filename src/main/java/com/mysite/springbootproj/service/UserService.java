package com.mysite.springbootproj.service;

import com.mysite.springbootproj.model.User;
import com.mysite.springbootproj.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired // конструктор, который внедряет зависимость от UserRepo с помощью аннотации @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User findById(Long id){
        //return userRepo.getReferenceById(id);
        return userRepo.getOne(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
