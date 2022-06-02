cmake_minimum_required(VERSION 3.21)
project(Musicians)

set(CMAKE_CXX_STANDARD 11)

add_executable(Musicians main.cpp Musician.cpp Musician.hpp Band.cpp Band.hpp)
