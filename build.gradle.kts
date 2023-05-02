plugins {
    kotlin("multiplatform") version "1.8.0"
}

group = "dev.rebok"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
}

kotlin {
    jvm {
        jvmToolchain(17)
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        binaries.executable()
        nodejs {

        }
    }
    linuxX64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()
    mingwX64()
    mingwX86()
    macosX64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.soywiz.korlibs.korio:korio:4.0.0-alpha-6")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val linuxX64Main by getting
        val linuxX64Test by getting
        val linuxArm32HfpMain by getting
        val linuxArm32HfpTest by getting
        val linuxMips32Main by getting
        val linuxMips32Test by getting
        val linuxMipsel32Main by getting
        val linuxMipsel32Test by getting
        val mingwX64Main by getting
        val mingwX64Test by getting
        val mingwX86Main by getting
        val mingwX86Test by getting
        val macosX64Main by getting
        val macosX64Test by getting
    }
}
