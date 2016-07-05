#!/usr/bin/python
#encoding=utf-8
import random
import math

def base_random():
    if random.random() <= 0.5:
        return 0
    else:
        return 1

def random_K(K):
    numBits = int(math.ceil(math.log(K,2)))
    while True:
        N = 0
        for i in range(numBits):
            if base_random() == 1:
                N |= 1 << i
        if N < K:
            return N + 1


for i in range(10):
    print random_K(10)
