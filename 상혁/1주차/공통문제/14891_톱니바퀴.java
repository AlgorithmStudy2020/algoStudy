package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num14891_day2 {
	public static int[] rightRotate(int[] arr) {
		int temp = arr[7];
		for(int i=6;i>=0;i--) {
			arr[i+1]= arr[i];
		}
		arr[0] = temp;
		return arr;
	}
	public static int[] leftRotate(int[] arr) {
		int temp = arr[0];
		for(int i=0;i<7;i++) {
			arr[i] = arr[i+1];
		}
		arr[7] = temp;
		return arr;
	}
	public static int check(int a, int b) {
		return a==b? 0 : 1;
	}
	public static int rocheck(int a,int b) {
		int answer=0;
		if(b==1) {
			if(a==1) {
				answer=-1;
			}else {
				answer=1;
			}
		}
		return answer;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer=0;
		int increse =1;
		int[][] data = new int[4][8];
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                data[i][j] = s.charAt(j) - '0';
            }
        }
		
		
		int N = Integer.parseInt(br.readLine());
		int[] rotateData = new int[4];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			int a = Integer.parseInt(arr[0])-1;
			int b = Integer.parseInt(arr[1]);
			int rightIndex = a+1,leftIndex=a-1;
			rotateData[a] = b;
			int go =0;
			answer =0;
			// 여기서 나머지 톱니바퀴 어떻게 돌릴지 판단 (rotateData에 저장)
			while(rightIndex<4) {
				if(go==0) {
					rotateData[rightIndex]=rocheck(rotateData[rightIndex-1],check(data[rightIndex-1][2],data[rightIndex][6]));
				}else {
					rotateData[rightIndex] = 0;
				}
				if(rotateData[rightIndex] == 0) {
					go =1;
				}				
				rightIndex++;
			}
			go=0;
			while(leftIndex>=0) {
				if(go==0) {
					rotateData[leftIndex]=rocheck(rotateData[leftIndex+1],check(data[leftIndex+1][6],data[leftIndex][2]));
				}else {
					rotateData[leftIndex] = 0;
				}
				if(rotateData[leftIndex] == 0) {
					go =1;
				}
				leftIndex--;
			}
			go =0;
			// 나머지 톱니바퀴 돌림

			for(int j=0;j<4;j++) {
					//돌림
				if(rotateData[j] == 1) {
					data[j] = rightRotate(data[j]);
				}else if(rotateData[j]==-1){
					data[j] = leftRotate(data[j]);
				}
				answer+=(data[j][0]*increse);
				// 점수 계산
				increse*=2;
			}
			increse =1;
		}
		System.out.println(answer);
	}
}
