import numpy as np

x = [
      [1, 0],
      [0, 1],
      [1, 0],
      [0, 0],
 ]

idealout = [1, 0, 1, 0]

l = []

for iy in x:
    for iz in iy:
        l.append(iz)

def sigmoid(x):
    return 1.0 / (1.0 + np.exp(-x))

def sigderivative(x):
    return sigmoid(x)/(1.0 + sigmoid(x))


# Defines a Class for the Hidden Values to be stored in, along with inputs, outputs, etc.
# Using this class, these values are mainly stored as tuples in this case.
class Inputvals:
    def __init__(self, values, name):
        self.name = name
        self.values = values

    def valreturn(self):
        return self.values

    def nameval(self):
        return self.name


class Neuron(object):
    def __init__(self):
        self.learningrate = 0.7
        self.learningmomentum = 0.3
        self.weights = np.random.uniform(size=len(x) * 2) * 20 - 10
        self.bias = 1
        self.predic = 1
        self.weight2 = np.random.uniform(size=len(x) * 2) * 20 - 10
        self.fowardprop = {}
        self.h1arr = []
        self.outvals = []
        self.errors = []
        self.value = "Hidden Values"

    def calc11(self, x):
        z1 = np.dot(x, self.weights) + self.bias
        z2 = np.dot(x, self.weight2) + self.bias
        h1val = z1 + z2
        self.h1arr.append(self.sighvals(h1val))
        return self.sighvals(h1val)

    def sighvals(self, x1):
        return sigmoid(x1)

    def sumout(self, x2):
        for i in self.h1arr:
            x1 = x2 * self.weight2 - i
            return sum(x1)

    def sigmoidofact(self, x3):
        self.outvals.append(sigmoid(x3))
        return sigmoid(x3)

    def fowardpropvals(self):
        for i in self.h1arr:
            self.fowardprop[self.value] = i
        return self.fowardprop

    def backprop(self):
        for i in self.outvals:
           self.error = idealout - i
           self.errors.append(self.error)
        return self.errors

    def sigderive(self, x4):
        return sigderivative(x4)


hava = []
o = Neuron()
u = 0
for i in l:
    u = o.calc11(l[i])

print(u)
xx = o.sumout(u)
xy = o.sigmoidofact(xx)
print(xx)
print(xy)
