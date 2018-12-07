using System;

namespace third
{
    class Linear : Series
    {
        public override void Read()
        {
            base.Read();
        }
        public override double calculateJthElement()
        {
            return a0 + j * d;
        }
        public override double calculateSumOfProgression()
        {
            return (n + 1)*(a0 + an) / 2;
        }
        public override void Display(double result)
        {
            Console.WriteLine(result.ToString());
        }
    }
}
