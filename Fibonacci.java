import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Класс, содержащий методы для работы с числами Фибоначчи.
 */
public class Fibonacci {

    /**
     * Генерирует список чисел Фибоначчи, не превышающих n.
     *
     * @param n Максимальное значение числа Фибоначчи в списке.
     * @return Список чисел Фибоначчи, не превышающих n. Возвращает null, если n отрицательное.
     */
    public static List<Integer> fib(int n) {
        if (n < 0) {
            return null;
        }
        List<Integer> resList = new ArrayList<>();
        resList.add(0);
        if (n == 0){
            return resList;
        }
        resList.add(1);
        if (n == 1){
           return resList;
        }
        while (resList.get(resList.size() - 1) + resList.get(resList.size() - 2) <= n) {
            resList.add(resList.get(resList.size() - 1) + resList.get(resList.size() - 2));
        }
        return resList;
    }

    /**
     * Класс, позволяющий получать числа Фибоначчи по индексу, генерируя их "лениво".
     */
    public static class FibonacciList implements Iterable<Integer>{
         private final int maxValue;
         private final List<Integer> list;

        /**
         * Конструктор класса FibonacciList.
         *
         * @param maxValue Максимальное значение чисел Фибоначчи, которые нужно сгенерировать.
         */
         public FibonacciList(int maxValue) {
             this.maxValue = maxValue;
             this.list = new ArrayList<>();
             list.add(0);
             list.add(1);
         }


         /**
         * Получает элемент списка по индексу, генерируя элементы по мере необходимости.
         *
         * @param idx Индекс числа Фибоначчи, которое нужно получить.
         * @return Число Фибоначчи по индексу.
         * @throws IndexOutOfBoundsException если запрашиваемый индекс выходит за границы max_value.
          */
        public int get(int idx) {
             if (maxValue == 1) {
                return list.get(idx);
            }
             while (list.size() <= idx) {
                 int nextFib = list.get(list.size() - 1) + list.get(list.size() - 2);
                 if (nextFib > maxValue) {
                    throw new IndexOutOfBoundsException(String.valueOf(idx));
                }
                list.add(nextFib);
            }
            return list.get(idx);
        }


        /**
         * Возвращает итератор для обхода элементов FibonacciList.
         *
         * @return итератор типа Iterator<Integer>
         */
        @Override
        public Iterator<Integer> iterator() {
            return new FibonacciIterator();
        }

        private class FibonacciIterator implements Iterator<Integer> {
            private int index = 0;

            /**
             * Проверяет, есть ли следующий элемент.
             *
             * @return true, если есть следующий элемент, иначе false
             */
            @Override
            public boolean hasNext() {
                try {
                   get(index);
                    return true;
                } catch (IndexOutOfBoundsException e){
                    return false;
                }
            }

            /**
             * Возвращает следующий элемент списка
             *
             * @return следующее число Фибоначчи.
             * @throws NoSuchElementException если нет следующего элемента.
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        }
    }

    /**
     * Возвращает итератор для бесконечной последовательности чисел Фибоначчи.
     *
     * @return Итератор, который генерирует бесконечную последовательность чисел Фибоначчи.
     */
    public static Iterable<Integer> fibClassicIter() {
          return () -> new Iterator<Integer>() {
              int a = 0;
              int b = 1;

              @Override
              public boolean hasNext() {
                 return true;
             }

             @Override
             public Integer next() {
                 int res = a;
                 a = b;
                 b = res + b;
                 return res;
             }
         };
    }

    /**
     * Возвращает итератор чисел Фибоначчи, ограниченный максимальным значением из iterable.
     *
     * @param iterable Итерируемый объект, определяющий границу чисел Фибоначчи.
     * @return Итератор чисел Фибоначчи, не превышающих максимальное значение iterable.
     */
     public static Iterable<Integer> fibIter(Iterable<Integer> iterable) {
         int max = Integer.MIN_VALUE;
         for(int i : iterable){
              if(i > max){
                  max = i;
              }
         }
         final int maxValue = max;
        return () -> new Iterator<Integer>() {
            Iterator<Integer> fibIter = fibClassicIter().iterator();
             Integer nextFib = fibIter.next();

            @Override
            public boolean hasNext() {
                return nextFib <= maxValue;
            }

            @Override
            public Integer next() {
                 int currentFib = nextFib;
                if(hasNext()){
                     nextFib = fibIter.next();
                 }
                return currentFib;
            }
        };
    }



    /**
     * Главная функция для демонстрации работы методов.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        System.out.println("fib():");
        System.out.println(fib(10));
        System.out.println("FibonacciList():");
        FibonacciList fibonacciList = new FibonacciList(10);
        for (int el : fibonacciList) {
            System.out.print(el + " ");
        }
        System.out.println();

       System.out.println("fibClassicIter():");
       Iterator<Integer> iterator = fibClassicIter().iterator();
       for (int i = 0; i < 15; i++){
            System.out.print(iterator.next() + " ");
        }
       System.out.println();

        System.out.println("fibIter(range(15))");
        for (int el : fibIter(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))) {
           System.out.print(el + " ");
       }
    }
}