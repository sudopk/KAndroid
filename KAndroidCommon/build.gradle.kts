plugins {
  id("com.android.library")
  id("kotlin-android")
  id("maven-publish")
}

android {
  compileSdk = 30

  defaultConfig {
    minSdk = 14
    targetSdk = 30
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }
}

dependencies {
  implementation("com.google.android.material:material:1.3.0")

  testImplementation("junit:junit:4.13.2")
}

// https://developer.android.com/studio/build/maven-publish-plugin
// Because the components are created only during the afterEvaluate phase, you must
// configure your publications using the afterEvaluate() lifecycle method.
afterEvaluate {
  publishing {
    publications {
      // Creates a Maven publication called "release".
      create<MavenPublication>("release") {
        // Applies the component for the release build variant.
        from(components["release"])

        // You can then customize attributes of the publication as shown below.
        groupId = "com.github.sudopk"
        artifactId = "KAndroid"
        version = "1.1.2"
      }
    }
  }
}
