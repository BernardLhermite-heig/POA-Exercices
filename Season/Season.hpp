#ifndef SEASON_SEASON_HPP
#define SEASON_SEASON_HPP

#include <cstdlib>

/**
 * @author Marengo Stéphane
 */
class Season {
public:
   Season(const Season& other) = delete;

   Season& operator=(const Season& other) = delete;

   static const Season Spring, Summer, Autumn, Winter;

   static std::size_t size();

   static const Season& get(std::size_t i);

   static const Season** values();

   const Season& next() const;

   std::size_t index() const;

   const char* name() const;

private:
   static const Season* seasons[];
   static std::size_t counter;
   const char* _name;
   std::size_t ordinal;

   explicit Season(const char* str);

   ~Season();
};


#endif //SEASON_SEASON_HPP
