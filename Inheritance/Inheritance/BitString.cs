using System;

namespace Inheritance
{
    class BitString : Pair
    {
        public BitString(long s1 = 0) : base(s1)
        {
        }
        static BitString Result = new BitString();
        public static BitString operator &(BitString obj1, BitString obj2)
        {
            Result.Bitstring = obj1.Bitstring & obj2.Bitstring;
            return Result;
        }
        public static BitString operator |(BitString obj1, BitString obj2)
        {
            Result.Bitstring = obj1.Bitstring | obj2.Bitstring;
            return Result;
        }
        public static BitString operator ^(BitString obj1, BitString obj2)
        {
            Result.Bitstring = obj1.Bitstring ^ obj2.Bitstring;
            return Result;
        }
        public static BitString operator ~(BitString obj)
        {
            Result.Bitstring = ~obj.Bitstring;
            return Result;
        }
        public static BitString operator <<(BitString obj, int sdvig)
        {
            Result.Bitstring = obj.Bitstring << sdvig;
            return Result;
        }
        public static BitString operator >>(BitString obj, int sdvig)
        {
            Result.Bitstring = obj.Bitstring >> sdvig;
            return Result;
        }
    }
}
