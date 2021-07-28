
object BuildPlugins {
    object Versions {
        const val buildToolsVersion = "4.1.3"
        const val kotlinVersion = "1.5.21"

    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}

object Libraries {
    private object Versions {
        const val jetpack = "1.0.0"
    }

    object JetPack {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
        const val cardview = "androidx.cardview:cardview:${Versions.jetpack}"
        const val legacySupportv4 = "androidx.legacy:legacy-support-v4:${Versions.jetpack}"
        const val recycleview = "androidx.recyclerview:recyclerview:${Versions.jetpack}"
        const val material = "com.google.android.material:material:${Versions.jetpack}"
    }

    const val kolabnotesJava = "com.github.konradrenner:kolabnotes-java:3.4.1"
    const val richtexteditorAndroid = "jp.wasabeef:richeditor-android:1.2.2"
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
