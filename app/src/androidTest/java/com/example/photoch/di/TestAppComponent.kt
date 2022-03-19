import android.content.Context
import com.example.impl.di.DataModule
import com.example.photoch.RepositoryTest
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(

    modules = [DataModule::class, TestAppModule::class]
)
interface TestAppComponent {

    fun inject(repositoryTest: RepositoryTest)

    @Component.Builder
    interface Builder {

        fun applicationContext(@BindsInstance context: Context): Builder

        fun build(): TestAppComponent
    }
}
