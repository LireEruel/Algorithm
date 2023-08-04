for testcases in range(10):
    testcase = int(input())
    ladder = []
    for i in range(100):
        row = input()
        ladder.append(row.split())
    x = int(ladder[99].index('2'))
    for y in range(99, -1, -1):
        if (x != 0 and ladder[y][x-1] == '1'):
            while (x >= 0 and ladder[y][x-1] == '1'):
                x -= 1
        elif (x != 99 and ladder[y][x+1] == '1'):
            while (x >= 0 and ladder[y][x+1] == '1'):
                x += 1
    print('#%d %d'%(testcase,x))