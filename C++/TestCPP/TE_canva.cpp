#include <iostream>
#include <string>
#include <memory>

using namespace std;

class Station {
   const string _name;

   Station(const Station& o) = delete;

   void operator=(const Station& o) = delete;

public:
   Station(string name) : _name(name) {}

   virtual string toString() const {
      return _name;
   }

   virtual ~Station() {}
};

class Jedi {
   string _name;
public:

   Jedi(string name) : _name(name) {}

   ~Jedi() {
      cout << _name << " vanishes in the Force..." << endl;
   }
};


int main() {
   // Exercice 1

   const MainStation
      s42("Grand Central", "Train/Subway connections"),
      s23("14 Street", "Subway connections"),
      sTS("Times Square", "Subway connections");

   const Station
      s33("33 Street"),
      s28("28 Street"),
      s05("5th Avenue");

   Line
      line6(6, {&s42, &s33, &s28, &s23}),
      line7(7, {&s42, &s05, &sTS});

   cout << line6.route(false) << endl;
   cout << line6.route(true) << endl;
   cout << line7.route(false) << endl;

   // Exercice 2

   // définition de Luke
   // définition de Rey

   cout << luke->toString() << endl;
   cout << rey->toString() << endl;

   // Mort de Luke
   cout << rey->toString() << endl;
}
