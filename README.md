# Kömpose2D
A minimal game library based on Compose, written in Kotlin and inspired by Love2D

[![](https://jitpack.io/v/FireZenk/kompose2d.svg)](https://jitpack.io/#FireZenk/kompose2d)

## Usage
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```kotlin
dependencies {
    implementation 'com.github.FireZenk:kompose2d:main-SNAPSHOT'
}
```

## How to

### Create the Game window
```kotlin
class MainActivity : Game<MainViewModel>() {

    override fun vm(): MainViewModel = MainViewModel()

    override fun DrawScope.draw(vm: MainViewModel) {
        // Draw your game here
    }
}
```

### Create the ViewModel
```kotlin
class MainViewModel : GameVM() {

    internal var state by mutableStateOf(State())
        private set
    
    // Override and implement all methods from GameVM
}
```

## Doubts?
Look at the sample app or ask me on Twitter [@firezenk](https://twitter.com/firezenk)

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/I2I13KE80)
