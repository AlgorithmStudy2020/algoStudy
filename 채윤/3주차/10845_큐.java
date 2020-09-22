import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Deque<Integer> q = new LinkedList<>();

    while(n>0){
      String s = sc.next();

      switch(s){
        case "push":
        int x = sc.nextInt();
        q.offer(x);
        break;

        case "pop":
        if(q.isEmpty()){
          System.out.println(-1);
        }else{
          System.out.println(q.poll());
        }
        break;

        case "size":
        System.out.println(q.size());
        break;

        case "empty":
        if(q.isEmpty()){
          System.out.println(1);
        }else{
          System.out.println(0);
        }
        break;

        case "front":
        if(q.isEmpty()){
          System.out.println(-1);
        }else{
          System.out.println(q.peek());
        }
        break;

        case "back":
        if(q.isEmpty()){
          System.out.println(-1);
        }else{
          System.out.println(q.peekLast());
        }
      }
      n--;
    }

  }
}