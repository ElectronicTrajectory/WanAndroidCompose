import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

//定义这个构建逻辑模块的组名，用于标识构建脚本或插件的所属组。在发布或管理多个插件时，组名可以帮助组织和区分插件。
group = "com.dawn.wanandroidcompose.buildlogic"

//配置 Java 编译选项，指定源代码和目标字节码的版本为 Java 17。这意味着所有的 Java 代码都会被编译为 Java 17 的字节码格式。
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
//配置 Kotlin 编译器，指定 Kotlin 代码编译为与 Java 17 兼容的字节码。JvmTarget.JVM_17 表示目标 JVM 版本为 17
kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}


//compileOnly
//这些依赖只在编译时可用，意思是在项目编译时，这些依赖会被使用，但它们不会包含在生成的最终应用程序或库中。
//这种配置通常用于添加编译时需要的工具或插件，例如在编译过程中需要的 Gradle 插件或工具库。

//implementation
//这些依赖不仅在编译时可用，而且会被打包到最终生成的应用程序或库中。
//这种配置适用于应用程序运行时需要的依赖。
dependencies {
    compileOnly(libs.android.gradlePlugin)//构建安卓插件
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)//compose插件
    compileOnly(libs.kotlin.gradlePlugin)//kotlin插件
    compileOnly(libs.ksp.gradlePlugin)//提供一种轻量级的 Kotlin 编译时注解处理机制。当 Kotlin 项目中使用需要编译时注解处理的库（如 Room、Dagger）时，会用到这个插件
    compileOnly(libs.hilt.gradlePlugin)//hilt插件

}
// 配置一个 validatePlugins 任务，用于验证插件配置的正确性。
//enableStricterValidation = true：开启更严格的验证模式。
//failOnWarning = true：遇到警告时使构建失败，确保所有插件配置无误。
tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}
//定义多个自定义 Gradle 插件。每个插件都通过 register 方法进行注册，指定了插件的唯一 ID 和对应的实现
gradlePlugin {
    plugins {
        val prefix = "wanandroid"
        register("androidComposeApplication") {
            id = "wanandroid.android.compose.application"
            implementationClass = "AndroidComposeApplicationConventionPlugin"
        }
        register("androidComposeLibrary") {
            id = "$prefix.android.compose.library"
            implementationClass = "AndroidComposeLibraryConventionPlugin"
        }
        register("androidLibrary") {
            id = "$prefix.android.library"
            implementationClass = "AndroidComposeLibraryConventionPlugin"
        }
    }
}