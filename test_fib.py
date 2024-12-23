import unittest
import itertools
from gen_fib import *

class TestFib(unittest.TestCase):
    """
    Класс TestFib для тестирования функций и классов, связанных с числами Фибоначчи.
    """

    def test_fib_1(self):
        """Тест для функции fib(n) с n=1."""
        self.assertEqual(fib(1), [0, 1], 'n = 1, list must be [0, 1]')

    def test_fib_2(self):
        """Тест для функции fib(n) с n=5."""
        self.assertEqual(fib(5), [0, 1, 1, 2, 3, 5], 'elements from 0 to 5')

    def test_fib_3(self):
        """Тест для функции fib(n) с n=-1 (проверка на корректную обработку некорректного ввода)."""
        self.assertIsNone(fib(-1), 'sequence starts from 0')

    def test_fib_lst_1(self):
        """Тест для класса FibonacchiLst с max_value=7."""
        self.assertEqual(list(FibonacchiLst(7)), [0, 1, 1, 2, 3, 5], 'elements form 0 to 5')

    def test_fib_lst_2(self):
        """Тест для класса FibonacchiLst с max_value=1."""
        self.assertEqual(list(FibonacchiLst(1)), [0, 1], 'n = 1, list must be [0, 1]')

    def test_fib_classic_iter_1(self):
       """Тест для генератора fib_classic_iter(), проверяем первые 3 элемента."""
       self.assertEqual(list(itertools.islice(fib_classic_iter(), 3)), [0, 1, 1], 'list must be [0, 1, 1]')

    def test_fib_classic_iter_2(self):
       """Тест для генератора fib_classic_iter(), проверяем первый элемент."""
       self.assertEqual(list(itertools.islice(fib_classic_iter(), 1)), [0], 'only one element, list must be [0]')

    def test_fib_iter_1(self):
        """Тест для функции fib_iter(), проверяем числа Фибоначчи, не превышающие max(range(5))."""
        self.assertEqual(list(fib_iter(range(5))), [0, 1, 1, 2, 3], 'elements from 0 to 3')

    def test_fib_iter_2(self):
        """Тест для функции fib_iter(), проверяем числа Фибоначчи, не превышающие max(range(9))."""
        self.assertEqual(list(fib_iter(range(9))), [0, 1, 1, 2, 3, 5, 8], 'elements from 0 to 8')

if __name__ == '__main__':
    unittest.main()