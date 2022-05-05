/**
 * Description
 * @author Oim
 */

#include "Musician.hpp"
#include <iostream>
#include <sstream>
#include "Band.hpp"

using namespace std;

Musician::Musician(const string& name) {
   this->name = name;
}

string Musician::toString() const {
   stringstream ss;
   auto b = band.lock();

   ss << name << ", band: " << (b ? b->getName() : "<none>");
   return ss.str();
}

std::string Musician::getName() const {
   return name;
}


Musician::~Musician() {
   cout << "~Musician(): " << name << endl;
}

void Musician::setBand(const weak_ptr<Band>& band) {
   if (this->band.expired()) {
      this->band = band;
   } else {
      auto b = this->band.lock();
      cout << name << " is already in " << b->getName() << endl;
   }
}