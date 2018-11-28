import numpy as np

dataset = [
    [1, 0, 1],
    [0, 0, 0],
    [0, 1, 1],
    [1, 1, 0],
]

def sigmoid(x):
    return 1 / (1 * np.exp(-x))

def sigmoidfunctionderivative(x):
    return sigmoid(x)/(1 - sigmoid(x))



class neuronClass:
    def __init__(self, name, inputs):
        self.name = name
        self.inputs = inputs
        self.weights = np.random.uniform(-10, 10, 10)
        self.total = np.zeros(len(dataset))
        self.deltaweights = np.zeros(inputs) * self.weights
        self.fowardpropvalues = {}

    def fowardprop(self):
        inputs = []
        for index, neuron in enumerate(self.inputs):
            neuron.fowardpropvalues[self.name] = self.weights[index]
            inputs.append(neuron.fowardpropvalues)
        activationfunction = self.inputs * self.weights + self.inputs * self.weights
        self.total = np.dot(self.weights + [1] * self.inputs)
        self.value = sigmoid(self.total)
        print(self.total)
        return activationfunction

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


inputs = [otherFunctions("input1", 0), otherFunctions("input2", 0)]
hidden = [otherFunctions("hidden1", inputs), otherFunctions("hidden2", inputs)]
outputs = [otherFunctions("output", hidden)]

for example in dataset:
    inputs[0].value = example[0]
    inputs[1].value = example[1]
weights = np.random.uniform(-10,10,10)
total = np.dot(weights, 1)
print(sigmoid(total))