/**
 * @author Marengo Stéphane
 */

#include "Season.hpp"

#include <cstring>
#include <stdexcept>

using namespace std;

const Season Season::Spring("Spring");
const Season Season::Summer("Summer");
const Season Season::Autumn("Autumn");
const Season Season::Winter("Winter");

size_t Season::counter = 0;

const Season* Season::seasons[]{
   &Spring,
   &Summer,
   &Autumn,
   &Winter
};

size_t Season::size() {
   return counter;
}

const Season& Season::get(size_t i) {
   if (i >= size())
      throw out_of_range("Hors borne");
   return *seasons[i];
}

const Season** Season::values() {
   return seasons;
}

const Season& Season::next() const {
   return *seasons[(ordinal + 1) % counter];
}

Season::Season(const char* str) : ordinal(counter++) {
   const size_t len = strlen(str);
   char* tmp = new char[len + 1];
   strcpy(tmp, str);
   _name = tmp;
}

Season::~Season() {
   delete[] _name;
}

size_t Season::index() const {
   return ordinal;
}

const char* Season::name() const {
   return _name;
}
