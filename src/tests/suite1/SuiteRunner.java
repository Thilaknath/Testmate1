package tests.suite1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ logintest.class, Regtest.class,formfilling.class })
public class SuiteRunner {

}
