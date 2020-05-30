package com.company.api;

import com.company.entity.UserEntity;
import com.company.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct
    public void init(){
        UserEntity userEntity =new UserEntity();
        userEntity.setName("Haydi");
        userEntity.setSurname("Kodlayalim");
        userEntity.setAddress("test");
        userEntity.setBirthDate(Calendar.getInstance().getTime());
        userService.add(userEntity);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<UserEntity>> getUsers(@PathVariable String search){

        List<UserEntity> users = userService.getUsers(search);
        return ResponseEntity.ok(users);

    }
}
