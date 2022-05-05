#ifndef ARRAY_ARRAY_HPP
#define ARRAY_ARRAY_HPP


#include <cstdlib>
#include <stdexcept>

/**
 * @author Marengo Stéphane
 */
template<typename T>
class Array {
private:
   class Iterator;

public:

   explicit Array(std::size_t size);

   ~Array();

   Array& operator=(const Array& other);

   T& operator[](std::size_t i);

   const T& operator[](std::size_t i) const;

   int size() const;

   Iterator begin();

   Iterator end();

private:
   T* data;
   std::size_t length;

   void init(std::size_t size);

   void destroy();

   T& at(std::size_t i);

   class Iterator {
   private:
      T* data;
   public:
      explicit Iterator(T* data);

      T& operator*();

      Iterator& operator++();

      Iterator operator++(int);

      bool operator!=(const Iterator& other);

      bool operator==(const Iterator& other);
   };
};

#include "Array_Impl.hpp"


#endif //ARRAY_ARRAY_HPP
