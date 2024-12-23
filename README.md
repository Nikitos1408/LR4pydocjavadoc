# Лабораторная работа 4 - Угарин Н.А

## 1. Введение

Целью данной лабораторной работы являлось изучение методов документирования кода на языках Python и Java с использованием инструментов Pydoc и Javadoc. Основными задачами работы было освоение процесса добавления docstrings и Javadoc-комментариев, генерации HTML-документации, а также ее публикации на GitHub Pages. Работа также затрагивала тему соотнесения документирования с подходом самодокументирующегося кода.

## 2. Ход работы

Часть 1: Python и Pydoc

Был выбран проект, реализующий различные способы генерации последовательности чисел Фибоначчи.

Примеры добавленных docstring-комментариев:
```
def fib(n):
    """
    Генерирует список чисел Фибоначчи, не превышающих n.

    Args:
        n (int): Максимальное значение числа Фибоначчи в списке.

    Returns:
        list: Список чисел Фибоначчи, не превышающих n.
             Возвращает None, если n отрицательное.
    """
```
```
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
```
## Процесс генерации и публикации документации:

Добавлены docstrings к функциям и классам в файле ```gen_fib.py```\
Сгенерирована HTML-документация с помощью команды ```python -m pydoc -w gen_fib```\
Создана директория docs и перемещен сгенерированный файл ```gen_fib.html``` в неё.\
Создан файл index.html в папке docs со ссылками на ```gen_fib.html```\
Создан репозиторий на GitHub.\
Загружен проект с папкой docs в репозиторий, используя Git.\
Настроены GitHub Pages для публикации документации из папки /docs ветки main.

## Возникшие проблемы и способы их решения:

Проблема: Ошибка src refspec main does not match any при загрузке кода на GitHub. Решение: Создана локальная ветка main командой 
```git branch -M main```, затем коммиты ```git add .``` и ```git commit -m "Initial commit"``` и отправка на GitHub ```git push -u origin main```

## Часть 2: Java и Javadoc

Был выбран проект, аналогичный проекту на Python, реализующий различные способы генерации последовательности чисел Фибоначчи на Java.

Примеры добавленных Javadoc-комментариев:
```
/**
 * Генерирует список чисел Фибоначчи, не превышающих n.
 *
 * @param n Максимальное значение числа Фибоначчи в списке.
 * @return Список чисел Фибоначчи, не превышающих n. Возвращает null, если n отрицательное.
 */
public static List<Integer> fib(int n) {
    ...
}
```
```
/**
* Класс, позволяющий получать числа Фибоначчи по индексу, генерируя их “лениво”. / public static class FibonacciList implements Iterable{ /*
* Конструктор класса FibonacciList. *
* @param maxValue Максимальное значение чисел Фибоначчи, которые нужно сгенерировать.
*/
public FibonacciList(int maxValue) {
    ...
}
```

## Генерация документации с помощью Javadoc:

Добавлены Javadoc-комментарии к классам и методам в файлах Fibonacci.java\
Сгенерирована HTML-документация с помощью команды ```javadoc -encoding utf-8 *.java```\
Создана директория docs (если еще не была) и перемещено содержимое директории doc в нее.\
Добавлены ссылки на сгенерированную документацию в index.html.

## Сравнение двух методов генерации документации:
В данной работе Javadoc был использован напрямую.\
Оба метода (и Pydoc и Javadoc) генерируют HTML документацию. Pydoc может быть более удобным, так как он может быть вызван напрямую из Python. Javadoc требует компиляции java файлов.

## Процесс публикации документации: 
Процесс публикации был идентичен процессу, описанному в части 1. Общая папка docs, с html-файлами, сгенерированными pydoc и javadoc была загружена на github pages.

## Возникшие проблемы и способы их решения:

Проблема: Ошибка кодировки при генерации Javadoc. Решение: Запуск javadoc с указанием кодировки \
```UTF-8: javadoc -encoding utf-8 *.java```

## Соотнесение документирования с подходом самодокументирующегося кода:

Хороший самодокументирующийся код стремится быть понятным без лишних комментариев, с помощью четких и выразительных имен, разделения на небольшие функции и т.д.
Однако, документация, сгенерированная с помощью инструментов, таких как pydoc и javadoc, все равно необходима для общего понимания архитектуры проекта, а также для предоставления подробной информации о параметрах, возвращаемых значениях и исключениях, возникающих в ходе работы кода.
Следовательно, документирование кода с помощью инструментов pydoc и javadoc, помогает получить более подробное описание, чем самодокументирующийся код.

## 3. Выводы

Pydoc: Инструмент для Python, встроен в язык, прост в использовании, генерирует документацию на основе docstrings. \
Javadoc: Инструмент для Java, используется для генерации документации из Javadoc-комментариев, требует предварительной компиляции файлов. \
Оба инструмента хорошо справляются со своей задачей, предоставляя разработчикам возможность быстро и просто генерировать документацию.

Анализ и выводы о необходимости документации в разработке:\
Документация является неотъемлемой частью процесса разработки программного обеспечения.

## 4. Ссылки

Ссылки на опубликованную документацию на GitHub Pages:\
https://nikitos1408.github.io/LR4pydocjavadoc/

Ссылки на использованные ресурсы и материалы: \
Документация Pydoc: https://docs.python.org/3/library/pydoc.html \
Документация Javadoc: https://docs.oracle.com/en/java/javase/23/docs/specs/man/javadoc.html \
Документация GitHub Pages: https://pages.github.com/
