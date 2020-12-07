package Komal;

import java.util.ArrayList;
import java.util.Collections;

public class PLCDemo {

    public static void main(String[] args) {

        //int employee = 1100;
        ArrayList<String> plc = new ArrayList(){
            {
                for(int plcCount=0;plcCount<1100;plcCount++)
                {
                    add("run");
                }
            }
        };

        System.out.println(plc);
        for(int empCount=1;empCount<=1100;empCount++)
        {
            for(int plcCount=0;plcCount<1100-3;plcCount++)
            {
               /* if(empCount%1==1)
                    plc.add("run");*/

                if(empCount%2==0)
                {
                  plc.set(plcCount+1,"program");
                }
                if(empCount%3==0)
                {
                    if (plc.get(plcCount+2).equals("run"))
                        plc.set(plcCount+2,"program");

                    if (plc.get(plcCount+2).equals("program"))
                        plc.set(plcCount+2,"run");

                }
                if(empCount%4==0)
                {
                    if (plc.get(plcCount+3).equals("run"))
                        plc.set(plcCount+3,"program");

                    if (plc.get(plcCount+3).equals("program"))
                        plc.set(plcCount+3,"run");
                }


            }

            System.out.println("progress:"+empCount);
        }
        int runCount = Collections.frequency(plc,"run");
        System.out.println("===================================");
        System.out.println("Plc in run Mode :"+runCount);
        System.out.println("===================================");


    }
}
