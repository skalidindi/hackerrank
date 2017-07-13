#!/bin/python3

import sys
import heapq

def addElement(data, lowers, highers):
  if (len(lowers) == 0 or data < abs(lowers[0])):
    # Push -data to make it a max heap
    heapq.heappush(lowers, -data);
  else:
    # Min heap
    heapq.heappush(highers, data);

def rebalance(lowers, highers):
  biggerHeap = lowers if len(lowers) > len(highers) else highers
  smallerHeap = lowers if len(lowers) < len(highers) else highers

  if len(lowers) != len(highers) and (len(biggerHeap) - len(smallerHeap)) >= 2:
    data = heapq.heappop(biggerHeap)
    heapq.heappush(smallerHeap, -data)

def findMedian(lowers, highers):
  if len(lowers) == len(highers):
    return float(abs(lowers[0]) + highers[0]) / 2.0
  elif len(lowers) > len(highers):
    return float(abs(lowers[0]))
  else:
    return float(highers[0])

n = int(input().strip())
a_i = 0
medians = []
lowers = []
highers = []
for a_i in range(n):
  a_t = int(input().strip())
  addElement(a_t, lowers, highers);
  rebalance(lowers, highers)
  medians.append(findMedian(lowers, highers))

for median in medians:
  print(median)
