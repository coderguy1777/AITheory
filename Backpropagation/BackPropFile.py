# Period: F
# Project: Backpropagation for A Neural network using XOR gates.



import numpy as np

# Does the sigmoid function
def sigmoid(x):
    return 1 / 1 * np.exp(-x)

# Does the derivative of the sigmoid
def derivativeofsigmoid(x):
    return np.exp(x) / (1 + np.exp(x)) ** 2

# Input training data for the program
inputset1 = [0, 1, 0, 1]
inputset2 = [1, 0, 0, 0]
idealoutputs = [1, 1, 0, 1]

# Generates bias and random weights for the program
biases = np.random.random_integers(0, 1)
weightvariation = np.random.uniform(-10, 10, 20) + 1

# Method that does the activation function itself for the intiai
def activationfunction(w, x, b):
    return w * x + b

# Gets the total of the inputs for
totallist = []
for i in inputset1:
    for j in inputset2:
         var = inputset1[i] - inputset2[j]

         # if statments that are used for telling whether or not the ideal-
         # output is met, and gives the total for i1 + i2 of the inputs.
         if var == idealoutputs[0 + var]:
             totallist.append(var)
         if var != idealoutputs[0 + var]:
             totallist.append(var + 1)

# Sets up the activation function list
initialactivationfunctions = []
for activationfunctionpart in totallist:
    var1 = activationfunction(weightvariation, activationfunctionpart, biases)

# Sets up the initial activation values in a list
initialactivationfunctions.append(var1)
print(initialactivationfunctions)