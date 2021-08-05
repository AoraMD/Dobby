plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 16
        targetSdk = 31
    }

    externalNativeBuild {
        cmake {
            path("CMakeLists.txt")
        }
    }

    buildFeatures {
        prefabPublishing = true
    }

    prefab {
        create("dobby") {
            headers = "../../include"
        }
    }
}

afterEvaluate {
    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/aoramd/dobby")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "moe.aoramd.prefab"
                artifactId = "dobby"
                version = "1.0.0"
            }
        }
    }
}