import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        // "-" 를 기준으로 구간을 나눔
        String[] sArr = input.split("-");

        int result = 0;

        for (int i = 0; i < sArr.length; i++) {
            int temp = sum(sArr[i]);

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }

    static int sum(String s) {
        String[] temp = s.split("[+]");

        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}