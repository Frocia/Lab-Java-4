import java.util.*;

public class Main {

    // Методы для демонстрации работы с Хранилищем
    public static void processNumberStorage(Storage<Integer> storage) {
        System.out.println("Значение из хранилища: " + storage.getValue());
    }

    public static void processStringStorage(Storage<String> storage) {
        System.out.println("Значение из хранилища: " + storage.getValue());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА: РЕШЕНИЕ ВСЕХ ЗАДАЧ ===\n");

        // Задача 1.2: Хранилище без null
        System.out.println("=== ЗАДАЧА 1.2: ХРАНИЛИЩЕ БЕЗ NULL ===");

        // Хранилище чисел с null
        Storage<Integer> numberStorageNull = new Storage<>(null, 0);
        System.out.println("Хранилище чисел с null: " + numberStorageNull);
        processNumberStorage(numberStorageNull);

        // Хранилище чисел с значением 99
        Storage<Integer> numberStorage99 = new Storage<>(99, -1);
        System.out.println("Хранилище чисел с 99: " + numberStorage99);
        processNumberStorage(numberStorage99);

        // Хранилище строк с null
        Storage<String> stringStorageNull = new Storage<>(null, "default");
        System.out.println("Хранилище строк с null: " + stringStorageNull);
        processStringStorage(stringStorageNull);

        // Хранилище строк со значением "hello"
        Storage<String> stringStorageHello = new Storage<>("hello", "hello world");
        System.out.println("Хранилище строк с 'hello': " + stringStorageHello);
        processStringStorage(stringStorageHello);

        System.out.println("\n=== ЗАДАЧА 1.5: ОБОБЩЕННАЯ ЛИНИЯ ===");

        // Создание линии в трехмерном пространстве
        Point3D start3D = new Point3D(1, 2, 3);
        Point3D end3D = new Point3D(4, 5, 6);
        Line<Point3D> line3D = new Line<>(start3D, end3D);
        System.out.println("Линия в 3D пространстве: " + line3D);

        // Создание линии в двухмерном пространстве
        Point2D start2D = new Point2D(0, 0);
        Point2D end2D = new Point2D(5, 5);
        Line<Point2D> line2D = new Line<>(start2D, end2D);
        System.out.println("Линия в 2D пространстве: " + line2D);

        System.out.println("\n=== ЗАДАЧА 2.1: СДВИНУТЬ ЛИНИЮ ===");

        System.out.println("До сдвига: " + line2D);
        LineUtils.shiftLineX(line2D);
        System.out.println("После сдвига по X на 10: " + line2D);

        System.out.println("\n=== ЗАДАЧА 3.1: ФУНКЦИЯ ===");

        // 1. Строки в их длины
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = FunctionUtils.applyFunction(strings, String::length);
        System.out.println("Строки: " + strings);
        System.out.println("Длины строк: " + lengths);

        // 2. Отрицательные числа в положительные
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> absoluteValues = FunctionUtils.applyFunction(numbers, n -> Math.abs(n));
        System.out.println("Числа: " + numbers);
        System.out.println("Абсолютные значения: " + absoluteValues);

        // 3. Максимальные значения массивов
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{-1, -5, 0},
                new int[]{10, 20, 30, 5}
        );
        List<Integer> maxValues = FunctionUtils.applyFunction(arrays, arr -> {
            int max = arr[0];
            for (int num : arr) {
                if (num > max) max = num;
            }
            return max;
        });
        System.out.println("Массивы: " + arraysToString(arrays));
        System.out.println("Максимальные значения: " + maxValues);

        System.out.println("\n=== ЗАДАЧА 3.2: ФИЛЬТР ===");

        // 1. Строки длиной >= 3
        List<String> filteredStrings = FilterUtils.filter(strings, s -> s.length() >= 3);
        System.out.println("Исходные строки: " + strings);
        System.out.println("Строки длиной >= 3: " + filteredStrings);

        // 2. Неположительные числа
        List<Integer> nonPositiveNumbers = FilterUtils.filter(numbers, n -> n <= 0);
        System.out.println("Исходные числа: " + numbers);
        System.out.println("Неположительные числа: " + nonPositiveNumbers);

        // 3. Массивы без положительных элементов
        List<int[]> arraysWithoutPositive = FilterUtils.filter(arrays, arr -> {
            for (int num : arr) {
                if (num > 0) return false;
            }
            return true;
        });
        System.out.println("Исходные массивы: " + arraysToString(arrays));
        System.out.println("Массивы без положительных элементов: " + arraysToString(arraysWithoutPositive));

        System.out.println("\n=== ЗАДАЧА 3.3: СОКРАЩЕНИЕ ===");

        // 1. Конкатенация строк
        String concatenated = ReductionUtils.reduce(strings, (s1, s2) -> s1 + s2, "");
        System.out.println("Исходные строки: " + strings);
        System.out.println("Объединенная строка: " + concatenated);

        // 2. Сумма чисел
        Integer sum = ReductionUtils.reduce(numbers, (a, b) -> a + b, 0);
        System.out.println("Исходные числа: " + numbers);
        System.out.println("Сумма: " + sum);

        // 3. Общее количество элементов в списках списков
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        // Сначала преобразуем каждый список в его длину
        List<Integer> lengthsOfLists = FunctionUtils.applyFunction(listOfLists, List::size);
        // Затем суммируем длины
        Integer totalElements = ReductionUtils.reduce(lengthsOfLists, (a, b) -> a + b, 0);

        System.out.println("Список списков: " + listOfLists);
        System.out.println("Общее количество элементов: " + totalElements);

        // Тест с пустым списком
        List<String> emptyList = new ArrayList<>();
        String emptyResult = ReductionUtils.reduce(emptyList, (s1, s2) -> s1 + s2, "default");
        System.out.println("Результат для пустого списка: " + emptyResult);

        System.out.println("\n=== ЗАДАЧА 3.4: КОЛЛЕКЦИОНИРОВАНИЕ ===");

        // 1. Разделение на положительные и отрицательные числа
        List<Integer> numbersForCollection = Arrays.asList(1, -3, 7, -2, 0, -5);

        List<Integer> positiveNumbers = CollectionUtils.collect(
                numbersForCollection,
                ArrayList::new,
                n -> n > 0
        );

        List<Integer> negativeNumbers = CollectionUtils.collect(
                numbersForCollection,
                ArrayList::new,
                n -> n < 0
        );

        System.out.println("Исходные числа: " + numbersForCollection);
        System.out.println("Положительные числа: " + positiveNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        scanner.close();
        System.out.println("\n=== ВСЕ ЗАДАЧИ ВЫПОЛНЕНЫ ===");
    }

    // Вспомогательный метод для преобразования списка массивов в строку
    private static String arraysToString(List<int[]> arrays) {
        List<String> result = new ArrayList<>();
        for (int[] arr : arrays) {
            result.add(Arrays.toString(arr));
        }
        return result.toString();
    }
}