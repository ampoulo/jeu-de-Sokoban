#!/bin/sh

cd $(dirname $0)/..
#ssh scripts/install.sh
cd Sokoban
[ -d doc ] || mkdir doc
cd src
javadoc -d ../doc */*.java
