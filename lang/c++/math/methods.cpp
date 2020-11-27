#include <iostream>

const double PI = 3.14159;

double area(double radius);
double area(double radius, double height);
double circumference(double radius);

int main()
{
    double radius = 12.4;
    double height = 40;

    std::cout << area(radius) << std::endl;
    std::cout << area(radius, height) << std::endl;
    std::cout << circumference(radius) << std::endl;

    return 0;
}

double area(double radius)
{
    return PI * radius * radius;
}

double area(double radius, double height)
{
    return 2 * PI * radius * radius + 2 * PI * radius * height;
}

double circumference(double radius)
{
    return 2 * PI * radius;
}
