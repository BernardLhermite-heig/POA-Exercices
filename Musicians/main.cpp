#include <iostream>
#include <memory>
#include "Musician.hpp"
#include "Band.hpp"

using namespace std;

int main() {
   shared_ptr<Musician>
      john = make_shared<Musician>("John"),
      paul = make_shared<Musician>("Paul"),
      george = make_shared<Musician>("George"),
      ringo = make_shared<Musician>("Ringo");

   shared_ptr<Band> beatles = make_shared<Band>("The Beatles");

   beatles->setMembers({john, paul, george, ringo});
   cout << beatles->toString() << endl;
   cout << john->toString() << endl;

   shared_ptr<Band> wings = make_shared<Band>("Wings");

   wings->setMembers({paul});
   beatles.reset();
   cout << paul->toString() << endl;

   wings->setMembers({paul});
   cout << paul->toString() << endl;
   return EXIT_SUCCESS;

}
