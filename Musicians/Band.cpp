/**
 * @author Marengo Stéphane
 */

#include "Band.hpp"

#include <iostream>
#include <utility>
#include <sstream>

#include "Musician.hpp"

using namespace std;

Band::Band(string name) : name(move(name)), members() {
}

void Band::setMembers(initializer_list<shared_ptr<Musician>> members) {
   for (auto it = this->members.begin(); it != this->members.end(); ++it) {
      (*it)->removeBand();
      it = this->members.erase(it);
      --it;
   }

   for (const auto& m: members) {
      if (m->setBand(weak_from_this()))
         this->members.push_back(m);
   }
}

std::string Band::toString() const {
   stringstream ss;
   ss << name << ": ";
   for (const auto& m: members) {
      ss << m->getName() << " ";
   }
   return ss.str();
}

Band::~Band() {
   cout << "~Band(): " << name << endl;
}

std::string Band::getName() const {
   return name;
}
