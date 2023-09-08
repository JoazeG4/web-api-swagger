package dio.webapiswagger.controller;

import dio.webapiswagger.model.User;
import dio.webapiswagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public User getOne(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteByUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @PostMapping
    public void postUser(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userRepository.save(user);
    }
}
