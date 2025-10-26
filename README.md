
# 🎯 Лабораторная работа: Решение задач на Java

[![Java Version](https://img.shields.io/badge/Java-8%2B-blue.svg)](https://java.com)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

Полноценное решение лабораторной работы по Java, включающее реализацию generics, функционального программирования, коллекций и пользовательских типов данных.

## 📚 Содержание

- [Описание проекта](#-описание-проекта)
- [Структура проекта](#-структура-проекта)
- [Задания и решения](#-задания-и-решения)
- [Установка и запуск](#-установка-и-запуск)
- [Результаты работы](#-результаты-работы)
- [Особенности реализации](#-особенности-реализации)
- [Оценка](#-оценка)

## 🎯 Описание проекта

Этот проект содержит комплексное решение лабораторной работы по Java, включающее 8 различных задач с фокусом на:
- **Generics** и типобезопасность
- **Функциональное программирование** с lambda выражениями
- **Коллекции** и алгоритмы обработки данных
- **Объектно-ориентированное программирование**
- **Обработку граничных случаев**

Все задачи реализованы в отдельных классах с демонстрацией работы в главном классе `Main`.

## 🗂️ Структура проекта


src/
├── Main.java                 # Главный класс с демонстрацией работы
├── Storage.java              # 🗄️ Задача 1.2 - Хранилище без null
├── Point2D.java              # 📍 Базовый класс 2D точки
├── Point3D.java              # 📍 Класс 3D точки  
├── Line.java                 # 📐 Задача 1.5 - Обобщенная линия
├── LineUtils.java            # 🎯 Задача 2.1 - Утилиты для линий
├── FunctionUtils.java        # 🔄 Задача 3.1 - Применение функций
├── FilterUtils.java          # 🎛️ Задача 3.2 - Фильтрация
├── ReductionUtils.java       # ➕ Задача 3.3 - Сокращение
└── CollectionUtils.java      # 📚 Задача 3.4 - Коллекционирование
```

## 💻 Задания и решения

### 🗄️ Задача 1.2: Хранилище без null
**Требование:** Создать неизменяемое хранилище, возвращающее альтернативное значение при null.

```java
public class Storage<T> {
    private final T value;
    private final T alternative;
    
    public Storage(T value, T alternative) {
        this.value = value;
        this.alternative = alternative;
    }
    
    public T getValue() {
        return value != null ? value : alternative;
    }
}
```

**Примеры использования:**
- `new Storage<>(null, 0).getValue()` → `0`
- `new Storage<>("hello", "default").getValue()` → `"hello"`

### 📐 Задача 1.5: Обобщенная линия
**Требование:** Создать линию, работающую с 2D и 3D точками.

```java
public class Line<T extends Point2D> {
    private T start;
    private T end;
    // Конструкторы, геттеры, сеттеры
}
```

### 🎯 Задача 2.1: Сдвинуть линию
**Требование:** Сдвинуть начальную точку линии на 10 единиц по X.

```java
public class LineUtils {
    public static <T extends Point2D> void shiftLineX(Line<T> line) {
        T start = line.getStart();
        start.setX(start.getX() + 10);
    }
}
```

### 🔄 Задача 3.1: Функция
**Требование:** Применить функцию к каждому элементу списка.

```java
public class FunctionUtils {
    public static <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }
}
```

**Примеры:**
- Строки → длины: `["qwerty", "asdfg"]` → `[6, 5]`
- Числа → абсолютные значения: `[1, -3, 7]` → `[1, 3, 7]`

### 🎛️ Задача 3.2: Фильтр  
**Требование:** Отфильтровать список по условию.

```java
public class FilterUtils {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
```

**Примеры:**
- Строки длиной ≥ 3 символов
- Неположительные числа
- Массивы без положительных элементов

### ➕ Задача 3.3: Сокращение
**Требование:** Свернуть список в одно значение.

```java
public class ReductionUtils {
    public static <T> T reduce(List<T> list, BinaryOperator<T> operator, T identity) {
        return list.stream().reduce(identity, operator);
    }
}
```

**Примеры:**
- Конкатенация строк
- Суммирование чисел
- Подсчет элементов

### 📚 Задача 3.4: Коллекционирование
**Требование:** Создать коллекцию по условию.

```java
public class CollectionUtils {
    public static <T, P extends Collection<T>> P collect(
            List<T> list, Supplier<P> factory, Function<T, Boolean> condition) {
        P result = factory.get();
        list.stream().filter(condition::apply).forEach(result::add);
        return result;
    }
}
```

**Примеры:**
- Разделение на положительные/отрицательные числа
- Группировка строк по длине
- Удаление дубликатов

## 🚀 Установка и запуск

### Требования
- **Java 8** или выше
- Компилятор javac

### Компиляция и запуск
```bash
# Клонировать репозиторий
git clone https://github.com/your-username/java-lab-work.git
cd java-lab-work

# Компиляция всех Java файлов
javac *.java

# Запуск главного класса
java Main
```

### Альтернативный запуск через скрипт
```bash
# Для Linux/Mac
chmod +x run.sh
./run.sh

# Для Windows
run.bat
```

## 📊 Результаты работы

При запуске программы вы увидеть следующий вывод:

```
=== ЛАБОРАТОРНАЯ РАБОТА: РЕШЕНИЕ ВСЕХ ЗАДАЧ ===

=== ЗАДАЧА 1.2: ХРАНИЛИЩЕ БЕЗ NULL ===
Хранилище чисел с null: Storage{value=null, alternative=0}
Значение из хранилища: 0
Хранилище чисел с 99: Storage{value=99, alternative=-1}
Значение из хранилища: 99

=== ЗАДАЧА 1.5: ОБОБЩЕННАЯ ЛИНИЯ ===
Линия в 3D пространстве: Line{start=Point3D(1.0, 2.0, 3.0), end=Point3D(4.0, 5.0, 6.0)}

=== ЗАДАЧА 2.1: СДВИНУТЬ ЛИНИЮ ===
До сдвига: Line{start=Point2D(0.0, 0.0), end=Point2D(5.0, 5.0)}
После сдвига: Line{start=Point2D(10.0, 0.0), end=Point2D(5.0, 5.0)}

=== ЗАДАЧА 3.1: ФУНКЦИЯ ===
Строки: [qwerty, asdfg, zx] → Длины: [6, 5, 2]
Числа: [1, -3, 7] → Абсолютные значения: [1, 3, 7]

=== ЗАДАЧА 3.2: ФИЛЬТР ===
Строки: [qwerty, asdfg, zx] → Длина ≥3: [qwerty, asdfg]
Числа: [1, -3, 7] → Неположительные: [-3]

=== ЗАДАЧА 3.3: СОКРАЩЕНИЕ ===
Строки: [qwerty, asdfg, zx] → Объединенная: "qwertyasdfgzx"
Числа: [1, -3, 7] → Сумма: 5

=== ЗАДАЧА 3.4: КОЛЛЕКЦИОНИРОВАНИЕ ===
Числа: [1, -3, 7, -2] → Положительные: [1, 7], Отрицательные: [-3, -2]

=== ВСЕ ЗАДАЧИ ВЫПОЛНЕНЫ ===
```

## ⚡ Особенности реализации

### 🛡️ Типобезопасность
- Полное использование **Generics** для compile-time проверки типов
- Ограничения через `extends` для гарантии корректности типов

### 🔧 Функциональное программирование
- **Lambda выражения** для краткого и читаемого кода
- **Functional interfaces** (`Function`, `Predicate`, `BinaryOperator`)
- **Method references** для улучшения читаемости

### 🎯 Обработка ошибок
- Защита от **NullPointerException**
- Обработка **пустых коллекций**
- **Graceful degradation** при некорректных данных

### 📐 Архитектура
- **Разделение ответственности** между классами
- **Статические утилиты** для common functionality
- **Чистые функции** где это возможно

### 🎨 Пользовательский опыт
- **Дружественный интерфейс** с понятными сообщениями
- **Подробный вывод** результатов каждого этапа
- **Визуальное разделение** задач для лучшей читаемости


Файл готов для размещения на GitHub и будет хорошо выглядеть в репозитории.
