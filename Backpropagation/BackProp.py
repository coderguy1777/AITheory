import numpy as np
x = np.array(([1, 0], [0, 1], [0, 0], [1, 1]), dtype=float)

ys = x/np.amax(x, axis=0)
class Neuron:
    def __init__(self):
        self.hiddensize = 10
        self.inputsize = -10
        self.outsize = 1
        self.w1 = np.random.uniform(self.hiddensize, self.inputsize)
        self.w2 = np.random.uniform(self.hiddensize, self.outsize)
        self.b = 1
        self.target = 1


    def sigmoid(self, s):
        return 1 / (1 + np.exp(-s))

    def h1values(self, inptut):
        z = inptut * self.w1 + inptut * self.w2 + self.b
        ss = self.sigmoid(z)
        us = np.dot(ss, self.w2)
        return self.sigmoid(us)

    def error(self, prediction):
        return (prediction - self.target) ** 2

    def test2(self, ideal):
        s = np.mean(np.square(ideal))
        return s


test = Neuron()
test2 = test.h1values(ys)

print(test2)