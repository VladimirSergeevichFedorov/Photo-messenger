package com.example.photoch

import androidx.test.platform.app.InstrumentationRegistry
import com.example.common.utils.getSHA512
import com.example.domain.repositories.AuthoriseRepo
import com.example.domain.repositories.RegisterRepo
import com.example.domain.usecase.SaveUserDataUseCase
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
//    lateinit var protoUserRepo: SaveUserDataUseCase

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
//        val actual = protoUserRepo.apply {
////            saveEmail("michail@gmail.com")
////            saveMobileNumberState("89395557707")
////            saveUserNameState("Mihail")
////            saveUserPasswordState("qwerty")
//        }
////        val expected = protoUserRepo.getUserDataState()
////        assertEquals(actual, expected)
////        assertNotNull(protoUserRepo.saveUserNameState("Mihail"))
////        assertNotNull(protoUserRepo.saveEmailState("michail@gmail.com"))
////        assertNotNull(protoUserRepo.saveMobileNumberState("89395557707"))
////        assertNotNull(protoUserRepo.saveUserPasswordState("qwerty"))
////        assertNotNull(protoUserRepo.getUserDataState())
//    }
}
