package com.biobug.demo.service;

import com.biobug.demo.model.User;
import com.biobug.demo.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> userList;
        userList = userRepository.findAll();
        return userList;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);

    }

    @Override
    public User findUser(Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        return user;
    }

    @Override
    public void updateUser(Long newIdUser, String newPasswordUser, String newEmailUser, String newNameUser) {
        User user = userRepository.getReferenceById(newIdUser);
//        user.setPasswordUser(newPasswordUser);
//        user.setEmailUser(newEmailUser);
//        user.setNameUser(newNameUser);

        if (newPasswordUser != null){
            user.setPasswordUser(newPasswordUser);
        }

        if (newEmailUser != null){
            user.setPasswordUser(newPasswordUser);
        }

        if(newNameUser != null){
            user.setNameUser(newNameUser);
        }

        userRepository.save(user);

    }
    @Transactional
    @Override
    public void editUser(User user) {
        User user1 = userRepository.getReferenceById(user.getIdUser());

        if (user1 != null){
            user1.editUser(user);
        }
    }


}
