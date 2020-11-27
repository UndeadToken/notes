#include <deque>
#include <list>
#include <stack>
#include <queue>
#include <vector>

using namespace std;

// Adaptive containers
// Containers that internally use another and present a distinct behavior are called adaptive containers.

// stacks LIFO (Last in first out)
// queues FIFO

int main()
{
    // A stack of ints and a stack of ints within a vector.
    stack<int> stk;
    stack<int, vector<int>> stk2;

    // A queue of ints and a queue of ints in a list.
    queue<int> q1;
    queue<int, list<int>> q2;

    // A priority queue sorted using std::less <> (default)
    priority_queue<int> p1q;

    // A priority queue sorted using std::greater <>
    priority_queue<int, deque<int>, greater<>> pq2;

    return 0;
}
