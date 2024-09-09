import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Member> memberList = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Member member = new Member();
            member.age = sc.nextInt();
            member.name = sc.next();
            memberList.add(member);
        }

        Collections.sort(memberList);

        for (Member member : memberList) {
            System.out.println(member);
        }
    }
}
class Member implements Comparable<Member>{
    int age;
    String name;

    @Override
    public int compareTo(Member member) {
        return this.age - member.age;
    }

    @Override
    public String toString() {
        return this.age + " " + this.name;
    }
}