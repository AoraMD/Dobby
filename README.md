## Dobby Prefab

> This repository is for building Android Prefeb packages of [Dobby](https://github.com/jmpews/Dobby).

Dobby a lightweight, multi-platform, multi-architecture exploit hook framework.

- Minimal and modular library
- Multi-platform support(Windows/macOS/iOS/Android/Linux)
- Multiple architecture support(X86, X86-64, ARM, ARM64)
- Clean code without STL(port to kernel easily)
- Plugin support(SymbolResolver, SupervisorCallMonitor)
- iOS kernel exploit support(Gollum ?)

## Getting started

Enable prefab in project (requires AGP 4.0+).

> See [Android Developers - Using native dependencies](https://developer.android.com/studio/build/native-dependencies) for more details.

Add dependencies.

``` groovy
// Groovy DSL
repositories {
    ...
    maven {
        url 'https://maven.pkg.github.com/aoramd/*'
        credentials {
            username '<github_username>'
            password '<github_token>'
        }
    }
}

dependencies {
    ...
    implementation 'moe.aoramd.prefab:dobby:<latest-version>'
}
```

``` kotlin
// Kotlin DSL
repositories {
    ...
    maven {
        url = "https://maven.pkg.github.com/aoramd/*"
        credentials {
            username = "<github_username>"
            password = "<github_token>"
        }
    }
}

dependencies {
    ...
    implementation("moe.aoramd.prefab:dobby:<latest-version>")
}
```

Find library in CMake.

> See [Android Developers - Using native dependencies](https://developer.android.com/studio/build/native-dependencies) for ndk-build makefile or more details.

```cmake
...

# Add these two lines
find_package(dobby REQUIRED CONFIG)
target_link_libraries(<your-library> dobby::dobby)
```