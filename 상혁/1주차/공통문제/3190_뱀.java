package group;

import java.io.*;
import java.util.*;

class Node {
	int a;
	int b;
	Node(int a, int b){
		this.a = a;
		this.b = b;
	}
}
public class num3190_day2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 맵 크기, 데이터(배열)
		int N = Integer.parseInt(br.readLine());
		int[][] mapData = new int[N][N];
		
		// 사과 개수, 위치(해시맵)
		int K = Integer.parseInt(br.readLine());
//		Map<Integer,Integer> appleData = new HashMap<>();
		int[][] appleData = new int[N][N];
		
		for(int i=0;i<K;i++) {
			String str = br.readLine();
			String[] tokens = str.split(" ");
//			System.out.println((Integer.parseInt(tokens[0])-1) + " " + (Integer.parseInt(tokens[1])-1));
//			appleData.put(Integer.parseInt(tokens[0])-1,Integer.parseInt(tokens[1])-1);
			appleData[Integer.parseInt(tokens[0])-1][Integer.parseInt(tokens[1])-1] = 1;
		}
		
		// 시간에 따른 방향전환 데이터 저장
		int L = Integer.parseInt(br.readLine());
		Map<Integer,Character> moveData = new HashMap<>();
		
		for(int i=0;i<L;i++) {
			String str = br.readLine();
			String[] tokens = str.split(" ");
			moveData.put(Integer.parseInt(tokens[0]),tokens[1].charAt(0));
//			System.out.println(tokens[1].charAt(0));
		}
		
		int second=0, length = 1, direction=1;
		// direction : 0->위쪽, 1-> 오른쪽, 2-> 아래, 3-> 왼쪽 
		
		// bam 현재 위치
		int[] bam = new int[2];
		bam[0] = 0;bam[1] = 0;
		int bamLeng = 1;
		// 뱀 몸통
		int[][] bamBody = new int[101][2];
		// 뱀 몸통 초기값 설정
		bamBody[1][0] = 0;
		bamBody[1][1] = 0;
		int finish =0;
		while(true) {
			// 1. 초 증가
			second++;
			// 2. 방향 전환 확인 
			//  2.1 D-> +1 (3이면 0로) or L -> -1 (0이면 3으로)
			if(moveData.get(second-1) != null) {
				if(moveData.get(second-1)=='D') {
//					System.out.println("오른쪽 회전");
					if(direction==3) {
						direction = 0;
					}else {
						direction=direction+1;
					}
//					System.out.println("이동한 방향 :"+direction);
				}else {
//					System.out.println("왼쪽 회전");
					if(direction==0) {
						direction=3;
					}else {
						direction=direction-1;
					}
//					System.out.println("이동한 방향 :"+direction);
				}
			}
			// 3. 이동
			if(direction==1) {
				//오른쪽
				bam[1]++;
			}else if(direction==2) {
				// 아래
				bam[0]++;
			}else if(direction ==3) {
				// 왼쪽
				bam[1]--;
			}else if(direction ==0) {
				// 위
				bam[0]--;
			}
			
//			System.out.println("현재 뱀 몸 : " + bam[0] + " " + bam[1]);
			// 5. 사과 먹은지 판단? 몸길이 늘리고 뱀 hash테이블 저장 : hash테이블 옮김 
			if((bam[0]>=0 && bam[1]>=0) && (bam[0]<N && bam[1]<N)) {
				if(appleData[bam[0]][bam[1]] == 1) {
					//사과 먹은 상황
					appleData[bam[0]][bam[1]] =0;
//					System.out.println("EAT 사과");
					bamLeng++;

				}
			}
		
			
			// 4. 부딪친지 판단 1) 벽, 2) 자기 몸 ? 탈출 : 진행
			if(bam[1]==N || bam[1] == -1 || bam[0] == N || bam[0] == -1) {
				// 벽
//				System.out.println(bam[0]+ " " + bam[1]);
//				System.out.println("벽 으로 끝남");
				break;
			}
			for(int i=1;i<=bamLeng;i++) {
				//현재 위치랑 뱀 몸값과 비교
//				System.out.println(bamBody[i][0] + " " + bamBody[i][1]);
				if(bamBody[i][0] == bam[0] && bamBody[i][1] == bam[1]) {
//					System.out.println("내 몸 부딪침");
					finish =1;
					break;
				}
			}
			
			// bamBody 1에 현재 위치 저장  
			for(int i=bamLeng;i>0;i--) {
				bamBody[i+1][0] = bamBody[i][0];
				bamBody[i+1][1] = bamBody[i][1];
//				System.out.println(" 이동한 뱀 몸: "+bamBody[i+1][0] + " " + bamBody[i+1][1]);
			}
			
			// 내 몸 만나면 탈출
			if(finish==1) {
				break;
			}

			bamBody[1][0] = bam[0];
			bamBody[1][1] = bam[1];
//			System.out.println("뱀 길이 : " + bamLeng);

		}
		System.out.println(second);
		
	}
}
