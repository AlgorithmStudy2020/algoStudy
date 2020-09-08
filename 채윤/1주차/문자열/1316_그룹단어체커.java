import java.util.*;
import java.io.*;

//그룹 문자의 총 개수 세기
//동일한 알파벳이 연속하지 않고 떨어져서 나타나는 경우 그룹 문자 x (ex.aabbcb)
//알파벳은 소문자만 존재
public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //주어지는 단어의 개수 N
        int count = 0; //총 그룹 문자의 수
        for(int i=0;i<n;i++){ 
        //각 단어마다 그룹 문자인지 판별

            boolean isGroup = true;
            String s = br.readLine();
            boolean[] exist = new boolean[26]; 
            //각 alphabet이 단어에 존재하는지 boolean타입으로 표시
            //exist[0]->a, exist[1]-b, ...
            exist[s.charAt(0)-96]=true;
            //첫번째 alphabet
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)==s.charAt(j-1)){
                    //해당 alphabet이 앞의 alphabet과 같은 경우
                    //연속적임
                }else{
                    //해당 alphabet이 앞의 alphabet과 다른 경우
                    for(int k=0;k<26;k++){
                        if(s.charAt(j)==k+97){
                            if(exist[k]){
                                //해당 alphabet이 이미 앞에서 존재하는 경우
                                //하지만 연속적이진 않음
                                isGroup = false;
                                //따라서 그룹 문자 x
                            }else{
                                //해당 alphabet은 처음 등장
                                exist[k]=true;
                            }
                        }
                    }
                }
            }
            
            if(isGroup){
                //단어가 그룹 문자임
                count++;
            }

        }
        System.out.print(count);
        
    }
}