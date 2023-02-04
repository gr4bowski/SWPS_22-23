import time

start_time = time.process_time()


matrix = [
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 0],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [0, 0, 0, 2, 3, 4, 5, 0, 0, 3],
    [0, 0, 0, 2, 3, 4, 5, 0, 0, 1],
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
    [0, 0, 3, 1, 1, 2, 5, 0, 0, 0],
    [4, 4, 4, 4, 4, 4, 4, 4, 4, 2],
    [0, 0, 0, 2, 3, 4, 5, 0, 0, 1],
    [8, 8, 8, 8, 8, 8, 8, 8, 8, 3],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 7]
]

vec_z_lewej = [
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
]

vec_z_prawej = [
    [2],
    [2],
    [2],
    [2],
    [2],
    [2],
    [2],
    [2],
    [2],
    [2]
]

def mno(mx_1, mx_2):
    n1 = len(mx_1[0])
    m1 = len(mx_1)
    n2 = len(mx_2[0])
    m2 = len(mx_2)
    if(n1 != m2):
        print("Niezgodne wymiary!!!")
        return
    res = [[0 for i in range(0, n2)] for i in range(0, m1)]
    for i in range (0, m1):
        for j in range(0, n2):
            for k in range(0, n1):
                res[i][j] += mx_1[i][k]*mx_2[k][j]
    return res


res = mno(vec_z_lewej, matrix)
print(res)

print("Wykonanie programu zajęło %s sekund" % (time.process_time() - start_time))
