

number_grid = [
    [1, 0],
    [0, 1],
    [0, 0],
    [1, 1],
]

for row in number_grid:
     col = 0
     for col in row:
         s1 = col + number_grid[1][0]
         s2 = row
         print(s1)