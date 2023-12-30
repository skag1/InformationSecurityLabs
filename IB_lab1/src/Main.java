import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String numbers = "0123456789",
                specialSymbols = "!”#$%&’()*",
                letterBig = "QWERTYUIOPASDFGHJKLZXCVBNM";

        Scanner scanner = new Scanner(System.in);
        int identifierNum = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < identifierNum; i++) {
            String password = "",
                    identifier = scanner.nextLine();

            int N = identifier.length(),
                    P = (N * N) % 10 + (N * N * N) % 10 + 1;

            char c = (char) (97 + P);

            Random random = new Random();

            //рандомные цифры от 0-9
            password += numbers.charAt(random.nextInt(numbers.length()));
            password += numbers.charAt(random.nextInt(numbers.length()));
            password += numbers.charAt(random.nextInt(numbers.length()));

            //рандомные символы из множества
            password += specialSymbols.charAt(random.nextInt(specialSymbols.length()));
            password += specialSymbols.charAt(random.nextInt(specialSymbols.length()));

            //рандомные английские большие буквы
            password += letterBig.charAt(random.nextInt(letterBig.length()));
            password += letterBig.charAt(random.nextInt(letterBig.length()));

            //малая английская буква от длины идентификатора
            password += c;

            map.put(identifier, password);
        }
        scanner.close();
        System.out.println(map);
    }
}