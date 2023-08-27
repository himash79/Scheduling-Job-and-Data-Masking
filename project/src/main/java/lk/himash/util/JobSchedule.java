package lk.himash.util;

import lk.himash.model.User;
import lk.himash.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class JobSchedule {

    @Scheduled(cron = "0/5 * * * * ?")
    public void changeUserStatus() {
        for (User user : UserService.userList) {
            boolean newStatus = !user.isStatus();
            user.setStatus(newStatus);
        }
        log.info("Users status changed ");
    }

}
