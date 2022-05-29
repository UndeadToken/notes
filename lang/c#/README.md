# C#

### Keyboards

abstract
async
const
event
extern
new
override
partial
readonly
sealed
static
unsafe
virtual
volatile

### Types

bool
byte
char
class
decimal
double
enum
float
int
long
sbyte
short
string
struct
uint
ulong
ushort

### Static property

```c#
static int MyProperty { get; set; }
```

### Type infer.
```c#
var j = i + 1; // compiles as int
```

### Types

|Alias|.NET Type|Type|
byte|System.Byte|struct|
|sbyte|System.SByte	struct|
|int|System.Int32|struct|
|uint|System.UInt32|struct|
|short|System.Int16|struct|
|ushort|System.UInt16|struct|
|long|System.Int64|struct|
|ulong|System.UInt64|struct|
|float|System.Single|struct|
|double|System.Double|struct|
|char|System.Char|struct|
|bool|System.Boolean|struct|
|object|System.Object|Class|
|string|System.String|Class|
|decimal|System.Decimal|struct|
|DateTime|System.DateTime|struct|

### Default values
```c#
int i = default(int); // 0
float f = default(float);// 0
decimal d = default(decimal);// 0
bool b = default(bool);// false
char c = default(char);// '\0'

// C# 7.1 onwards
int i = default; // 0
float f = default;// 0
decimal d = default;// 0
bool b = default;// false
char c = default;// '\0'
```

### Numbers

Integer types                Floating point types
byte  short  int  long       float double decimal
sbyte ushort uint ulong

byte: 8-bit 0-255
sbyte: 8-bit -128-127

short 16-bit -32,768-32,767
ushort: 16-bit 0-65,535

int 32-bit -2,147,483,648-2,147,483,648
uint 32-bit 0-4,294,967,295

long 64-bit -9,223,372,036,854,775,808-9,223,372,036,854,775,807
ulong 64-bit 0-18,446,744,073,709,551,615

long l1 = -9223372036854775808;
long l2 = 9223372036854775807;

ulong ul1 = 18223372036854775808ul;
ulong ul2 = 18223372036854775808UL;

float 32-bit (4 bytes) 3.4e−038-3.4e+038
float f1 = 1.23F;
float f1 = 1.23f;

double 64-bit (8-bytes) 1.7e−308-1.7e+308

decimal 16 bytes ±1.0 x 10-28 to ±7.9228 x 1028
decimal d2 = 1.1234567891345679123456789123m;

Int32.MaxValue

### Strings

string str1 = "Hello"; // uses string keyword

String str2 = "Hello"; // uses System.String class

char[] chars = {'H','e','l','l','o'};

string str1 = new string(chars);  
String str2 = new String(chars); 

foreach (char c in str1)
{
    Console.WriteLine(c);
}

string str = @"xyzdef\rabc";  // verbatim
string str2 = @"this is a 
        multi line 
        string";

string fullName = $"Mr. {firstName} {lastName}, Code: {code}";

### Date

//assigns default value 01/01/0001 00:00:00
DateTime dt1 = new DateTime(); 

//assigns year, month, day
DateTime dt2 = new DateTime(2015, 12, 31); 

//assigns year, month, day, hour, min, seconds
DateTime dt3 = new DateTime(2015, 12, 31, 5, 10, 20);
 
//assigns year, month, day, hour, min, seconds, UTC timezone
DateTime dt4 = new DateTime(2015, 12, 31, 5, 10, 20, DateTimeKind.Utc);

DateTime dt = new DateTime(636370000000000000); 
DateTime.MinValue.Ticks;  //min value of ticks
DateTime.MaxValue.Ticks; // max value of ticks

DateTime currentDateTime = DateTime.Now;  //returns current date and time
DateTime todaysDate = DateTime.Today; // returns today's date
DateTime currentDateTimeUTC = DateTime.UtcNow;// returns current UTC date and time

DateTime maxDateTimeValue = DateTime.MaxValue; // returns max value of DateTime
DateTime minDateTimeValue = DateTime.MinValue; // returns min value of DateTime

Time span
DateTime dt = new DateTime(2015, 12, 31);
TimeSpan ts = new TimeSpan(25,20,55);
DateTime newDate = dt.Add(ts);
Console.WriteLine(newDate);//1/1/2016 1:20:55 AM

DateTime dt1 = new DateTime(2015, 12, 31); 
DateTime dt2 = new DateTime(2016, 2, 2);
TimeSpan result = dt2.Subtract(dt1);//33.00:00:00

var str = "5/12/2020";
DateTime dt;
var isValidDate = DateTime.TryParse(str, out dt);

### Struct

struct Coordinate
{
    public int x;
    public int y;
}

Coordinate point = new Coordinate();
Console.WriteLine(point.x); //output: 0  
Console.WriteLine(point.y); //output: 0

