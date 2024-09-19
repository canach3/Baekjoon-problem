#주석처럼 하지 말고 lcm 함수로 시간단축하기
'''t = int(input())

for i in range(t):
    a, b = map(int, input().split())
    
    lcm = min(a,b)
    
    while True:
        if lcm % a == 0 and lcm % b == 0:
            print(lcm)
            break
        else:
            lcm += 1'''
import math

t = int(input())

for i in range(t):
    a, b = map(int, input().split())
    print(math.lcm(a, b))