package TestNGDemo.Demos;

import org.testng.annotations.Test;

public class ClassThree {

    @Test //(enabled = false)
    public void classThreeTest1()
    {
        System.out.println("classThreeTest1");
    }

    @Test //(enabled = false)
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }

    @Test
    public void classThreeTest3()
    {
        System.out.println("classThreeTest3");
    }


}
