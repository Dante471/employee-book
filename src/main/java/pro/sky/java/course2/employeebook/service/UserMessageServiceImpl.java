package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;

@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Override
    public String showAddMessage(String firstName, String lastName) {
        return String.format("Сотрудник %s %s успешно добавлен!", firstName, lastName);
    }

    @Override
    public String showRemoveMessage(String firstName, String lastName) {
        return String.format("Сотрудник %s %s успешно удалён!", firstName, lastName);
    }

    @Override
    public String showGreetings() {
        return "Добро пожаловать!";
    }

}
