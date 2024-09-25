plugins {
    alias(libs.plugins.wanandroid.android.library)
}

android {
    namespace = "com.dawn.wanandroidcompose.core.data"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}