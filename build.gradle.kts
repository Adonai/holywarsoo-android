// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    extra["kotlinVersion"] = "1.3.61"

    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}
