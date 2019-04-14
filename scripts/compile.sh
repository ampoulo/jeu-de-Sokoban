#!/bin/sh

cd $(dirname $0)/..
sh scripts/install.sh
#javac -d build -cp ".:lib/*" src/*.java
#javac -d build -cp ".:build:lib/*" /src/*.java
#javac -d build -cp ".:lib/*" *.java
#javac -d build -cp ".:lib/*" Sokoban/src/*/*.java
[ -d build ] || mkdir build
cd src
cp -r image ../build
cp -r niveaux ../build
javac -d ../build *.java Sokoban.java

