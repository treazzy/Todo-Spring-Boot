package todoapp.todoapp.controller;


import todoapp.todoapp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import todoapp.todoapp.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    private UserEntity getUser(@RequestBody UserEntity user){
        System.out.println("GET User by username and password *****");
        return (UserEntity) userService.getUser(user);
    }

    @GetMapping("/login{username}/{password}")
    private boolean addUser(@RequestBody UserEntity  user){
        boolean user_exists = userService.findUserByUsername(user.getUsername());
        if (user_exists){
            System.out.println("CANT CREATE USER!");
            return false;
        }
        userService.saveUser(user);
        return true;
    }
}
