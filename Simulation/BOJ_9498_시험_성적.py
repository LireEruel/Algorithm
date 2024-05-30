scores = {
    10: "A",
    9: "A",
    8: "B",
    7: "C",
    6: "D",
}

score = int(input()) // 10
print("F" if score < 6 else scores[score])
