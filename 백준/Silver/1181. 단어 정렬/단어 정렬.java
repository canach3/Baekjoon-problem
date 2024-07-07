import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, comparator);

        System.out.println(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(arr[i - 1])) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }

    static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String str1, String str2) {
            if (str1.length() == str2.length()) {
                return str1.compareTo(str2);
            }

            return str1.length() - str2.length();
        }
    };
}