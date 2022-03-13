package dependenciesForModules

object Compose {

    internal const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    internal const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    internal const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    internal const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    internal const val material = "androidx.compose.material:material:${Versions.compose}"
    internal const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    internal const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    internal const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    internal const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    internal const val preview = "androidx.compose.ui:ui-preview:${Versions.compose}"
    internal const val test = "androidx.compose.test:test-core:${Versions.compose}"
    internal const val uiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    // Navigation
    internal const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"

    object Accompanist {
        // Pager Compose
        private val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanistPager}"
        private val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanistPager}"
        // Insets
        private val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanistInsets}"
        private val insetsUi = "com.google.accompanist:accompanist-insets-ui:${Versions.accompanistInsets}"

        val pagerList = listOf(pager, pagerIndicators)
        val insetsList = listOf(insets, insetsUi)
    }

    internal val composeList = listOf(
        activityCompose,
        composeNavigation,
        ui,
        foundation,
        layout,
        material,
        materialIconsExtended,
        runtime,
        runtimeLivedata,
        tooling
    )

    internal val composeTestList = listOf(test, uiTest)
}
