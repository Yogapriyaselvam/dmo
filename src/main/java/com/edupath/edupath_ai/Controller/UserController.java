package com.edupath.edupath_ai.Controller;

import com.edupath.edupath_ai.model.User;
import com.edupath.edupath_ai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") 
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Registration
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists!");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    // Login
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    // 🔹 Forgot Password / Reset Password
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser == null) {
            return ResponseEntity.badRequest().body("Email not found!");
        }

        existingUser.setPassword(user.getPassword());
        userRepository.save(existingUser);

        return ResponseEntity.ok("Password updated successfully!");
    }
}
