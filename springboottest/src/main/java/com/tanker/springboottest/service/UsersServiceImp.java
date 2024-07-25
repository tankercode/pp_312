package com.tanker.springboottest.service;

import com.tanker.springboottest.model.User;
import com.tanker.springboottest.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersServiceImp implements UserService {

    private final UsersRepository usersRepository;
    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findOne(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public void update(int id, User tmp) {
        tmp.setId(id);
        usersRepository.save(tmp);
    }

    @Override
    public void deleteUserById(int id) {
        usersRepository.deleteById(id);
    }
}
