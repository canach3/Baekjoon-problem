import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine()); 
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); 
            String[] phoneBook = new String[n];
            
            for (int i = 0; i < n; i++) {
                phoneBook[i] = br.readLine();
            }
            
            Arrays.sort(phoneBook);
            
            boolean isConsistent = true;
            
            for (int i = 0; i < n - 1; i++) {
                if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                    isConsistent = false;
                    break;
                }
            }
            
            if (isConsistent) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}