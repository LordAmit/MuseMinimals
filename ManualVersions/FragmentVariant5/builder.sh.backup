#!/bin/bash

set -e

ANDROID_HOME=/Users/amitseal/Android/Sdk
AAPT="$ANDROID_HOME/build-tools/29.0.2/aapt"
DX="$ANDROID_HOME/build-tools/29.0.2/dx"
ZIPALIGN="$ANDROID_HOME/build-tools/29.0.2/zipalign"
APKSIGNER="$ANDROID_HOME/build-tools/29.0.2/apksigner" # /!\ version 26
PLATFORM="$ANDROID_HOME/platforms/android-19/android.jar"

echo "Cleaning..."
rm -rf obj/*
rm -rf src/com/example/helloandroid/R.java

echo "Generating R.java file..."
$AAPT package -f -m -J src -M AndroidManifest.xml -S res -I $PLATFORM

echo "Compiling..."
javac -d obj -classpath src -bootclasspath $PLATFORM -source 1.7 -target 1.7 src/com/example/helloandroid/MainActivity.java
javac -d obj -classpath src -bootclasspath $PLATFORM -source 1.7 -target 1.7 src/com/example/helloandroid/R.java

echo "Translating in Dalvik bytecode..."
$DX --dex --output=classes.dex obj

echo "Making APK..."
$AAPT package -f -m -F bin/hello.unaligned.apk -M AndroidManifest.xml -S res -I $PLATFORM
$AAPT add bin/hello.unaligned.apk classes.dex

echo "Aligning and signing APK..."
$APKSIGNER sign --ks mykey.keystore bin/hello.unaligned.apk
$ZIPALIGN -f 4 bin/hello.unaligned.apk bin/hello.apk

if [ "$1" == "test" ]; then
    echo "Launching..."
    adb install -r bin/hello.apk
    adb shell am start -n com.example.helloandroid/.MainActivity
fi
