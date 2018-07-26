package homework7;

public class MyTest1 {
    @homework7.BeforeSuite
    public void beforeSuiteMethod(){
        System.out.println("BeforeSuite");
    }
    @homework7.Test(value = 3)
    public void test1(){
        System.out.println("test 1");
    }

    @homework7.Test(value = 2)
    public void test2(){
        System.out.println("test 2");
    }

    @homework7.Test(value = 1)
    public void test3(){
        System.out.println("test 3");
    }

    @homework7.AfterSuite
    public void afterSuiteMethod(){
        System.out.println("BeforeSuite");
    }

}