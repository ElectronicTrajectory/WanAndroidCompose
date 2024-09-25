import com.android.build.gradle.LibraryExtension
import com.example.wanandroidcompose.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

//为 Android 库项目自动应用和配置与 Jetpack Compose 相关的设置
class AndroidComposeLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            with(pluginManager) {
                apply("com.android.library")                    //Android 库插件
                apply("org.jetbrains.kotlin.android")           //Kotlin Android 插件
                apply("org.jetbrains.kotlin.plugin.compose")    //Kotlin Compose 插件
            }

            //获取项目的 LibraryExtension 扩展，它用于配置 Android 库特定的构建选项
            val extension = extensions.getByType<LibraryExtension>().apply {
                defaultConfig {
                    consumerProguardFile("consumer-rules.pro")
                }
            }
            //进行进一步的配置
            configureAndroidCompose(extension)
        }
    }
}