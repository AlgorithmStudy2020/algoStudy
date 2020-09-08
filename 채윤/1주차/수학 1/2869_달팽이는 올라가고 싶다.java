import java.util.*;
import java.io.*;

//달팽이가 낮에 A미터를 올라가고 밤에 B미터를 미끄러질 때 
//V터를 올라가려면 총 며칠?
public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int day=(v-a)/(a-b)+1;
        //v에서 도착 마지막 날에 한 번에 올라가는 a미터를 빼고 day에 +1
        if(((double)(v-a)/(a-b))%1>0){day++;}
        //날짜는 무조건 올림해야 하기 때문

        System.out.print(day);  
    }
}