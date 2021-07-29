plugins {
    id("com.android.application")
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
}

