package com.example.photoch

import androidx.test.platform.app.InstrumentationRegistry
import com.example.common.utils.getSHA512
import com.example.domain.usecase.AuthoriseRepo
import com.example.domain.usecase.RegisterRepo
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class RepositoryTest {

    @Inject
    lateinit var authoriseRepo: AuthoriseRepo

    @Inject
    lateinit var registerRepo: RegisterRepo

//    @Inject
//    lateinit var protoUserRepo: ProtoUserRepo

    @Before
    fun setup() {
        val app =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as PhotochApplication

        val testAppComponent =
            DaggerTestAppComponent.builder()
                .applicationContext(app)
                .build()
        testAppComponent.inject(this)
    }

    @Test
    fun checkRegister() = runBlocking {
        assertNotNull(registerRepo.saveLogin("Volvo"))
        assertNotNull(registerRepo.savePinCode("123456", "123456"))
    }

    @Test
    fun checkAuthorise() = runBlocking {
        assertNotNull(authoriseRepo.checkLogin("Volvo", "Volvo"))
        assertNotNull(authoriseRepo.checkPinCode("12345", "12345".getSHA512()))
    }

//    @Test
//    fun checkDataStore() = runBlocking {
//        assertNotNull(protoUserRepo.saveUserNameState("Mihail"))
//        assertNotNull(protoUserRepo.saveEmailState("michail@gmail.com"))
//        assertNotNull(protoUserRepo.saveMobileNumberState("89395557707"))
//        assertNotNull(protoUserRepo.saveUserPasswordState("qwerty"))
//        assertNotNull(protoUserRepo.getUserDataState())
//    }
}
