# A Program that does the backpropagation al-gore-rhythm on a neural network.
# Period: F
# Made by: Jordan Hill
# ===================================================================================
# Imports used within this project for the execution of the
# Neural network, this being numpy as the only API I used
# for this project.
import numpy as np

# Input data for the neural network via XOR, and
# For use later on within the network for training data
inputdata = [[1, 0, 1], [0, 1, 1], [0, 0, 0], [1, 1, 0], ]

# Method that calculates the sigmoid activation function
def sigmoid(x):
    return 1 / (1 + np.exp(-x))

# Method that calculates the sigmoid derivative for use in the
def sigderivative(x):
    return np.exp(x) / (1 + np.exp(x))


# Class that calculates the Neurons of the Network when the
# Backpropagation algorithm in run on the network
class NetworkNeuron():
    def __init__(self, name, inputs):
        self.weights = np.random.uniform(size=len(inputs) + 1) * 20 - 10
        self.previousdeltaweights = np.zeros(len(inputs) + 1)
        self.networkgradients = np.zeros(len(inputs) + 1)
        self.networkweights = {}
        self.total = 0
        self.name = name
        self.inputs = inputs

    # The execution of the backpropagation algorithim
    def backpropagation(self, networkerror):
        weight_totals = sum(self.networkweights.values())
        deltanode = -networkerror * sigderivative(self.total) * weight_totals
        for keyval, node in enumerate(self.inputs):
            self.networkgradients[keyval] += deltanode * node.value
            node.backpropagation(deltanode)
        self.networkgradients[-1] += deltanode

    # Method that updates the weights during the execution of the
    # Backpropagation algorithim.
    def weightupdate(self, netlearnrate=0.7, netlearningmomentum=0.3):
        weightchange = netlearningmomentum * self.previousdeltaweights + netlearnrate * self.networkgradients
        self.weights += weightchange
        self.previousdeltaweights = weightchange
        self.networkgradients = np.zeros(len(self.inputs) + 1)

    # Method that does the foward propagation algorithim
    def training(self):
        netinputs = []
        for keyval, node in enumerate(self.inputs):
            node.networkweights[self.name] = self.weights[keyval]
            netinputs.append(node.training())
        self.total = np.dot(netinputs + [1], self.weights)
        self.value = sigmoid(self.total)
        return self.value


# Sorts all the network inputs for the Neural network to use
# When doing the backpropagation algorithim in this case.
class NetworkInputs():
    def __init__(self, name, value):
        self.name = name
        self.value = value
        self.networkweights = {}

    def updateweights(self):
        pass

    def training(self):
        return self.value

    def backpropagation(self, networkerror):
        pass


# Input data being converted into a tuple, for the later insertion from the
# Main data list that is listed
inputvals = [NetworkInputs("value 1", 0), NetworkInputs("value 2", 0)]
hlayer = [NetworkNeuron("hidden1", inputvals), NetworkNeuron("hidden2", inputvals)]
neuraloutputs = NetworkNeuron("outvals", hlayer)

# So the MSE changes, the delta node is set to 1 for the output neuron so this allows to be occurred.
neuraloutputs.networkweights["outneuron"] = 1

# While loop that calculates the MSE for the neural network,
# and once it hits a certain MSE, this being 0.05, it stops and allows for the final results to be printed.
mse = np.inf
while mse >= 0.05:
    neuralerrors = []
    for i in inputdata:
        inputvals[0].value = i[0]
        inputvals[1].value = i[1]
        # Sets up the values for the error calculation of the error equation.
        finalresult = neuraloutputs.training()
        wantedval = i[2]
        # Does the error for the neural network as it runs
        networkerror = finalresult - wantedval
        neuralerrors.append(networkerror)
        neuraloutputs.backpropagation(networkerror)

    # Does the function that updates the weights of the Neural Network that it runs and calculates the MSE for as
    # well with each iteration of the algorithm.
    neuraloutputs.weightupdate()
    meansquarederror = np.mean(np.square(neuralerrors))
    print("Mean Squared Error: " + str(meansquarederror))

# Prints the final results of the trained neural network, once the Mse reachs the final needed results of 0.05
print('--------------------')
for i in inputdata:
    inputvals[0].value = i[0]
    inputvals[1].value = i[1]
    finalresult = neuraloutputs.training()
    print(i[0] + ", " + i[1] + "=" + finalresult)