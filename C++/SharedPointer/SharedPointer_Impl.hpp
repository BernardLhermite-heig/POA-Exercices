/**
 * @author Marengo Stéphane
 */

#include "SharedPointer.hpp"
#include <stdexcept>

template<typename T>
SharedPointer<T>::Manager::Manager(T* ptr) : sharedPtrCounter(1), ptr(ptr) {}

template<typename T>
SharedPointer<T>::Manager::~Manager() {
   delete ptr;
}

template<typename T>
void SharedPointer<T>::addSharedPointer() {
   if (manager == nullptr) return;
   ++manager->sharedPtrCounter;
}

template<typename T>
void SharedPointer<T>::destroy() {
   if (manager == nullptr) return;

   --manager->sharedPtrCounter;

   if (!manager->sharedPtrCounter) {
      delete manager;
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
   destroy();
}

template<typename T>
SharedPointer<T>::SharedPointer(const SharedPointer& sharedPtr) : manager(sharedPtr.manager) {
   if (manager != nullptr)
      addSharedPointer();
}

template<typename T>
SharedPointer<T>& SharedPointer<T>::operator=(const SharedPointer& sharedPtr) {
   if (this == &sharedPtr)
      return *this;

   destroy();

   manager = sharedPtr.manager;
   addSharedPointer();

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
      throw std::runtime_error("No value stored");
   return manager->ptr;
}

template<typename T>
std::size_t SharedPointer<T>::useCount() const {
   return manager == nullptr ? 0 : manager->sharedPtrCounter;
}
