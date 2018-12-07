using System;

namespace Inheritance
{
    public class Pair
    {
        private long bitString;
        public static int count = 0;
        public Pair(long s = 0)
        {
            bitString = s;
            count++;
        }
        public long Bitstring
        {
            get { return bitString; }
            set { bitString = value; }
        }
        public void Read()
        {
            string input = Console.ReadLine();
            this.Bitstring = long.Parse(input);
        }
        public void Display()
            => Console.WriteLine(this.Bitstring.ToString());

        public void CompareTo(Pair s)
        {
            if (s.Bitstring == this.Bitstring)
            { 
                s.Display();
                Console.Write("= ");
                this.Display();
            }
            else if (s.Bitstring < this.Bitstring)
            {
                s.Display();
                Console.Write("< ");
                this.Display();
            }
            else
            {
                s.Display();
                Console.Write("> ");
                this.Display();
            }
        }
    }
}
