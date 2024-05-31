# https://www.acmicpc.net/problem/10866
# 아이디어 : 양방향 linked list 로 구현하면 되지 않을까

import sys

input = sys.stdin.readlines


class Node:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None


class Deque:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def push_front(self, value):
        new_node = Node(value)
        if self.head != None:
            self.head.prev = new_node
            new_node.next = self.head
        if self.tail == None:
            self.tail = new_node
        self.head = new_node
        self.size += 1

    def push_back(self, value):
        new_node = Node(value)
        if self.tail != None:
            self.tail.next = new_node
            new_node.prev = self.tail
        if self.head == None:
            self.head = new_node
        self.tail = new_node
        self.size += 1

    def pop_front(self):
        if self.head == None:
            return -1
        else:
            deleted_value = self.head.value
            if self.tail == self.head:
                self.head = None
                self.tail = None
            else:
                self.head = self.head.next
            self.size -= 1
            return deleted_value

    def pop_back(self):
        if self.tail == None:
            return -1
        else:
            deleted_value = self.tail.value
            if self.tail == self.head:
                self.head = None
                self.tail = None
            else:
                self.tail = self.tail.prev
            self.size -= 1
            return deleted_value

    def get_size(self):
        return self.size

    def is_empty(self):
        return 1 if self.size == 0 else 0

    def get_front(self):
        return -1 if self.head == None else self.head.value

    def get_back(self):
        return -1 if self.tail == None else self.tail.value

    def printQueue(self):
        current = self.head
        print("head : ", self.head.value if self.head else "None")
        print("tail : ", self.tail.value if self.tail else "None")
        while current:
            print(current.value, " <-> ", end="")
            current = current.next
        print("None")


def solution():
    deque = Deque()
    command_list = input()[1:]
    for command in command_list:
        command = command.split()
        # print("==================================")

        # print(command)
        if command[0] == "push_front":
            deque.push_front(command[1])
        elif command[0] == "push_back":
            deque.push_back(command[1])
        elif command[0] == "pop_front":
            print(deque.pop_front())
        elif command[0] == "pop_back":
            print(deque.pop_back())
        elif command[0] == "size":
            print(deque.get_size())
        elif command[0] == "empty":
            print(deque.is_empty())
        elif command[0] == "front":
            print(deque.get_front())
        elif command[0] == "back":
            print(deque.get_back())
        # deque.printQueue()
        # print("==================================")


solution()
