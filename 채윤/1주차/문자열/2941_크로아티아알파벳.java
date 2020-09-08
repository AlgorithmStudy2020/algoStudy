import java.util.*;
import java.io.*;

//총 글자 수 구하기
//c=,c-,d=,dz=,d-,lj,nj,s=,z=을 한 글자로 취급
public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] input = s.toCharArray(); //문자들을 char 배열에 하나씩 저장
        int count = input.length; //총 글자 수 = 문자 개수로 초기화
        for(int i=0;i<input.length-1;i++){
            switch(input[i]){
                case 'c': if(input[i+1]=='='||input[i+1]=='-'){count--; i++;} //'c=' 또는 'c-'가 나오는 경우 총 글자 수-1
                    break;
                case 'd': if(input[i+1]=='-'){count--; i++;} //'d-'가 나오는 경우 -1
                    else if(i+2<input.length&&input[i+1]=='z'&&input[i+2]=='='){count--;}//'dz='가 나오는 경우 -1('z='에서 한번 더 -1)
                    break;
                case 'l':
                case 'n': if(input[i+1]=='j'){count--; i++;} //'lj' 또는 'nj'가 나오는 경우 -1
                    break;
                case 's':
                case 'z': if(input[i+1]=='='){count--; i++;} //'s=' 또는 'z='가 나오는 경우 -1
                    break;
            }
        }
        
        System.out.print(count);
    }
}