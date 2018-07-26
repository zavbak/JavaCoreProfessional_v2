package homework7;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunTestsTest {

    @Test
    public void start() throws Exception {
        System.out.println("Run: " + MyTest1.class.getName());
        RunTest.start(MyTest1.class);

        System.out.println("Run: " + MyTest1.class.getName());

        try {
            RunTest.start(MyTest2.class);
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}