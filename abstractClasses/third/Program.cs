/*В следующих заданиях требуется реализовать абстрактный базовый класс, определив в нем виртуальные функции.
 * Эти функции определяются в производных классах.
 * В базовых классах должны быть объявлены виртуальные функции ввода/вывода, которые реализуются в производных классах.
   Вызывающая программа должна продемонстрировать все варианты вызова виртуальных функций с помощью указателей на базовый класс.
   Написать функцию вывода, получающую параметры базового класса по ссылке и демонстрирующую виртуальный вызов.
   Создать абстрактный базовый класс Series (прогрессия) с виртуальными функциями вычисления j-го элемента прогрессии и суммы прогрессии.
 * Определить производные классы: Linear (арифметическая) и Exponential (геометрическая).
 * Арифметическая прогрессия aj = a0 + jd, j = 0, 1, 2 … Сумма арифметической прогрессии: sn = (n + 1) (a0 + an) / 2.
 * Геометрическая прогрессия: aj = a0 rj, j = 0, 1, 2 … Сумма геометрической прогрессии: sn = (a0 - anr) / (1 - r)*/

using System;

namespace third
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter a0, j, an, n, d to calculate arithmetic progression through the space: ");
            Series Progression = new Linear();
            Progression.Read();
            Console.Write("Jth element of arithmetic progression: ");
            Progression.Display(Progression.calculateJthElement());
            Console.Write("Sum of arithmetic progression: ");
            Progression.Display(Progression.calculateSumOfProgression());

            Console.Write("Enter a0, j, an, n, r to calculate geometric progression through the space: ");
            Series Progr = new Exponential();
            Progr.Read();
            Console.Write("Jth element of geometric progression: ");
            Progr.Display(Progr.calculateJthElement());
            Console.Write("Sum of geometric progression: ");
            Progr.Display(Progr.calculateSumOfProgression());
            Console.ReadKey();
        }
    }
}
