#ifndef EXERCICES_BAND_HPP
#define EXERCICES_BAND_HPP

#include <string>
#include <list>
#include <memory>

class Musician;

/**
 * @author Marengo Stéphane
 */
class Band : public std::enable_shared_from_this<Band> {
public:
   explicit Band(std::string name);

   ~Band();

   void setMembers(std::initializer_list<std::shared_ptr<Musician>> members);

   std::string toString() const;

   std::string getName() const;

private:
   std::string name;
   std::list<std::shared_ptr<Musician>> members;
};


#endif //EXERCICES_BAND_HPP
