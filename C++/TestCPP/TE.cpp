#include <iostream>
#include <string>
#include <memory>
#include <sstream>

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

class MainStation : public Station {
public:
   MainStation(const string& name, const string& description)
      : Station(name), _description(description) {}

   string toString() const override {
      return Station::toString() + " - " + _description;
   }

private:
   const string _description;
};

class Line {
public:
   Line(int number, initializer_list<const Station*> stations)
      : _number(number), _size(stations.size()), _stations(new const Station* [_size]) {
      int i = 0;

//		auto end = stations.end();
//		for (auto iter = stations.begin(); iter != end; ++iter, ++i) {
//			_stations[i] = *iter;
//		}

      for (auto& station: stations) {
         _stations[i] = station;
         ++i;
      }
   }

   string route(bool express) const {
      stringstream ss;
      ss << getName() << " (" << (express ? "express" : "local") << ")" << endl;
      for (int i = 0; i < _size; ++i) {
         if (!express || dynamic_cast<const MainStation*>(_stations[i]) != nullptr) {
            ss << "* " << _stations[i]->toString() << endl;
         }
      }
      return ss.str();
   }

   ~Line() {
      delete[] _stations;
   }

private:
   int _number;
   int _size;
   const Station** _stations;

   string getName() const {
      return "Line " + to_string(_number);
   }
};

class Jedi {
public:
   explicit Jedi(string name, const shared_ptr<Jedi>& master = nullptr) : _name(std::move(name)),
                                                                          _master(master) {}

   ~Jedi() {
      cout << _name << " vanishes in the Force..." << endl;
   }

   string toString() const {
      auto ptr = _master.lock();
      return _name + ", master: " + (ptr ? ptr->_name : "none");
   }

private:
   string _name;
   weak_ptr<Jedi> _master;
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
   shared_ptr<Jedi> luke = make_shared<Jedi>("Luke");
   // définition de Rey
   shared_ptr<Jedi> rey = make_shared<Jedi>("Rey", luke);

   cout << luke->toString() << endl;
   cout << rey->toString() << endl;

   // Mort de Luke
   luke.reset();
   cout << rey->toString() << endl;
}
