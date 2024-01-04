import sys

input = sys.stdin.readline


class Queue:
    list = [0 for i in range(15000)]
    front = 0
    back = -1

    def push(self, value):
        self.back = self.back + 1
        self.list[self.back] = value

    def pop(self):
        if self.front > self.back:
            print(-1)
        else:
            print(self.list[self.front])
            self.front = self.front + 1

    def get_front(self):
        if self.front > self.back:
            print(-1)
        else:
            print(self.list[self.front])

    def get_back(self):
        if self.front > self.back:
            print(-1)
        else:
            print(self.list[self.back])

    def size(self):
        print(self.back - self.front + 1)

    def empty(self):
        if self.front > self.back:
            print(1)
        else:
            print(0)


q = Queue()

n = int(input())

for i in range(n):
    command = input().split()
    if command[0] == "push":
        q.push(int(command[1]))
    elif command[0] == "pop":
        q.pop()
    elif command[0] == "front":
        q.get_front()
    elif command[0] == "back":
        q.get_back()
    elif command[0] == "size":
        q.size()
    elif command[0] == "empty":
        q.empty()
