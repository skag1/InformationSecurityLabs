import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int a = 23,
                b = 7,
                c = 256,
                t0 = 131;
        String P1 = "0123456789",
                P2 = "9876543210",
                P3 = "1000005",
                P4 = "1500000";
        String[] array = new String[]{P1, P2, P3, P4};

        for (int s = 0; s < array.length; s++) {
            String word = array[s];
            int temp = 0;
            for (int i = 0; i < word.length(); i++) {
                temp += word.charAt(i);
            }
            System.out.println("KSumm " + word);
            System.out.println(KSumm(temp, c));

            ArrayList<Integer> list = new ArrayList<>();
            list.add(t0);
            for (int i = 1; i < word.length(); i++) {
                int ti = (list.get(i - 1) * a + b) % c;
                list.add(ti);
            }
            int temp2 = 0;
            for (int i = 0; i < list.size(); i++) {
                temp2 += (int)word.charAt(i) ^ list.get(i);
            }
            System.out.println("SummKodBukvOtkr " + word);
            System.out.println(KSumm(temp2, c));
        }
    }
    public static int KSumm(int K, int MaxVal){
        if(K < MaxVal)return K;
        else return K % MaxVal;
    }
}