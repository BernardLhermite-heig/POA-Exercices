#include <iostream>

#include <vector>
#include "Array.hpp"


template<typename Iterator, typename Fn>
Fn foreach(Iterator begin, Iterator end, Fn fn) {
   for (; begin != end; ++begin) {
      fn(*begin);
   }
   return fn;
}

// << operator for Array
template<typename T>
std::ostream& operator<<(std::ostream& os, Array<T>& a) {
   os << "[";
   foreach(a.begin(), a.end(), [&os](const T& t) {
      os << t << ", ";
   });
   os << "]";
   return os;
}

using namespace std;

int main() {
   Array<int> array(5);

   Array<int>* a2 = new Array<int>{1, 2, 3, 4, 5};

   for (auto& i: array) {
      i = rand() % 10;
   }

   Array<int> a3(*a2);
   Array<int> a4;

   a4 = a3;

   cout << array << endl
        << a2 << endl
        << a3 << endl
        << a4 << endl;

   delete a2;

   cout << array << endl
        << a3 << endl
        << a4 << endl;

   std::cout << "Hello, World!" << std::endl;
   return 0;
}