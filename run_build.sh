#!/usr/bin/env bash

# アプリケーションのビルド＆テスト実行＆起動
#pushd spring-sample > /dev/null
./build.sh $1
if [ $? -ne 0 ]; then
  exit -1
fi
popd > /dev/null

# jarを再配置
cp -r ./build/libs/ ./release

exit 0
