package anonym;

import anonym.model.Gender;
import anonym.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("mukhammedtoichubai", "password", "210719970003", Gender.MALE));
        list.add(new User("ulankybanych", "password", "2199819970003", Gender.MALE));
    }
}
