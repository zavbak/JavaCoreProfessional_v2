package homework7;

public class MyTest2 {
    @BeforeSuite
    public void beforeSuiteMethod(){
        System.out.println("BeforeSuite");
    }

    @BeforeSuite
    public void beforeSuiteMethod2(){
        System.out.println("BeforeSuite");
    }

    @Test(value = 3)
    public void test1(){
        System.out.println("test 1");
    }

    @Test(value = 2)
    public void test2(){
        System.out.println("test 2");
    }

    @Test(value = 1)
    public void test3(){
        System.out.println("test 3");
    }

    @AfterSuite
    public void afterSuiteMethod(){
        System.out.println("BeforeSuite");
    }

}