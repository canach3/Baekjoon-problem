import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        List<Integer> operandList = new ArrayList<>();
        ArrayList<Character> operatorList = new ArrayList<>();

        String[] operandArr = input.split("[+;-]");
        for (int i = 0; i < operandArr.length; i++) {
            operandList.add(Integer.parseInt(operandArr[i]));
        }

        for (int i = 0; i < input.length(); i++) {
            char operator = input.charAt(i);

            if (operator == '-' || operator == '+') {
                operatorList.add(operator);
            }
        }

        int result = operandList.remove(0);
        int idx = 0;
        boolean isMinus = false;

        while (idx < operandList.size()) {
            if (operatorList.get(idx) == '-') {
                isMinus = true;
            }

            if (isMinus) {
                result -= operandList.get(idx);
            } else {
                result += operandList.get(idx);
            }

            idx++;
        }

        System.out.println(result);
    }
}