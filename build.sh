cd src
find -name "*.java" > sources.txt
mkdir CMDBUILDDIR
javac -d CMDBUILDDIR -encoding utf8 -classpath .;\
../libraries/bin/jl1.0.1.jar;\
../libraries/bin/jogg-0.0.7.jar;\
../libraries/bin/jorbis-0.0.15.jar;\
../libraries/bin/NativeBass.jar;\
../libraries/bin/NativeBass-Examples.jar;\
../libraries/bin/rsyntaxtextarea-2.5.8.jar;\
../libraries/bin/trove-3.1a1.jar;\
../libraries/bin/dragshotMod.jar;\
../libraries/bin/easyogg.jar;\
../libraries/bin/gson-2.6.2.jar @sources.txt
cd ..