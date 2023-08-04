h, b, c = input().split()

h = int(h)
b = int(b)
c = int(c)

result = format((h* b* c)/( 8 * 1024 * 1024 ), ".2f")
print(f'{result} MB')