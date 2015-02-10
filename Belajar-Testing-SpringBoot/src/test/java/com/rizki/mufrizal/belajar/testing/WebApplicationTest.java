package com.rizki.mufrizal.belajar.testing;

import com.rizki.mufrizal.belajar.testing.controller.TiketControllerTest;
import com.rizki.mufrizal.belajar.testing.service.impl.TiketServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses({
        TiketServiceImplTest.class,
        TiketControllerTest.class
    }
)
public class WebApplicationTest {

}