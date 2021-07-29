const val kotlinVersion = "1.5.21"

object BuildPlugins {
    object Versions {
        const val buildToolsVersion = "4.1.3"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
}

object Libraries {
    private object Versions {
        const val jetpack = "1.0.0"
    }

    object JetPack {
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val cardview = "androidx.cardview:cardview:${Versions.jetpack}"
        const val recycleview = "androidx.recyclerview:recyclerview:${Versions.jetpack}"
        const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val material = "com.google.android.material:material:1.4.0"
    }

    const val colorpicker = "com.github.dhaval2404:colorpicker:2.0"
    const val kolabnotesJava = "com.github.konradrenner:kolabnotes-java:3.4.1"
    const val richtexteditorAndroid = "jp.wasabeef:richeditor-android:1.2.2"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    //const val kotlinxSerializationRuntime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${kotlinxSerializationVersion}"
}

object TestLibraries {
    private object Versions {
        const val test = "1.1.1"
    }

    object AndroidXTest {
        const val espresso = "androidx.test.espresso:espresso-core:3.1.0"
        const val junit = "androidx.test.ext:junit:${Versions.test}"
        const val runner = "androidx.test:runner:${Versions.test}"
        const val rules = "androidx.test:rules:${Versions.test}"
    }

    const val annotation = "androidx.annotation:annotation:1.0.0"
}
