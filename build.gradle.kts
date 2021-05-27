
buildscript {
   rootProject.extra["kotlin_version"] = "1.4.20"
   repositories {
      google()
      mavenCentral()
   }
   dependencies {
      classpath("com.android.tools.build:gradle:4.2.1")
      classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")
   }
}

allprojects {
   repositories {
      google()
      mavenCentral()
   }
}

tasks.create("clean", Delete::class.java) {
   setDelete(rootProject.buildDir)
}