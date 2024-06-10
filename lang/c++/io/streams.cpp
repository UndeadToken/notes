#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include <sstream>

using namespace std;

// << stream insertion operator
// >> stream extraction operator

void io()
{
    // Display formats
    int value = 1024;

    cout << value << endl;
    cout << oct << value << endl;
    cout << hex << value << endl;

    cout << setiosflags(ios_base::hex|ios_base::showbase|ios_base::uppercase); // base notation
    cout << value << endl;

    cout << resetiosflags(ios_base::hex|ios_base::showbase|ios_base::uppercase); // reset I/O flags
    cout << value << endl;

    // precision
    const double pi = (double) 22 / 7;
    cout << setprecision(7);
    cout << pi << endl;
    cout << scientific << pi << endl;
    cout << fixed << pi << endl;

    // alignment
    cout << setw(35);
    cout << "Hello Monster!" << endl;
    cout << setw(35) << setfill('*');
    cout << "Hello Monster!" << endl;

    // c-style input
    char cStr[10] = {0};
    //cin.get(cStr, 9); // cin::get
    //cout << cStr << endl; // geline(cin, cStr);
}

void writeFile()
{
    ofstream handle;
    handle.open("sample.txt", ios_base::out);

    if (handle.is_open()) {
        handle << "samples..." << endl;
    }

    handle.close();
}

void readFile()
{
    // read file
    ifstream handle;
    handle.open("sample.txt", ios_base::in);
    if (handle.is_open()) {
        string data;
        while (handle.good()) {
            getline(handle, data);
            cout << data << endl;
        }
        handle.close();
    }
    else
        cout << "open failed..." << endl;
}

void strings()
{
    string input = "45";

    stringstream stream;
    stream << input;

    string strInput;
    stream >> strInput;

    cout << strInput << endl;
}

int main()
{
    io();
    writeFile();
    readFile();
    strings();

    return 0;
}
