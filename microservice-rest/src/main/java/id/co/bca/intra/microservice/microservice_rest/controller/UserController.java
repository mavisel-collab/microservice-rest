package id.co.bca.intra.microservice.microservice_rest.controller;

import id.co.bca.intra.microservice.microservice_rest.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {
    public HashMap<String, User> userHashMap= new HashMap<>();

    @GetMapping("/user")
    public User getUser(@RequestParam String id) {
        return userHashMap.get(id);
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestParam String id, @RequestParam String name) {
        User user = new User(id, name);
        return userHashMap.put(id, user);
    }
}
