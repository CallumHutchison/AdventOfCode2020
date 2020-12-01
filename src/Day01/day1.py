'''
Read in a list of integers from a file
Find which 2 numbers add together to make 2020, and print their product.
Find which 3 numbers add together to make 2020, and print their product.
'''

import sys

with open(sys.path[0] + "/input.txt") as f:
    inputs = list(map(int, f.read().splitlines()))

for i in range(len(inputs)):
    for j in range(i, len(inputs)):
        if inputs[i] + inputs[j] == 2020:
            print("Part 1 solution: " + str(inputs[i] * inputs[j]))
        for k in range(j, len(inputs)):
            if inputs[i] + inputs[j] + inputs[k] == 2020:
                print("Part 2 solution: " + str(inputs[i] * inputs[j] * inputs[k]))