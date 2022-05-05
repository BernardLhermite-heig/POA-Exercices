#include <iostream>

#include "Array.hpp"


template<typename Iterator, typename Fn>
Fn foreach(Iterator begin, Iterator end, Fn fn) {
   for (; begin != end; ++begin) {
      fn(*begin);
   }
   return fn;
}


int main() {
   Array<int> array(5);

   for (auto& i: array) {
      i = rand() % 10;
   }

   foreach(array.begin(), array.end(), [](int i) {
      std::cout << i << " ";
   });
   std::cout << "Hello, World!" << std::endl;
   return 0;
}