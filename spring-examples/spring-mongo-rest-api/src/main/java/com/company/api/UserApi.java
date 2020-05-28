package com.company.api;

import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserService userService ;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init(){
        UserEntity userEntity =new UserEntity();
        userEntity.setName("Haydi");
        userEntity.setSurname("Kodlayalim");
        userService.add(userEntity);
    }

    @PostMapping
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.add(userEntity));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
