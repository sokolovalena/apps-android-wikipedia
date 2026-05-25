#!/bin/bash

docker run --rm -d --name cc \
-v ".:/project" \
-w /project \
android-jdk21 sleep infinity

docker exec cc sh -c \
"sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew app:clean"