// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.google.gms:google-services:4.3.15")
    }
}


plugins {
    id("com.android.application") version "8.2.0-alpha01" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.android.library") version "8.2.0-alpha01" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
}