template<typename T>
Array<T>::Array(std::size_t size) {
   init(size);
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

   init(other.size);
   for (std::size_t i = 0; i < length; i++) {
      data[i] = other.data[i];
   }

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
int Array<T>::size() const {
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
void Array<T>::init(std::size_t size) {
   this->length = size;
   this->data = new T[size];
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
Array<T>::Iterator::Iterator(T* data) : data(data) {
}

template<typename T>
T& Array<T>::Iterator::operator*() {
   return *data;
}

template<typename T>
typename Array<T>::Iterator& Array<T>::Iterator::operator++() {
   ++data;
   return *this;
}

template<typename T>
typename Array<T>::Iterator Array<T>::Iterator::operator++(int) {
   Iterator tmp(*this);
   operator++();
   return tmp;
}

template<typename T>
bool Array<T>::Iterator::operator!=(const Array::Iterator& other) {
   return data != other.data;
}

template<typename T>
bool Array<T>::Iterator::operator==(const Array::Iterator& other) {
   return data == other.data;
}