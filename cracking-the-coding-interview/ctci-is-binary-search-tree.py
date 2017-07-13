import sys
""" Node is defined as
class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
"""

def checkNode(node, min, max):
    # Base case
    if not node:
        return True;

    # In order traversal
    left = checkNode(node.left, min, node.data)
    # process node
    if (node.data <= min):
        return False;
    elif (node.data >= max):
        return False;
    # right child
    right = checkNode(node.right, node.data, max)
    return left and right

def checkBST(root):
  if not root:
    return False;
  else:
    return checkNode(root, -sys.maxsize, sys.maxsize)
