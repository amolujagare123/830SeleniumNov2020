package TestNGDemo.Demos;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassOne {

    @BeforeTest
    public void myBeforeTest()
    {
        System.out.println("myBeforeTest");
    }
    @AfterTest
    public void myAfterTest()
    {
        System.out.println("myAfterTest");
    }


    @Parameters({"url","user","pass"})
    @Test
    public void classOneTest1(String s1, String s2,String s3)
    {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("classOneTest1");
    }

    @Test (groups = "email")
    public void classOneTest2()
    {
        System.out.println("classOneTest2");
    }

    @Parameters({"url","user","pass"})
    @Test
    public void classOneTest3(String s1, String s2,String s3)
    {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("classOneTest3");
    }


}
