package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;

@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Override
    public String showGreetings() {
        return "Добро пожаловать!";
    }

}
