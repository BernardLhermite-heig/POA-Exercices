#ifndef ARRAY_ARRAY_HPP
#define ARRAY_ARRAY_HPP


#include <cstdlib>
#include <stdexcept>

/**
 * @author Marengo Stéphane
 */
template<typename T>
class Array {
public:
   class Iterator {
   public:
      T& operator*() const;

      Iterator& operator++();

      Iterator operator++(int);

      bool operator!=(const Iterator& other);

      bool operator==(const Iterator& other);

      T* operator->() const;

   private:
      T* ptr;

      explicit Iterator(T* data);
   };

   Array();

   explicit Array(std::size_t size);

   Array(std::initializer_list<T> args);

   Array(const Array& other);

   ~Array();

   Array& operator=(const Array& other);

   T& operator[](std::size_t i);

   const T& operator[](std::size_t i) const;

   std::size_t size() const;

   Iterator begin();

   Iterator end();

private:
   T* data;
   std::size_t length;

   void init(std::size_t size, T* src = nullptr);

   void destroy();

   T& at(std::size_t i) const;
};

#include "Array_Impl.hpp"


#endif //ARRAY_ARRAY_HPP
