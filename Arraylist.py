class ArrayList:
    def _init_(self):
        self.array = []
        self.length = 0

    def _len_(self):
        return self.length

    def getitem(self, index):
        if index >= self.length:
            raise IndexError('Index out of bound')
        return self.array[index]

    def setitem(self, index, value):
        if index >= self.length:
            raise IndexError('Index out of bound')
        self.array[index] = value

    def append(self, value):
        self.array.append(value)
        self.length += 1

    def insert(self, index, value):
        if index >= self.length:
            raise IndexError('Index out of bound')
        self.array.insert(index, value)
        self.length += 1

    def remove(self, value):
        self.array.remove(value)
        self.length -= 1

    def pop(self, index=- 1):
        value = self.array.pop(index)
        self.length -= 1
        return value

    def index(self, value):
        return self.array.index(value)

    def clear(self):
        self.array.clear()
        self.length = 0

    def print(self):
        len = self.length
        print("[", end=" ")
        for a in range(len):
            print(self.getitem(a) + " ", end="")
        print("]")

    def count(self, value):
        return self.array.count(value)

    def index(self, value):
        return self.array.index(value)