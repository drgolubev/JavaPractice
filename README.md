# Практические работы по Java

Все практические в одном проекте IntelliJ IDEA. Каждая работа — отдельный пакет в папке `src`.
Объяснения написаны прямо в коде, в комментариях.

## Как открыть и запустить

1. Распаковать архив.
2. IntelliJ IDEA → **File → Open…** → выбрать папку `JavaPractice`.
3. Если сверху появится жёлтая полоска «Project JDK is not defined» — нажать **Setup SDK** и выбрать любой JDK 17 или новее
   (если JDK нет — там же **Download JDK**).
4. Открыть нужный файл (в нём есть метод `main`) → зелёный треугольник слева от `main` → **Run**.

## Что где лежит

| Пакет | Практическая | Что запускать |
|---|---|---|
| `pr1` | ПР1: массивы, циклы, методы | `Task3SumAndAverage`, `Task4ArrayFromKeyboard` (ввод с клавиатуры), `Task5CommandLineArgs`, `Task6HarmonicSeries`, `Task7Factorial` |
| `pr1classes` | ПР1 «Классы. Создание объектов» | `zadanie1.TestA`, `zadanie2.A`, `rectangle.TestRectangle`, `stock.TestStock` |
| `pr2` | ПР2: UML, класс Author | `TestAuthor` |
| `pr3.shape` | ПР3, задание 1: абстрактный Shape, upcast/downcast, ошибки компиляции | `TestShape` |
| `pr3.movable` | ПР3, задание 2: интерфейс Movable, MovablePoint/Circle/Rectangle | `TestMovable` |
| `pr4.seasons` | ПР4, задание 1: времена года (enum) | `SeasonDemo` |
| `pr4.atelier` | ПР4, задание 2: ателье | `Atelier` |
| `pr4.shop` | ПР4, задание 3: интернет-магазин (меню в консоли, логин `denis` / пароль `1234`) | `OnlineShop` |
| `pr4.computer` | ПР4, задание 4: компьютер | `Computer` |
| `pr4.planet` | Пример enum Planet из txt-файла + методы name/ordinal/valueOf/values | `PlanetDemo` |
| `pr41.t1shape` … `pr41.t10transport` | ПР4.1, задания 1–10 | файл с `main` в каждом пакете |

Задание 8 и «Упражнение 1» из ПР4.1 совпадают с заданием 1 из ПР3, поэтому `pr41.t8abstractshape`
использует классы из `pr3.shape`.

## Что нужно сделать руками

- **UML-диаграммы** (ПР1 «Классы»: Rectangle и Stock) — по заданию их надо нарисовать на бумаге или в draw.io.
  Готовая диаграмма в текстовом виде лежит в комментарии в начале `Rectangle.java` и `Stock.java` — её достаточно перерисовать.
- **Git (ПР1, пункты 2 и 8)**: в IntelliJ **VCS → Share Project on GitHub** (или **Git → GitHub → Share Project on GitHub**),
  войти в GitHub — проект сам зальётся в новый репозиторий. Файл `.gitignore` уже есть, лишнее не попадёт.
- **Аргументы командной строки** (`Task5CommandLineArgs`): Run → Edit Configurations… → Program arguments.
