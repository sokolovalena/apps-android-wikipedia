#!/bin/bash

set -e

echo "Скомпилировать apk"

./gradlew clean assembleAlphaDebug assembleAlphaDebugAndroidTest

echo "Создание эмулятора"

avdmanager create avd \
 --name emulator-5554 \
 --package "system-images;android-33;google_apis;arm64-v8a" \
 --device "pixel"

 avdmanager create avd \
  --name emulator-5556 \
  --package "system-images;android-34;google_apis;arm64-v8a" \
  --device "pixel"

echo "Запуск"
emulator -avd emulator-5554 \
 -no-snapshot \
 -wipe-data \
 -port 5554 \
 -skin 720x1280 \
 -gpu host &

emulator -avd emulator-5556 \
 -no-snapshot \
 -wipe-data \
 -port 5556 \
 -skin 720x1280 \
 -gpu host &

sleep 120

echo "Запуск marathon"
marathon --marathonfile Marathonfile

echo "Завершение"
adb -s emulator-5554 emu kill
adb -s emulator-5556 emu kill