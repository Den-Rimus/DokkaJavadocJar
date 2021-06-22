
plugins {
   id("com.android.library")
   id("kotlin-android")
   id("org.jetbrains.dokka") version "1.4.32"
   id("maven-publish")
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

tasks {
   register("androidJavadocJar", Jar::class) {
      archiveClassifier.set("javadoc")
      val dokkaTask = named("dokkaJavadoc")
      from(dokkaTask)
      dependsOn(dokkaTask)
   }
}

afterEvaluate {
   configure<PublishingExtension> {
      publications {
         create<MavenPublication>("MyLibrary1") {
            groupId = "com.example"
            artifactId = "mylibrary1"
            version = "1.0.0"

            from(components["release"])
            artifact(tasks.named("androidJavadocJar"))
         }
      }
      repositories {
         maven {
            name = "ScanbotNexus"
            url = uri("https://fake.repository.com/repositories/snapshots")
         }
      }
   }
}
