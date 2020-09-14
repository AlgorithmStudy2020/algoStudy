package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_2512_day2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		
		String inputData = br.readLine();
		StringTokenizer stk = new StringTokenizer(inputData);
		int answer =0;
		
		int maxValue = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			data[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(data);
		
		
		for(int i=0;i<N;i++) {
			if(data[i]*(N-i) < maxValue) {
				maxValue-=data[i];
			}else {
				answer = maxValue/(N-i);
				break;
			}
		}
		
		if(answer ==0) {
			answer = data[N-1];
		}
		System.out.println(answer);
		
		
	}

}
