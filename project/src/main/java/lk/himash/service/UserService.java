package lk.himash.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lk.himash.model.User;
import lk.himash.util.JobSchedule;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final ObjectMapper objectMapper;
    private final JobSchedule jobSchedule;

    public static List<User> userList = new ArrayList<>();


    public ResponseEntity<Object> fetchAllUsers() throws IOException {
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostConstruct
    public void changeUserStatus() throws IOException {
        jobSchedule.changeUserStatus();
    }

    @PostConstruct
    public void fetchUsers() throws IOException {
        File file = new File("E:\\Github projects\\project\\src\\main\\resources\\users.json");
        List<User> users = objectMapper.readValue(file,new TypeReference<List<User>>() { });
        userList.addAll(users);
        log.info("Mapped users : " + userList.size());
    }

}
