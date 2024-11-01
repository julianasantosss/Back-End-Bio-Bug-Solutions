package com.biobug.demo.controller;

import com.biobug.demo.model.User;
import com.biobug.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/user/get")
    public List<User> getUser() {return iUserService.getUsers();}

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


}
