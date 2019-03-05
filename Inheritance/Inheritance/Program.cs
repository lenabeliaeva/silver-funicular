/*В следующих заданиях требуется реализовать классы как классы-наследники с перегрузкой операций и конструкторами,
 * используя открытое наследование. В качестве базового класса реализовать подходящий класс-структуру: пару (Pair)
 * чисел с конструкторами, с полным набором операций сравнения и счетчиком объектов.
 * Реализовать для структуры функции ввода\вывода в виде дружественных.
 * Не определять функции ввода\вывода объектов для основных классов.
 * 
 * Создать класс BitString для работы с 64-битовыми строками.
 * Битовая строка должна быть представлена двумя полями типа unsigned long.
 * Должны быть реализованы все традиционные операции для работы с битами: and, xor, or, not.
 * Реализовать сдвиг влево ShiftLeft и сдвиг вправо shiftRight на заданное количество битов.
 */

using System;

namespace Inheritance
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Hello, enter your numbers: ");
            BitString s1 = new BitString();
            s1.Read();
            BitString s2 = new BitString();
            s2.Read();

            Console.Write("Enter a number of bits you want to shift: ");
            string inputShift = Console.ReadLine();
            int shift = int.Parse(inputShift);

            Console.Write("Comparison: ");
            s1.CompareTo(s2);

            Console.Write("Logical multiplication: ");
            (s1 & s2).Display();
            
            Console.Write("Logical addition: ");
            (s1 | s2).Display();

            BitString Xor = s1 ^ s2;
            Console.Write("Logical exclusive OR: ");
            (s1 ^ s2).Display();

            Console.Write("Logical negation: ");
            (~s1).Display();
            (~s2).Display();

            Console.Write("Shift left: ");
            (s1 << shift).Display();
            (s2 << shift).Display();

            Console.Write("Shift right: ");
            (s1 << shift).Display();
            (s2 << shift).Display();

            Console.Write("Object's counter: ");
            Console.WriteLine(Pair.(count-1).ToString());

            Console.ReadKey();
        }
    }
}

