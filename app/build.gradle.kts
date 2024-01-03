plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.gemini_ai"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.gemini_ai"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("libs/jtds-1.3.1.jar"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //rive
    implementation("app.rive:rive-android:8.7.0")
    // During initialization, you may need to add a dependency
    // for Jetpack Startup
    implementation("androidx.startup:startup-runtime:1.1.1")

//    implementation ("mysql:mysql-connector-java:8.0.30")

}