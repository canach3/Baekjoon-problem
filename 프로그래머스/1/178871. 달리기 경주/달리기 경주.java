import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Node> map = new HashMap<>();

        // 1등 처리
        String head = players[0];
        Node first = new Node(null, players[1]);
        map.put(head, first);

        for (int i = 1; i < players.length - 1; i++) {
            Node node = new Node(players[i - 1], players[i  + 1]);
            map.put(players[i], node);
        }

        // 꼴등 처리
        String tail = players[players.length - 1];
        Node last = new Node(players[players.length - 2], null);
        map.put(tail, last);

        for (int i = 0; i < callings.length; i++) {
            String called = callings[i];



            Node curr = map.get(called);
            Node prev = map.get(curr.prev);
            Node next = map.get(curr.next);

            if (next != null) next.prev = curr.prev;
            if (prev.prev != null) map.get(prev.prev).next = called;

            prev.next = curr.next;
            curr.next = curr.prev;
            curr.prev = prev.prev;
            prev.prev = called;

            // 1등을 추월할 경우 head 업데이트
            if (curr.prev == null) head = called;
        }

        String[] answer = new String[players.length];

        String curr = head;
        int idx = 0;

        while (idx < players.length) {
            answer[idx++] = curr;
            curr = map.get(curr).next;
        }

        return answer;
    }

    static class Node {
        String prev;
        String next;

        public Node(String prev, String next) {
            this.prev = prev;
            this.next = next;
        }
    }
}