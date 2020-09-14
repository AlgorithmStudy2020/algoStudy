package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 유클리드 호제법 이용해서 최대 공약수 구함

public class num2485_day2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		int[] distance = new int[N-1];
		int j=0;
		int cnt = 0;
		int gcd=100000000;
		
		for(int i=0;i<N;i++) {
			data[i] = Integer.parseInt(br.readLine());
			if(i!=0) {
				distance[j]=data[i]-data[i-1];
				j++;
			}
		}
		
		for(int i=1;i<N-1;i++) {
			int a = distance[i],b=distance[i-1];
			while(b>0) {
				int temp = b;
				b = a%b;
				a = temp;
			}
			if(gcd>a) {
				gcd = a;
			}
		}

		for(int i=0;i<N-1;i++) {
			if(distance[i]>gcd) {
				cnt+=((distance[i]/gcd)-1);
			}
		}
		
		System.out.println(cnt);
	}
}
