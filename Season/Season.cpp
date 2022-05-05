/**
 * Description
 * @author Oim
 */

#include "Season.hpp"

#include <cstring>
#include <stdexcept>


const Season Season::Spring("Spring");
const Season Season::Summer("Summer");
const Season Season::Autumn("Autumn");
const Season Season::Winter("Winter");

std::size_t Season::counter = 0;

const Season* Season::seasons[]{
   &Spring,
   &Summer,
   &Autumn,
   &Winter
};

std::size_t Season::size() {
   return counter;
}

const Season& Season::get(std::size_t i) {
   if (i >= size())
      throw std::runtime_error("");
   return *seasons[i];
}

const Season** Season::values() {
   return seasons;
}

const Season& Season::next() const {
   return *seasons[(ordinal + 1) % size()];
}

Season::Season(const char* str) {
   const size_t len = strlen(str);
   char* tmp = new char[len + 1];
   strcpy(tmp, str);
   text = tmp;
   ordinal = counter++;
}

Season::~Season() {
   delete[] text;
}

std::size_t Season::index() const {
   return ordinal;
}

const char* Season::name() const {
   return text;
}
