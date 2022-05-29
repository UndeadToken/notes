using System;

namespace Common
{
    public class Small
    {

    }
    public class Big : Small
    {

    }
    public class Bigger : Big
    {

    }
}

namespace Delegate
{
    public delegate Common.Small covarDel(Common.Big mc);

    public class Program
    {
        public static Common.Big Method1(Common.Big bg)
        {
            Console.WriteLine("Method1");

            return new Common.Big();
        }
        public static Common.Small Method2(Common.Big bg)
        {
            Console.WriteLine("Method2");

            return new Common.Small();
        }

        public static void Main(string[] args)
        {
            covarDel del = Method1;

            Common.Small sm1 = del(new Common.Big());

            del = Method2;
            Common.Small sm2 = del(new Common.Big());
        }
    }
}

namespace Delegate2
{
    delegate Common.Small covarDel(Common.Big mc);

    class Program
    {
        static Common.Big Method1(Common.Big bg)
        {
            Console.WriteLine("Method1");
            return new Common.Big();
        }
        static Common.Small Method2(Common.Big bg)
        {
            Console.WriteLine("Method2");
            return new Common.Small();
        }

        static Common.Small Method3(Common.Small sml)
        {
            Console.WriteLine("Method3");

            return new Common.Small();
        }
        static void Main(string[] args)
        {
            covarDel del = Method1;
            del += Method2;
            del += Method3;

            Common.Small sm = del(new Common.Big());
        }
    }
