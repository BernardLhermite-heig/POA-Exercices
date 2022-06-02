/**
 * @author Marengo Stéphane
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

bool Musician::setBand(const weak_ptr<Band>& band) {
   auto b = this->band.lock();

   if (!b) {
      this->band = band;
      return true;
   }

   cout << name << " is already in " << b->getName() << endl;
   return false;
}

void Musician::removeBand() {
   this->band.reset();
}
