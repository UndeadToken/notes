struct Coordinate
{
    private int _x, _y;

    public int x
    {
        get
        {
            return _x;
        }

        set
        {
            _x = value;
            CoordinatesChanged(_x);
        }
    }

    public int y
    {
        get
        {
            return _y;
        }

        set
        {
            _y = value;
            CoordinatesChanged(_y);
        }
    }

    public event Action<int> CoordinatesChanged;
}


static void Main(string[] args)
{

    Coordinate point = new Coordinate();

    point.CoordinatesChanged += StructEventHandler;
    point.x = 10;
    point.y = 20;
}

static void StructEventHandler(int point)
{
    Console.WriteLine("Coordinate changed to {0}", point);
}