### Enum

enum Foo {
   Bar, // 0
}

enum Categories: byte
{
    Electronics = 1,
}

]

### Anonymous Type

Properties are readonly.

var student = new { Id = 1, FirstName = "James", LastName = "Bond" };

### Dynamic Type

Ignores compile-time type checks.

dynamic MyDynamicVar = 1;
Console.WriteLine(MyDynamicVar.GetType());

### Nullable types.

Values cannot be null.

Nullable<int> i = null;

if (i.HasValue)
        Console.WriteLine(i.Value);

    Console.WriteLine(i.GetValueOrDefault()); 

int? i = null;
double? D = null;

int j = i ?? 0;

Nullable.Compare<int>(i, j)

### Data types:

Value Type
A data type is a value type if it holds a data value within its own memory space. It means the variables of these data types directly contain values.
All the value types derive from System.ValueType, which in-turn, derives from System.Object.

bool
byte
char
decimal
double
enum
float
int
long
sbyte
short
struct
uint
ulong
ushort

Passing Value Type Variables
When you pass a value-type variable from one method to another, the system creates a separate copy of a variable in another method. If value got changed in the one method, it wouldn't affect the variable in another method.

Reference Type
Unlike value types, a reference type doesn't store its value directly. Instead, it stores the address where the value is being stored. In other words, a reference type contains a pointer to another memory location that holds the data.

### Partial Class

public partial class Employee
{
    public int EmpId { get; set; }
    public string Name { get; set; }
}

### Generic constraints

GenericTypeName<T> where T  : contraint1, constraint2

class DataStore<T> where T : class
{
    public T Data { get; set; }
}

class DataStore<T> where T : class, new() // non-nullable value type

class DataStore<T> where T : IEnumerable


### Collections

The System.Collections namespace contains the non-generic collection types and System.Collections.Generic namespace includes generic collection types.

List<T>, Dictionary<TKey,TValue>, SortedList<TKey,TValue>, Queue<T>, Stack<T>, Hashset<T>

ArrayList, SortedList, Stack, Queue, Hashtable, BitArray

### Tuple

var person = Tuple.Create(1, "Steve", "Jobs");


Tuple<int, string, string> person = new Tuple <int, string, string>(1, "Steve", "Jobs");
numbers.Item1;
numbers.Rest;
numbers.Rest.Item8;

### Delegates

System.TResult delegate

funtion delegate
Func<int, int, int> sum;


action delegate
public delegate void Print(int val);


predicate delegate
Predicate<string> isUpper = IsUpperCase;
Predicate<string> isUpper = s => s.Equals(s.ToUpper());

Print print = delegate(int val) { 
        Console.WriteLine("Inside Anonymous method. Value: {0}", val); 
    };

### Events

An event is a notification sent by an object to signal the occurrence of an action. Events in .NET follow the observer design pattern.
In C#, an event is an encapsulated delegate. It is dependent on the delegate. The delegate defines the signature for the event handler method of the subscriber class.

public delegate void Notify();  // delegate
                    
public class ProcessBusinessLogic
{
    public event Notify ProcessCompleted; // event

}

.NET Framework includes built-in delegate types EventHandler and EventHandler<TEventArgs> for the most common events.

public event EventHandler ProcessCompleted;

OnProcessCompleted(EventArgs.Empty); //No event data

public event EventHandler<bool> ProcessCompleted;
OnProcessCompleted(true);

protected virtual void OnProcessCompleted(bool IsSuccessful)
    {
        ProcessCompleted?.Invoke(this, IsSuccessful);
    }

### Covariance

Covariance and contravariance allow us to be flexible when dealing with class hierarchy. Covariance enables you to pass a derived type where a base type is expected. Co-variance is like variance of the same kind.
Covariance can be applied on delegate, generic, array, interface, etc.

### Contravariance
Contravariane is applied to parameters. Cotravariance allows a method with the parameter of a base class to be assigned to a delegate that expects the parameter of a derived class.

### Extentions methods

Extension methods, as the name suggests, are additional methods. Extension methods allow you to inject additional methods without modifying, deriving or recompiling the original class, struct or interface. Extension methods can be added to your own custom class, .NET framework classes, or third party classes or interfaces.

int i = 10;

bool result = i.IsGreaterThan(100); //returns false

namespace ExtensionMethods
{
    public static class IntExtensions
     {
        public static bool IsGreaterThan(this int i, int value)
        {
            return i > value;
        }
    }
}

### Object Initializer

 Student std = new Student() { StudentID = 1, 
                                      StudentName = "Bill", 
                                      Age = 20, 
                                      Address = "New York"   
                                    };

var student5 = new Student() { StudentID = 5, StudentName = "Ron" };

IList<Student> studentList = new List<Student>() { 
  student1, 
