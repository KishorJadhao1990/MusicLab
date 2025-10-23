package com.eao.musiclab.api;

import com.eao.musiclab.bo.UserBO;
import com.eao.musiclab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserBO userBO) {
        userService.save(userBO);
        return ResponseEntity.ok("User created successfully.");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserBO> editUserInfo(@PathVariable String id,
                                               @RequestBody UserBO userBO) {
        UserBO updatedUserBo = userService.editUser(id, userBO);
        return ResponseEntity.ok(updatedUserBo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserBO> getUser(@PathVariable String id) {
        UserBO userBO = userService.getUser(id);
        return ResponseEntity.ok(userBO);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserBO>> getUserList() {
        List<UserBO> userBO = userService.getUsers();
        return ResponseEntity.ok(userBO);
    }
}
