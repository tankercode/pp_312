package com.tanker.springboottest.services;

import com.tanker.springboottest.models.User;
import com.tanker.springboottest.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User findOne(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        usersRepository.save(user);
    }

    public void update(int id, User tmp) {
        tmp.setId(id);
        usersRepository.save(tmp);
    }

    public void deleteUserById(int id) {
        usersRepository.deleteById(id);
    }
}
