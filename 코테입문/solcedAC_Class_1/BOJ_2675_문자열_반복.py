T = int(input())
for i in range(T):
    repeat, str = input().split()
    repeat = int(repeat)
    for c in str:
        for d in range(repeat):
            print(c, end="")
    print("", end="\n")
