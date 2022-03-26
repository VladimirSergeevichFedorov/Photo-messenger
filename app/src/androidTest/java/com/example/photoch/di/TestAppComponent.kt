import android.content.Context
import com.example.impl.di.modules.DataModule
import com.example.impl.di.modules.DataUseCaseModule
import com.example.photoch.RepositoryTest
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        TestAppModule::class,
        DataUseCaseModule::class
    ]
)
interface TestAppComponent {

    fun inject(repositoryTest: RepositoryTest)

    @Component.Builder
    interface Builder {

        fun applicationContext(@BindsInstance context: Context): Builder

        fun build(): TestAppComponent
    }
}
