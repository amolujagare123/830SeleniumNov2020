package TestNGDemo.Demos;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassThree {

    @Test //(enabled = false)
    public void classThreeTest1()
    {
        System.out.println("classThreeTest1");
        Assert.assertTrue(false,"classThreeTest1 is failed");


    }

    @Test (groups = "email") //(enabled = false)
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }

    @Parameters({"url","user","pass"})
    @Test
    public void classThreeTest3(String s1, String s2,String s3)
    {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);


        System.out.println("classThreeTest3");
    }


}
