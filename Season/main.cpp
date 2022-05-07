/**
 * @author Marengo Stéphane
 */

#include <iostream>
#include "Season.hpp"

using namespace std;

int main() {
   const Season& season = Season::Spring;
   for (size_t i = 0; i < Season::size(); i++)
      cout << Season::get(i).name() << endl;
   for (const Season* s = *Season::values();
        s <= Season::values()[Season::size() - 1]; s++)
      cout << s->name() << " " << s->index() << " " << s->next().name() << endl;

   /**
    * Spring Spring 0 Summer
    * Summer Summer 1 Autumn
    * Autumn Autumn 2 Winter
    * Winter Winter 3 Spring
    */
   return 0;
}
