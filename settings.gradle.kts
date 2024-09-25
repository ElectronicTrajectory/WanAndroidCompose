pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    includeBuild('build-logic')
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WanAndroidCompose"
include(":app")
include(":core")
include(":feature")
include(":core:network")
include(":core:data")
include(":core:common")
