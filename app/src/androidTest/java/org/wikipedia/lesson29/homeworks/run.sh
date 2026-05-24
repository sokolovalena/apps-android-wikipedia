#!/usr/bin/env bash

set -e

AVD_NAME="emulator-5584"
PORT=5584
SYSTEM_IMAGE="system-images;android-34;google_apis;arm64-v8a"
DEVICE="pixel"
TEST="org.wikipedia.lesson28.homework.SearchTestsWithRule"

SDK_ROOT="${ANDROID_SDK_ROOT:-${ANDROID_HOME:-$HOME/Library/Android/sdk}}"
AVDMANAGER="$SDK_ROOT/cmdline-tools/latest/bin/avdmanager"
EMULATOR="$SDK_ROOT/emulator/emulator"
ADB="$SDK_ROOT/platform-tools/adb"

echo "Создать эмулятор '$AVD_NAME'"
echo "no" | "$AVDMANAGER" create avd \
  --name "$AVD_NAME" \
  --package "$SYSTEM_IMAGE" \
  --device "$DEVICE"

echo "Запустить эмулятор"
"$EMULATOR" -avd "$AVD_NAME" \
  -no-snapshot \
  -wipe-data \
  -no-boot-anim \
  -port "$PORT" \
  -gpu host >/tmp/emulator-$PORT.log 2>&1 &
EMULATOR_PID=$!

echo "Ожидание 60 секунд"
sleep 60

export ANDROID_SERIAL="emulator-$PORT"

echo "Запустить тест $TEST"
./gradlew app:connectedAlphaDebugAndroidTest \
  -Pandroid.testInstrumentationRunnerArguments.class="$TEST_CLASS"

echo "Завершить работу эмулятора"
"$ADB" -s "emulator-$PORT" emu kill || true
wait "$EMULATOR_PID" 2>/dev/null || true

echo "Открыть allure отчет"
allure serve app/build/allure-results