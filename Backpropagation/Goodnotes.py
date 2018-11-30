su = np.bitwise_xor(x[0], x[1])
in1out = []
for i in x:
    in1out.append(np.bitwise_xor(i, x[su]))

sy = np.bitwise_xor(y[0], y[1])
in2out = []
for b in y:
    in2out.append(np.bitwise_xor(b, sy))


w1 = np.random.uniform(-10., 10., 10)
w2 = np.random.uniform(-10., 10., 10)

def sigmoid(x):
    return 1/ 1 * np.exp(-x)

def hlayervalues(xx, yy, ww1, ww2):
    return xx * ww1 + yy * ww2


h1actvals = []
i = 0
ys = 0

iterati = len(x) + len(y)
osis = []
for i in range(iterati):
    trys = hlayervalues(su, sy, w1, w2)
    sigvals = sigmoid(trys)
    osis.append(sigvals)

vafr6 = 0
for i in osis:
    vafr6 = sigmoid(trys)

def test(s):
    isx = np.dot(s, s)
    return isx


def cost(yHat, h):
    cost = np.sum((yHat - h) ** 2) / 2.0
    return cost
