N,M,V = map(int, input().split())
mapp =[]
for _ in range(N+1):
    mapp.append([])
for _ in range(M):
    a,b = map(int, input().split())
    mapp[a].append(b)
    mapp[b].append(a)
for _ in range(N+1):
    mapp[_].sort()
visit =[False for i in range(N+1)]
visit2 =[False for i in range(N+1)]
ansb =[]
ansd =[]
def bfs(start):
    q = [start]
    visit[start] =True
    ansb.append(start)
    while len(q):
        now = q.pop(0)
        for i in mapp[now]:
            if visit[i]:
                continue
            visit[i] = True
            q.append(i)
            ansb.append(i)
def dfs(start):
    ansd.append(start)
    visit2[start] = True
    for i in mapp[start]:
        if visit2[i]:
            continue
        dfs(i)

bfs(V)
dfs(V)

strb =""
strd=""
for i in ansd:
    strd += str(i) +" "
for i in ansb:
    strb += str(i) + " "


print(strd)
print(strb)
