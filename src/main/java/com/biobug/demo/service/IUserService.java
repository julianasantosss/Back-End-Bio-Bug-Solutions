package com.biobug.demo.service;

import com.biobug.demo.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getUsers();
    public void saveUser(User user);
    public void deleteUser(Long idUser);
    public User findUser(Long idUser);
    public void updateUser(Long newIdUser, String newPasswordUser, String newEmailUser, String newNameUser);
    public void editUser(User user);
    public User userVerifier(String email, String password);
}
