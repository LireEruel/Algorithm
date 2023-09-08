while True:
    a, b, c = map(int, input().split())
    if a + b + c == 0 :
        break
    if a == b == c :
        print("Equilateral")
    else:
        m = max(a, b, c)
        s = max(a, b, c)
        if m < (sum([a, b, c]) - m):
            if a == b or b ==c or a == c :
                print("Isosceles")
            else:
                print("Scalene")
        else:
            print("Invalid")

