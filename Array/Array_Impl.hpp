
#include "Array.hpp"

template<typename T>
Array<T>::Array() {
   init(0);
}

template<typename T>
Array<T>::Array(std::size_t size) {
   init(size);
}

template<typename T>
Array<T>::Array(std::initializer_list<T> args) {
   init(args.size());

   std::size_t i = 0;
   const auto END = args.end();
   for (auto it = args.begin(); it != END; ++it, ++i) {
      data[i] = *it;
   }
}

template<typename T>
Array<T>::Array(const Array& other) {
   init(other.length, other.data);
}

template<typename T>
Array<T>::~Array() {
   destroy();
}

template<typename T>
Array<T>& Array<T>::operator=(const Array& other) {
   if (this == &other) return *this;

   if (other.data != nullptr)
      destroy();

   init(other.length, other.data);

   return *this;
}

template<typename T>
T& Array<T>::operator[](std::size_t i) {
   return at(i);
}

template<typename T>
const T& Array<T>::operator[](std::size_t i) const {
   return at(i);
}

template<typename T>
std::size_t Array<T>::size() const {
   return length;
}

template<typename T>
typename Array<T>::Iterator Array<T>::begin() {
   return Iterator(data);
}

template<typename T>
typename Array<T>::Iterator Array<T>::end() {
   return Iterator(data + length);
}

template<typename T>
void Array<T>::init(std::size_t size, T* src) {
   this->length = size;
   this->data = size > 0 ? new T[size] : nullptr;

   if (src != nullptr) {
      for (std::size_t i = 0; i < size; i++) {
         data[i] = src[i];
      }
   }
}

template<typename T>
void Array<T>::destroy() {
   delete[] this->data;
}

template<typename T>
T& Array<T>::at(std::size_t i) {
   if (i >= length) {
      throw std::out_of_range("Index out of range");
   }
   return data[i];
}

template<typename T>
Array<T>::Iterator::Iterator(T* data) : ptr(data) {
}

template<typename T>
T& Array<T>::Iterator::operator*() {
   return *ptr;
}

template<typename T>
typename Array<T>::Iterator& Array<T>::Iterator::operator++() {
   ++ptr;
   return *this;
}

template<typename T>
typename Array<T>::Iterator Array<T>::Iterator::operator++(int) {
   Iterator tmp(*this);
   ++(*this);
   return tmp;
}

template<typename T>
bool Array<T>::Iterator::operator!=(const Array::Iterator& other) {
   return ptr != other.ptr;
}

template<typename T>
bool Array<T>::Iterator::operator==(const Array::Iterator& other) {
   return ptr == other.ptr;
}