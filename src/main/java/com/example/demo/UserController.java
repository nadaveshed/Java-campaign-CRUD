package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List <User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity <User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {

//        try {
//            if (emailValidate(user.getEmail()) == "invalid" && phoneValidate(user.getTelephone()) == "invalid"){
//                System.out.println("error");
//            }
//        } catch (Exception exception){
//            throw missingDataExceptionHandler(exception);
//        }
//        if (emailValidate(user.getEmail()) == "invalid" && phoneValidate(user.getTelephone()) == "invalid"){
//            return null;
//        }
        return userRepository.save(user);
    }
    private String emailValidate(String email) {
        String regex = "^ [\\ w - \\.] + @ ( [\\ w -] + \\.) + [\\ w -] {2,4} $";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches() ? "valid" : "invalid";
    }

    private String phoneValidate(String phone) {
        String regex = "^ [+] * [(] {0,1} [0-9] {1,4} [)] {0,1} [- \\ s \\ ./ 0-9] * $";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phone).matches() ? "valid" : "invalid";
    }

}
