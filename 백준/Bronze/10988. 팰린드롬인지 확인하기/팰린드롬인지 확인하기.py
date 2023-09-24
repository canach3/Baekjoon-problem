word = input()

if len(word) == 1:
    print(1)

i = 0

while i != len(word) // 2:
    if word[i] != word[-(i+1)]:
        print(0)
        break
    elif i == len(word) // 2 - 1:
        print(1)
    
    i += 1
