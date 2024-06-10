#include <vector>
#include <map>
#include <queue>

// Standard Template Library
// STL is a set of template classes and functions that supply the programmer with:
//   containers for storing information
//   iterators for accessing the information stored
//   algorithms for manipulating the content of the containers

// Containers
// The container types include Sequential; Associative, Adapters.

//   Sequential containers
//   These are containers used to store data in a sequential fashion. They are characterized by their fast insertion time
//   but are relatively slow in find operations.
//   includes std::vector, std::deque, std::list, std::forward_list

//   Associative containers
//   These are containers that store data in an associative fashion - akin to a dictionary. This results in slower
//   insertion times, but presents significant advantages when it comes to searching.
//   includes std::set, std::unordered_set, std::map, std::unordered_map, std::multi_set, std::unordered_multiset,
//            std::multi_map, std::unordered_multimap

//   Container Adapters
//   These are variants of sequential and associative containers.
//   includes std::stack, std::queue, std::priority_queue

int main()
{
    std::vector<int> vec;

    std::map<int, int> map;

    std::queue<int> queue;

    return 0;
}
