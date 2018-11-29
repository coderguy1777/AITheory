import numpy as np
x = [0, 1, 1, 0]
y = [1, 1, 0, 1]


class ArrayEstablish:
    def __init__(self, name, values):
        self.name = name
        self.values = values

    def valueholder(self):
        return self.values

    def backpropagate(self):
        pass

    def weightupdatefunction(self):
        pass

    def sigresults(self):
        return self.values


def sigmoid(x):
    return 1 / 1 + np.exp(-x)

class Neuron:
    def __init__(self):
        self.idealout = 1
        self.w1 = np.random.uniform(size=len(x) + len(y)) * 20 - 10
        self.w2 = np.random.uniform(size=len(y) + len(y)) * 20 - 10
        self.learningrate = 0.7
        self.learningmomentum = 0.3
        self.bias = [1]


    def sigmoid(self, x):
        return 1 / 1 + np.exp(-x)

    def sigmoidderivative(self, x):
        return (1 / 1 + np.exp(-x)) / (1 / 1 + np.exp(-x))

    for i in x:
        i = x[i]

    u = 0
    for u in y:
        u = y[u]

    def hiddenlayer1(self, x, y):
        self.z = np.dot(x, self.w1)
        self.z2 = np.dot(y, self.w2)
        self.hvalues = self.z + self.z2 + self.bias
        self.h1list = []
        self.h1list.append(self.hvalues)
        o = self.h1list
        return o

    def activationh1layer(self):
        v = 1 / 1 + np.exp(self.h1list) * -1
        return v

test = Neuron()
i = 0
for i in x:
    i = x[i]

u = 0
for u in y:
    u = y[u]

o = test.hiddenlayer1(i, u)

print(o)
print(test.activationh1layer())
