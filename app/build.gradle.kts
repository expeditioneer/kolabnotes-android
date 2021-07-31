plugins {
    id("com.android.application")
    id(BuildPlugins.kotlinAndroid)
    id("de.mannodermaus.android-junit5")
    kotlin("kapt")
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

    implementation(Libraries.Room.runtime)
    kapt(Libraries.Room.compiler)

    testImplementation(TestLibraries.AndroidXTest.espresso)
    testImplementation(TestLibraries.AndroidXTest.junit)
    testImplementation(TestLibraries.AndroidXTest.runner)
    testImplementation(TestLibraries.AndroidXTest.rules)
    testImplementation(TestLibraries.annotation)

    testRuntimeOnly(TestLibraries.Junit5.jupiterEngine)
    testImplementation(TestLibraries.Junit5.jupiterApi)
    testImplementation(TestLibraries.Junit5.jupiterParams)

    testImplementation(TestLibraries.Room.testing)

    androidTestImplementation(TestLibraries.AndroidXTest.espresso)
    androidTestImplementation(TestLibraries.AndroidXTest.junit)
    androidTestImplementation(TestLibraries.AndroidXTest.runner)
    androidTestImplementation(TestLibraries.AndroidXTest.rules)
    androidTestImplementation(TestLibraries.annotation)
}

