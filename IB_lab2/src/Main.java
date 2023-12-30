import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<User> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new User("skag", 12345678, "Arinkin Andrey Vladimirovich",
                "06.05.2003", "Yakustk", "88005553535"));
        registerUser();
        authorizeUser();
    }

    public static void registerUser() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создание нового пользователя");
        System.out.println("Введите имя пользователя");
        String nickName = scanner.nextLine();
        while (!checkNickName(nickName)) {
            nickName = scanner.nextLine();
        }
        user.setNickName(nickName);

        System.out.println("Введите пароль, пароль должен содержать 8 цифр");
        String password = scanner.nextLine();
        while (!checkPassword(password)){
            password = scanner.nextLine();
        }
        user.setPassword(Integer.parseInt(password));

        System.out.println("Введите ФИО");
        String FIO = scanner.nextLine();
        System.out.println("Введите дату рождения");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите место рождения");
        String placeOfBirth = scanner.nextLine();
        System.out.println("Введите номер телефона");
        String phoneNumber = scanner.nextLine();
        user.setFIO(FIO);
        user.setDateOfBirth(dateOfBirth);
        user.setPlaceOfBirth(placeOfBirth);
        user.setPhoneNumber(phoneNumber);

        list.add(user);
        System.out.println("Пользователь успешно добавлен");
    }

    public static void authorizeUser(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Авторизация");
        System.out.println("Введите никнейм пользователя");
        String nickName = scanner.nextLine();
        while (!checkAuthorizeNickName(nickName)){
            nickName = scanner.nextLine();
        }
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        int realPassword = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNickName().equals(nickName)){
                user = list.get(i);
                realPassword = list.get(i).getPassword();
            }
        }
        while (Integer.parseInt(password) != realPassword){
            System.out.println("Неверный пароль, введите заново");
            password = scanner.nextLine();
        }

        System.out.println("Введите аутентификационный пароль");
        String autho = scanner.nextLine();
        while (Integer.parseInt(autho) != user.getPassword() + 5){
            autho = scanner.nextLine();
        }

        System.out.println("Вывести информацию о пользователе? Введите да или нет");
        if(scanner.nextLine().equals("да")){
            assert user != null;
            System.out.println(user.getNickName());
            System.out.println(user.getPassword());
            System.out.println(user.getFIO());
            System.out.println(user.getDateOfBirth());
            System.out.println(user.getPlaceOfBirth());
            System.out.println(user.getPhoneNumber());
        }
        System.out.println("Поменять пароль? Введите да или нет");
        if(scanner.nextLine().equals("да")){
            String newPassword = scanner.nextLine();
            while (!checkPassword(newPassword)){
                newPassword = scanner.nextLine();
            }
            user.setPassword(Integer.parseInt(newPassword));
            System.out.println("Пароль успешно изменен");
        }
    }

    public static boolean checkNickName(String nickName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNickName().equals(nickName)) {
                System.out.println("Пользователь с таким никнеймом уже сущесвтует");
                System.out.println("Введите заново");
                return false;
            }
        }
        return true;
    }

    public static boolean checkAuthorizeNickName(String nickName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNickName().equals(nickName)) {
                return true;
            }
        }
        System.out.println("Пользователя с таким никнеймом не существует");
        return false;
    }

    public static boolean checkPassword(String password){
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if(!(c >= 49 && c <= 57)){
                System.out.println("Все символы должны быть цифрами");
                System.out.println("Введите заново");
                return false;
            }
        }
        if(password.length() == 8) return true;
        else {
            System.out.println("Пароль должен содержать 8 цифр");
            System.out.println("Введите заново");
            return false;
        }
    }
}