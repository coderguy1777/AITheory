import numpy as np
inputdata = [
    [1, 0, 1],
    [0, 1, 1],
    [0, 0, 0],
    [1, 1, 0],
]

def sigmoid(x):
    return 1 / (1 + np.exp(-x))

def sigderivative(x):
    return np.exp(x) / (1 + np.exp(x))**2




class Neuron():
    def __init__(self, name, inputs):
        self.name = name
        self.inputs = inputs
        self.total = 0
        self.weights = np.random.uniform(size=len(inputs) + 1) * 20 - 10
        self.delta_weights_prev = np.zeros(len(inputs) + 1)
        self.gradients = np.zeros(len(inputs) + 1)
        self.forwardweights = {}

    def training1(self):
        inputs = []
        for index, neuron in enumerate(self.inputs):
            neuron.forwardweights[self.name] = self.weights[index]
            inputs.append(neuron.training1())
        self.total = np.dot(inputs + [1], self.weights)
        self.value = sigmoid(self.total)
        return self.value


    def backprop(self, error):
        weight_totals = sum(self.forwardweights.values())
        layer_delta = -error * sigderivative(self.total) * weight_totals
        for index, neuron in enumerate(self.inputs):
            self.gradients[index] += layer_delta * neuron.value
            neuron.backprop(layer_delta)
        # update bias weight
        self.gradients[-1] += layer_delta

    def weightupdate(self, netlearnrate = 0.7, netlearningmomentum=0.3):
        weightchange = netlearningmomentum * self.delta_weights_prev + netlearnrate * self.gradients
        self.weights += weightchange
        self.delta_weights_prev = weightchange
        self.gradients = np.zeros(len(self.inputs) + 1)


class Inputs():
    def __init__(self, name, value):
        self.value = value
        self.name = name
        self.forwardweights = {}

    def training1(self):
        return self.value

    def backprop(self, error):
        pass

    def updateweights(self):
        pass


inputvals = [Inputs("value 1", 0), Inputs("value 2", 0)]
hidden = [Neuron("hidden1", inputvals), Neuron("hidden2", inputvals)]
output = Neuron("outvals", hidden)
output.forwardweights["outneuron"] = 1


mse = np.inf
while mse >= 0.05:
    errors = []
    for i in inputdata:
        inputvals[0].value = i[0]
        inputvals[1].value = i[1]

        finalresult = output.training1()
        wantedval = i[2]

        error = finalresult - wantedval
        errors.append(error)
        output.backprop(error)

    output.weightupdate()
    mse = np.mean(np.square(errors))
    print(f"Mean Squared Error: {mse}")

print('Final values:')
print('↧')
for i in inputdata:
    inputvals[0].value = i[0]
    inputvals[1].value = i[1]
    predicted = output.training1()
    print(f"({i[0]}, {i[1]}) = {predicted}")