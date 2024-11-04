package com.biobug.demo.controller;


import com.biobug.demo.dto.UserDTO;
import com.biobug.demo.dto.UserListDTO;
import com.biobug.demo.dto.UserLoginDTO;
import com.biobug.demo.model.User;
import com.biobug.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/user/get")
    public List<UserListDTO> getUser() {
        return iUserService.getUsers().stream().map(UserListDTO::new).toList();}
    @GetMapping("/user/get/{idUser}")
    public UserDTO getUser(@PathVariable Long idUser){
        return new UserDTO(iUserService.findUser(idUser));
    }
    @PostMapping("/user/create")
    private String saveUser (@RequestBody User user){
        iUserService.saveUser(user);
        return "El usuario ha sido creado con exito!";
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        iUserService.deleteUser(id);
        return "El usuario ha sido eliminado";
    }

    @PutMapping("user/update/{id}")
    public User updateUser(@PathVariable Long id,
                         @RequestParam(required = false, name = "Name")String name,
                         @RequestParam(required = false, name = "Email")String email,
                         @RequestParam(required = false, name = "Password")String password){
        iUserService.updateUser(id, name, email, password);
        User user = iUserService.findUser(id);
        return user;
    }

    @PutMapping("user/edit")
    public void updateUser(@RequestBody User user){ iUserService.editUser(user);}

    @PostMapping("user/login")
    public UserDTO login(@RequestBody UserLoginDTO userLoginDTO){
        return new UserDTO(iUserService.userVerifier(userLoginDTO.email(), userLoginDTO.password()));
    }

}
