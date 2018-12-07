using System;

namespace third
{
    class Exponential: Series
    {
        public override void Read()
        {
            base.Read();
        }
        public override void Display(double result)
        {
            Console.WriteLine(result.ToString());
        }
        public override double calculateJthElement()
        {
            return a0*d*j;
        }
        public override double calculateSumOfProgression()
        {
            return (a0 - an*d)/(1-d);
        }
    }
}
