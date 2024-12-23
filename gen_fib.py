import itertools

def fib(n):
    """
    Генерирует список чисел Фибоначчи, не превышающих n.

    Args:
        n (int): Максимальное значение числа Фибоначчи в списке.

    Returns:
        list: Список чисел Фибоначчи, не превышающих n.
             Возвращает None, если n отрицательное.
    """
    if n < 0:
        return None
    res_lst = [0, 1]
    while res_lst[-1] + res_lst[-2] <= n:
        res_lst.append(res_lst[-1] + res_lst[-2])
    return res_lst[:n+1]

class FibonacchiLst:
    """
    Класс, позволяющий получать числа Фибоначчи по индексу, генерируя их "лениво".
    """
    def __init__(self, max_value):
        """
        Конструктор класса FibonacchiLst.

        Args:
            max_value (int): Максимальное значение чисел Фибоначчи, которые нужно сгенерировать.
        """
        self.max_value = max_value
        self.lst = [0, 1]

    def __getitem__(self, idx):
        """
        Метод для получения элемента класса по индексу.

        Args:
             idx (int): Индекс числа Фибоначчи, которое нужно получить.

        Returns:
             int: Число Фибоначчи по индексу.

        Raises:
            IndexError: Если запрошенный индекс выходит за границы max_value.
        """
        if self.max_value == 1:
            return self.lst[idx]
        while len(self.lst) <= idx:
            next_fib = self.lst[-1] + self.lst[-2]
            if next_fib > self.max_value:
                raise IndexError(idx)
            self.lst.append(next_fib)
        return self.lst[idx]

def fib_classic_iter():
    """
    Генератор бесконечной последовательности чисел Фибоначчи.

    Yields:
        int: Следующее число Фибоначчи.
    """
    a, b = 0, 1
    yield a
    yield b
    while True:
        a, b = b, a + b
        yield b

def fib_iter(num_iterable):
    """
     Возвращает итератор чисел Фибоначчи, ограниченный максимальным значением из num_iterable.

     Args:
        num_iterable (iterable): Итерируемый объект, определяющий границу чисел Фибоначчи.

     Returns:
        itertools.takewhile: Итератор чисел Фибоначчи.
    """
    return itertools.takewhile(lambda x: x <= max(num_iterable), fib_classic_iter())

def main():
    """
    Главная функция для демонстрации работы функций и класса.
    """
    print('fib():')
    print(fib(10))
    print('FibonacchiLst():')
    print(list(FibonacchiLst(10)))
    print('fib_classic_iter():')
    g = fib_classic_iter()
    for _ in range(15):
        print(next(g), end=' ')
    print()

    print('fib_iter(range(10))')
    for el in fib_iter(range(15)):
        print(el, end=' ')

if __name__ == '__main__':
    main()