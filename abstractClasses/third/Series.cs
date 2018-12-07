using System;

namespace third
{ 
    abstract public class Series
    {
        protected int a0, j, an, n, d;
        public virtual void Read()
        {
            string input = Console.ReadLine();
            string[] numbers = input.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            a0 = int.Parse(numbers[0]);
            j = int.Parse(numbers[1]);
            an = int.Parse(numbers[2]);
            n = int.Parse(numbers[3]);
            d = int.Parse(numbers[4]);
        }
        public virtual void Display(double res)
        {
            Console.WriteLine(res.ToString());
        }
        public virtual double calculateJthElement()
        {
            return 0;
        }
        public virtual double calculateSumOfProgression()
        {
            return 0;
        }
    }
}