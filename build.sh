#!/usr/bin/env bash

# サーバのビルドとテスト
# TODO:テストも入れる
if [ "$1" = "" ]
then
#  ./gradlew build -x test -x checkstyleMain -x checkstyleTest -x spotbugsMain -x spotbugsTest -x javadocAllProjects
#  ./gradlew build
  ./gradlew build test
else
  ./gradlew checkstyleMain checkstyleTest spotbugsMain spotbugsTest
fi

if [ $? -ne 0 ]; then
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  echo "==================> APPLICATION BUILD 失敗 !!! <==============="
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  exit -1
fi

echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "==================> APPLICATION BUILD 成功 !!! <==============="
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

exit 0
