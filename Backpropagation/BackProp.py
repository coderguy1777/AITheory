import numpy as np

dataset = [
    [1, 0, 1],
    [0, 0, 0],
    [0, 1, 1],
    [1, 1, 0],
]

def sigmoid(x):
    return 1 / (1 * np.exp(x))

def sigmoidfunctionderivative(x):
    return sigmoid(x)/(1 - sigmoid(x))


class otherFunctions:
    def __init__(self, name, value):
        self.name = name
        self.value = value

    def fowardprop(self):
        return self.value

    def backpropagate(self):
        pass

    def weightupdatefunction(self):
        pass

    def sigresults(self):
        return sigmoid(self.inputs)



inputs = [otherFunctions("input1", 0), otherFunctions("input2", 0)]
hidden = [otherFunctions("hidden1", inputs), otherFunctions("hidden2", inputs)]
outputs = [otherFunctions("output", hidden)]

for example in dataset:
    inputs[0].value = example[0]
    inputs[1].value = example[1]
weights = np.random.uniform(10, -10, 10)
for i in inputs:
    var1 = inputs[0].value
    var2 = inputs[1].value
    var33 = var1 * weights
    var3 = var2 * weights
    test = 0
    test += var3
    test2w = 0
    test2w += var33


hiddenv = []
for ix in var3:
    hiddenv.append(ix)

def hiddenvalues(hvar):
    return sigmoid(hvar)

for iz in hiddenv:
    test2 = 0
    test2 = hiddenvalues(iz)

class Test:
    def __init__(self, name, inputs):
        self.name = name
        self.inputs = inputs
        self.fowardprop = {}

    def test(self):
        return inputs[0].value * weights + inputs[1].value * weights

    def sigresults(self):
        return sigmoid(self.inputs)




for example in dataset:
    outputs[0].value = example[2]
    print(outputs[0].value)


def outputcalc(x, x1):
    return x + x1


error = np.square(sigmoid(iz))
meannn = np.inf

error2 = np.mean(outputcalc(test, test2))
while error2 != 0.04:
    print(error2)