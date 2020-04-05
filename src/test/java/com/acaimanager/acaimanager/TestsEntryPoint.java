package com.acaimanager.acaimanager;

import com.acaimanager.acaimanager.functional.AcaiManagerApplicationTests;
import com.acaimanager.acaimanager.unit.CalcServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AcaiManagerApplicationTests.class,
    CalcServiceTest.class
})
public class TestsEntryPoint {
}
