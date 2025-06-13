plugins {
    id("com.android.application") version "8.4.0" apply false // ou sua versão correta
    id("com.google.gms.google-services") version "4.4.2" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}
