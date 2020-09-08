import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int num = a*b*c;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(num!=0){
            list.add(num%10);
            num/=10;
        }
        int[] arr = new int[10];
        for(int i=0;i<list.size();i++){
            switch(list.get(i)){
                case 0: arr[0]=arr[0]+1; break;
                case 1: arr[1]=arr[1]+1; break;
                case 2: arr[2]=arr[2]+1; break;
                case 3: arr[3]=arr[3]+1; break;
                case 4: arr[4]=arr[4]+1; break;
                case 5: arr[5]=arr[5]+1; break;
                case 6: arr[6]=arr[6]+1; break;
                case 7: arr[7]=arr[7]+1; break;
                case 8: arr[8]=arr[8]+1; break;
                case 9: arr[9]=arr[9]+1; break;  
            }
        }
        
        for(int i=0;i<arr.length;i++){
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
        
    }
}