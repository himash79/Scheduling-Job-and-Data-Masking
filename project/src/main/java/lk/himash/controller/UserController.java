package lk.himash.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lk.himash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<Object> fetchAllUsers() throws IOException {
        return userService.fetchAllUsers();
    }

}
