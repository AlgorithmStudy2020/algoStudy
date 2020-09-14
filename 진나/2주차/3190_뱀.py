movd=[[0,1],[1,0],[0,-1],[-1,0]]

#N,K 입력받음
N=int(input())
K=int(input())

#N*N 배열 만들고, 사과 있는 위치의 값 = 1
board=[[0]*(N+1) for i in range(N+1)]
for i in range(K):
    row,col=input().split()
    board[int(row)][int(col)]=1

#뱀의 방향 전환 시간, 방향 입력 받음
L=int(input())
rotateInfo=[]
for i in range(L):
    num,dir=input().split()
    rotateInfo.append([int(num),dir])

#direction이 D라면 오른쪽으로 회전, direction이 L이라면 왼쪽으로 회전
def turn(cur,direction):
    if direction=='D':
        return (cur+1)%4
    else:
        return (cur-1)%4

def simulate():
    cury=1;curx=1   #현재 위치
    board[cury][curx]=2 #뱀이 있는 위치의 값 = 2
    snake=[[cury,curx]] #뱀의 위치
    
    idx=0;curTime=0;curDirection=0

    while True:
        curTime+=1
        nexty=cury+movd[curDirection][0];nextx=curx+movd[curDirection][1]   #다음 y,x 좌표값

        #out of index
        if nexty>N or nexty<1 or nextx>N or nextx<1 or board[nexty][nextx]==2:
            break

        snake.append([nexty,nextx])
        if board[nexty][nextx]==1:  #사과가 있는 위치
            board[nexty][nextx]=2
        else:   #사과가 없다면, 꼬리 움직임
            board[nexty][nextx]=2
            remy,remx=snake.pop(0)
            board[remy][remx]=0

         #회전할 시간이라면
        if idx<L and curTime==rotateInfo[idx][0]:
            curDirection=turn(curDirection,rotateInfo[idx][1])
            idx+=1

        cury=nexty;curx=nextx

    return curTime

print(simulate())