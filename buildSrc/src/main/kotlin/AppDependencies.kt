import dependenciesForModules.*

object AppDependencies {

    val appLibraries = arrayListOf<String>().apply {
        add(Dagger.dagger)
        add(Compose.activityCompose)
        add(Compose.ui)
        add(Compose.material)
        add(Compose.tooling)
        add(Compose.composeNavigation)
        addAll(UI.uiList)
        addAll(Coroutines.coroutinesList)
        addAll(Retrofit.retrofitList)
    }
    val commonLibraries = arrayListOf<String>().apply {
        add(Dagger.dagger)

//        addAll(Retrofit.retrofitList)
//        add(Other.protobuf)
//        add(Other.datastore)
        add(Compose.composeNavigation)
        add(Compose.ui)
        add(Compose.material)
        add(Compose.tooling)
        addAll(UI.uiList)
        addAll(Coroutines.coroutinesList)
        add(Other.kotlinStdlib)
//        addAll(Compose.Accompanist.insetsList)
    }
    val dataLibraries = arrayListOf<String>().apply {
        add(Dagger.dagger)
        addAll(Retrofit.retrofitList)
//        add(Other.protobuf)
//        add(Other.datastore)
        add(Compose.composeNavigation)
        add(Compose.ui)
        add(Compose.material)
        add(Compose.tooling)
//        addAll(UI.uiList)
        addAll(Coroutines.coroutinesList)
        add(Other.kotlinStdlib)
//        addAll(Compose.Accompanist.insetsList)
    }
    val domainLibraries = arrayListOf<String>().apply {
        addAll(Coroutines.coroutinesList)
//        add(Other.kotlinStdlib)
//        addAll(UI.uiList)
//        add(Compose.ui)
//        addAll(Compose.Accompanist.insetsList)
    }
    val featureLibraries = arrayListOf<String>().apply {
        add(Dagger.dagger)
//        add(Compose.activityCompose)
//        add(Compose.ui)
//        add(Compose.material)
//        add(Compose.tooling)
        addAll(Compose.composeList)
        addAll(UI.uiList)
        addAll(Coroutines.coroutinesList)
        addAll(Retrofit.retrofitList)
    }
    val featuresApi = arrayListOf<String>().apply {
        addAll(Compose.composeList)
        add(Retrofit.retrofit)
    }
    val featureMapLibraries = arrayListOf<String>().apply {
        add(Dagger.dagger)

        addAll(UI.uiList)
        addAll(Other.othersList)
        addAll(Coroutines.coroutinesList)
        addAll(Retrofit.retrofitList)
    }
    val featureProfileLibraries = arrayListOf<String>().apply {
        add(Dagger.dagger)
        add(Images.picasso) // ?????????????? ?????????? ?????????? ?????????? compose, ???????????????????????? coil
        add(Images.coilCompose)
        addAll(UI.uiList)
        addAll(Other.othersList)
        addAll(Coroutines.coroutinesList)
        addAll(Retrofit.retrofitList)
        addAll(Compose.composeList)
        addAll(Compose.Accompanist.pagerList)
    }
    val featureHistoryLibraries = arrayListOf<String>().apply {
        add(Dagger.dagger)
        add(Images.picasso) // ?????????????? ?????????? ?????????? ?????????? compose, ???????????????????????? coil
        addAll(UI.uiList)
        addAll(Other.othersList)
        addAll(Coroutines.coroutinesList)
        addAll(Retrofit.retrofitList)
        addAll(Compose.composeList)
    }

    val diLibrariesKapt = arrayListOf<String>().apply {
        add(Dagger.daggerCompiler)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(Test.extJUnit)
        add(Test.espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(Test.junit)
    }

    val testKapt = arrayListOf<String>().apply {
        add(Dagger.daggerCompiler)
    }

    val testAndroidKapt = arrayListOf<String>().apply {
        add(Dagger.daggerCompiler)
    }
}
