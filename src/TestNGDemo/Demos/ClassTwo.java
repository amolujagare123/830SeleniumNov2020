package TestNGDemo.Demos;

import org.testng.annotations.*;

public class ClassTwo {

    @Test
    public void classTwoTest1()
    {
        System.out.println("classTwoTest1");
    }

    @Test (groups = "email")
    public void classTwoTest2()
    {
        System.out.println("classTwoTest2");
    }
    @Parameters({"url","user","pass"})
    @Test
    public void classTwoTest3(String s1,String s2,String s3)
    {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("classTwoTest3");
    }


    @BeforeSuite
    public void myBeforeSuite()
    {
        System.out.println("myBeforeSuite");
    }
    @AfterSuite
    public void myAfterSuite()
    {
        System.out.println("myAfterSuite");
    }


}
