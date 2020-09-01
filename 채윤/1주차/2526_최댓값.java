import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size=9;
        Integer[] numbers = new Integer[size]; //크기가 9인 배열 선언
        for(int i=0;i<size;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        int max = numbers[0];
        for(int i=1;i<size;i++){
            if(max<numbers[i]){
                max=numbers[i];
            }
        } //최대값
        
        int index = Arrays.asList(numbers).indexOf(max); //primitive(기본타입) 배열을 arrayList로 치환 후 인덱스 검색
        
        bw.write(max+"\n"+(index+1)+"\n");
        bw.flush();
        bw.close();
    }
}