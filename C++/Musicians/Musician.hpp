#ifndef EXERCICES_MUSICIAN_HPP
#define EXERCICES_MUSICIAN_HPP

#include <string>
#include <memory>


class Band;

/**
 * @author Marengo Stéphane
 */
class Musician {
public:
   ~Musician();

   explicit Musician(const std::string& name);

   std::string toString() const;

   std::string getName() const;

   bool setBand(const std::weak_ptr<Band>& band);

   void removeBand();

private:
   std::string name;
   std::weak_ptr<Band> band;
};


#endif //EXERCICES_MUSICIAN_HPP
