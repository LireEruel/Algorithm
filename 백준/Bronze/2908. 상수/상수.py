A, B = input().split()
A = list(A)
B = list(B)
trans_a = [A[2], A[1], A[0]]
trans_b = [B[2], B[1], B[0]]

A = int("".join(trans_a))
B = int("".join(trans_b))

if A > B :
    print(A)
else:
    print(B)