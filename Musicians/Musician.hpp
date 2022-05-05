#ifndef EXERCICES_MUSICIAN_HPP
#define EXERCICES_MUSICIAN_HPP

#include <string>
#include <memory>


class Band;

/**
 * Description
 * @author Oim
 */
class Musician {
public:
   ~Musician();

   explicit Musician(const std::string& name);

   std::string toString() const;

   std::string getName() const;

   void setBand(const std::weak_ptr<Band>& band);

private:
   std::string name;
   std::weak_ptr<Band> band;
};


#endif //EXERCICES_MUSICIAN_HPP
