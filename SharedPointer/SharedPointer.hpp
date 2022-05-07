#ifndef SHARED_PTR_SHAREDPOINTER_HPP
#define SHARED_PTR_SHAREDPOINTER_HPP

#include <cstdlib>

/**
 * @author Marengo Stéphane
 */
template<typename T>
class SharedPointer {
public:
   SharedPointer();

   SharedPointer(T* ptr);

   SharedPointer(const SharedPointer& sharedPtr);

   ~SharedPointer();

   SharedPointer& operator=(const SharedPointer& sharedPtr);

   T& operator*() const;

   T* operator->() const;

   bool operator==(const SharedPointer& sharedPtr) const;

   bool operator!=(const SharedPointer& sharedPtr) const;

   T* get() const;

   std::size_t useCount() const;

private:
   class Manager {
   public:
      explicit Manager(T* ptr);

      void addSharedPointer();

      void removeSharedPointer();

      std::size_t sharedPtrCounter;
      T* ptr;
   };

   Manager* manager;
};

#include "SharedPointer_Impl.hpp"

#endif //SHARED_PTR_SHAREDPOINTER_HPP
