#ifndef SEASON_SEASON_HPP
#define SEASON_SEASON_HPP

#include <string>

class Season {
private:
   static const Season* seasons[];
   static std::size_t counter;

   const char* text;
   std::size_t ordinal;

   Season(const char* str);

   ~Season();

public:
   static const Season Spring, Summer, Autumn, Winter;

   static std::size_t size();

   static const Season& get(std::size_t i);

   static const Season** values();

   const Season& next() const;

   std::size_t index() const;

   const char* name() const;
};


#endif //SEASON_SEASON_HPP
