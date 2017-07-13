"""
Detect a cycle in a linked list. Note that the head pointer may be 'None' if the list is empty.

A Node is defined as:

    class Node(object):
        def __init__(self, data = None, next_node = None):
            self.data = data
            self.next = next_node
"""

def has_cycle(head):
    if head is None:
      return False

    slow = head
    fast = head.next

    while slow is not None:
      if (slow == fast):
        return True

      slow = head.next if head.next else None
      fast = slow.next if slow and slow.next else None

    return False
