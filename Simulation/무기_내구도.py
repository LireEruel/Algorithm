def maxNewWeapons(w: int, g: int, s: int, r: int):
    n = 0
    while (w - n) * r > g + n * s:
        n += 1
    print(w - n)


maxNewWeapons(10, 10, 2, 2)
