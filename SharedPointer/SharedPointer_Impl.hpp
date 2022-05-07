/**
 * @author Marengo Stéphane
 */

#include "SharedPointer.hpp"
#include <stdexcept>

template<typename T>
SharedPointer<T>::Manager::Manager(T* ptr) : sharedPtrCounter(1), ptr(ptr) {}

template<typename T>
void SharedPointer<T>::Manager::addSharedPointer() {
   sharedPtrCounter++;
}

template<typename T>
void SharedPointer<T>::Manager::removeSharedPointer() {
   sharedPtrCounter--;

   if (!sharedPtrCounter) {
      delete ptr;
      delete this;
   }
}

template<typename T>
SharedPointer<T>::SharedPointer() : manager(nullptr) {
}

template<typename T>
SharedPointer<T>::SharedPointer(T* ptr) : manager(new Manager(ptr)) {
}

template<typename T>
SharedPointer<T>::~SharedPointer() {
   manager->removeSharedPointer();
}

template<typename T>
SharedPointer<T>::SharedPointer(const SharedPointer& sharedPtr) : manager(sharedPtr.manager) {
   if (manager != nullptr)
      manager->addSharedPointer();
}

template<typename T>
SharedPointer<T>& SharedPointer<T>::operator=(const SharedPointer& sharedPtr) {
   if (this == &sharedPtr)
      return *this;

   if (manager != nullptr)
      manager->removeSharedPointer();

   if (sharedPtr.manager != nullptr) {
      manager = sharedPtr.manager;
      manager->addSharedPointer();
   }

   return *this;
}

template<typename T>
T& SharedPointer<T>::operator*() const {
   return *get();
}

template<typename T>
T* SharedPointer<T>::operator->() const {
   return get();
}

template<typename T>
bool SharedPointer<T>::operator==(const SharedPointer& sharedPtr) const {
   return get() == sharedPtr.get();
}

template<typename T>
bool SharedPointer<T>::operator!=(const SharedPointer& sharedPtr) const {
   return get() != sharedPtr.get();
}

template<typename T>
T* SharedPointer<T>::get() const {
   if (manager == nullptr)
      throw std::runtime_error("Bruh");
   return manager->ptr;
}

template<typename T>
std::size_t SharedPointer<T>::useCount() const {
   return manager == nullptr ? 0 : manager->sharedPtrCounter;
}
