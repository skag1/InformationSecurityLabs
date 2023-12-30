import java.util.*;

public class Main {
    public static void main(String[] args) {
        String numbers = "0123456789",
                specialSymbols = "!”#$%&’()*",
                engBigLetters = "QWERTYUIOPASDFGHJKLZXCVBNM",
                engSmallLetters = "qwertyuiopasdfghjklzxcvbnm",
                temp,
                A = "",
                password = "";

        Double P = Math.pow(10, -6),
                V = 10.0,
                T = 5 * 24 * 60.0;

        long S_,
                L = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Include numbers? Type yes or no");
        temp = scanner.nextLine();
        if (Objects.equals(temp, "yes")) A += numbers;

        System.out.println("Include specialSymbols? Type yes or no");
        temp = scanner.nextLine();
        if (Objects.equals(temp, "yes")) A += specialSymbols;

        System.out.println("Include engBigLetters? Type yes or no");
        temp = scanner.nextLine();
        if (Objects.equals(temp, "yes")) A += engBigLetters;

        System.out.println("Include engSmallLetters? Type yes or no");
        temp = scanner.nextLine();
        if (Objects.equals(temp, "yes")) A += engSmallLetters;

        S_ = (long) Math.ceil(V * T / P);

        while (Math.pow(A.length(), L) < S_){
            L++;
        }

        Random random = new Random();

        for (int i = 0; i < L; i++) {
            password += A.charAt(random.nextInt(A.length()));
        }

        System.out.println(password);
    }
}