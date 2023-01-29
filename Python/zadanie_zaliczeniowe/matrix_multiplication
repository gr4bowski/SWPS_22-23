# matrix_filepath = input("Please enter path to the file containing 10 by 10 matrix:\n")

# vector_filepath = input("Please enter path to the file containing 10-elements vector:\n")

matrix_filepath = "matrix.txt"

vector_filepath = "vector.txt"

matrix = [[]]

vector = []

matrix = open(matrix_filepath, "r")

vector = open(vector_filepath, "r")

result = [10]

for i in range(len(matrix)):
   for j in range(len(vector[0])):
       for k in range(len(vector)):
           result[i][j] += matrix[i][k] * vector[k][j]

for r in result:
   print(r)
