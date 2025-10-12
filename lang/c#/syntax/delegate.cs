public delegate void MyDelegate(string msg); // declare a delegate

// set target method
MyDelegate del = new MyDelegate(MethodA);
// or 
MyDelegate del = MethodA;
// or set lambda expression 
MyDelegate del = (string msg) => Console.WriteLine(msg);

MyDelegate del = ClassA.MethodA;

// target method
static void MethodA(string message)
{
    Console.WriteLine(message);
}


del.Invoke("Hello World!");
// or 
del("Hello World!");

MyDelegate del1 = ClassA.MethodA;
MyDelegate del2 = ClassB.MethodB;

// multicast delegate
MyDelegate del = del1 + del2; // combines del1 + del2

public delegate T add<T>(T param1, T param2);
add<int> sum = Sum;

public static int Sum(int val1, int val2)
{
    return val1 + val2;
}
//
//
public class Player
{
public delegate void HealthChangedDelegate(int
currentHealth);
public event HealthChangedDelegate OnHealthChanged;
private int health;
public void TakeDamage(int damageAmount)
{
health -= damageAmount;
OnHealthChanged?.Invoke(health); // Raise the event
}
}
