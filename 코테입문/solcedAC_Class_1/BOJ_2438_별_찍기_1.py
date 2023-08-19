N = int(input())

for i in range(N):
    for d in range(i + 1):
        print("*", end="")
    print("", end="\n")
