import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            list.add(Integer.parseInt(br.readLine())%42);
        }
        HashSet<Integer> hashset = new HashSet<Integer>(list);
        bw.write(hashset.size()+"\n");
        bw.flush();
        bw.close();
    }
}