package pro.sky.java.course2.employeebook.service;

public interface UserMessageService {
    String showAddMessage(String firstName, String lastName);
    String showRemoveMessage(String firstName, String lastName);
    String showGreetings();
}
