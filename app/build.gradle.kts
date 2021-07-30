plugins {
    id("com.android.application")
    id("de.mannodermaus.android-junit5")
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = "org.kore.kolabnotes.android"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 106
        versionName = "4.2.1"

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    packagingOptions {
        exclude("META-INF/LICENSE.txt")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }

}

dependencies {
    implementation(Libraries.JetPack.appcompat)
    implementation(Libraries.JetPack.cardview)
    implementation(Libraries.JetPack.material)
    implementation(Libraries.JetPack.recycleview)
    implementation(Libraries.JetPack.swiperefreshlayout)

    implementation(Libraries.colorpicker)
    implementation(Libraries.kolabnotesJava)
    implementation(Libraries.richtexteditorAndroid)

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.kotlinReflect)

    testImplementation(TestLibraries.AndroidXTest.espresso)
    testImplementation(TestLibraries.AndroidXTest.junit)
    testImplementation(TestLibraries.AndroidXTest.runner)
    testImplementation(TestLibraries.AndroidXTest.rules)
    testImplementation(TestLibraries.annotation)

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.1")

    // (Optional) If you also have JUnit 4-based tests
    testImplementation("junit:junit:4.13")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.7.1")


    androidTestImplementation(TestLibraries.AndroidXTest.espresso)
    androidTestImplementation(TestLibraries.AndroidXTest.junit)
    androidTestImplementation(TestLibraries.AndroidXTest.runner)
    androidTestImplementation(TestLibraries.AndroidXTest.rules)
    androidTestImplementation(TestLibraries.annotation)

    androidTestRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-params:5.7.1")

    // (Optional) If you also have JUnit 4-based tests
    androidTestImplementation("junit:junit:4.13")
    androidTestRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.7.1")
}

