package com.acaimanager.app;

import com.acaimanager.app.functional.AcaiManagerApplicationTests;
import com.acaimanager.app.unit.CalcServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AcaiManagerApplicationTests.class,
    CalcServiceTest.class
})
public class TestsEntryPoint {
}
