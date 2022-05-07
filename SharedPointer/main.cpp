/**
 * @author Marengo Stéphane
 */

#include <iostream>
#include "SharedPointer.hpp"

using namespace std;

int main() {
   auto t = new int(1);
   SharedPointer<int> sp1(t);
   SharedPointer<int> sp2(sp1);
   *sp2 = 2;
   cout << *sp1 << endl;
   SharedPointer<int> sp3(new int(3));
   sp2 = sp3;
   sp1 = SharedPointer<int>(new int(4));
}
