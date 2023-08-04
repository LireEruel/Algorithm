last = int(input())
for i in range(1, last+1) :
    if '3' in str(i) or '6' in str(i) or '9' in str(i) :
        print('X')
    else :
        print(i)