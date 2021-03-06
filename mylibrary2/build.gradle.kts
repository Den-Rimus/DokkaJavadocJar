
plugins {
   id("com.android.library")
   id("kotlin-android")
}

android {
   compileSdkVersion(30)

   defaultConfig {
      minSdkVersion(21)
      targetSdkVersion(30)
      versionCode = 1
      versionName = "1.0"
   }

   buildTypes {
      named("release") {
         isMinifyEnabled = false
         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlinOptions {
      jvmTarget = "1.8"
   }
}

dependencies {
   implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
   implementation("androidx.core:core-ktx:1.5.0")
   implementation("androidx.appcompat:appcompat:1.3.0")
   implementation("com.google.android.material:material:1.3.0")
}