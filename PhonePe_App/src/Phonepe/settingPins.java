package Phonepe;

import java.util.*;

public class settingPins extends AllBank {
    public void setPins(){
        while(true){
            Running r = Running.getRunObject();

            PhoneMain pm = PhoneMain.PhonePayObject();

            Scanner in = new Scanner(System.in);
            try{
                System.out.println("Please select bank : \n 1)Axis Bank \n 2)Cannara Bank \n 3)HDFC Bank \n 4)To exit..");
                System.out.print("Enter response : ");
                int res2=in.nextInt();
                if(res2==1){
                    if(pm.getAxisPinCount()!=1){
                        settingAxisPin();
                    }else{
                        AxisBank ab = AxisBank.getAxisObject();
                        if(ab.blockCount != 3){
                            ab.axisOperation();                            
                        }else{
                            System.out.println("=======================================================");
                            System.out.println(ANSI_RED+"You blocked for 24 hours"+ANSI_RESET);
                            System.out.println("=======================================================");
                        }
                    }
                }
                else if(res2==2){
                    if(pm.getCanaraPinCount()!=1){
                        settingCanaraPin();
                    }else{
                        CanaraBank cb = CanaraBank.getcanaraObject();
                        if(cb.blockCount != 3){
                            cb.canaraOperation();                            
                        }else{
                            System.out.println("=======================================================");
                            System.out.println(ANSI_RED+"You blocked for 24 hours"+ANSI_RESET);
                            System.out.println("=======================================================");
                        }
                    }
                }
                else if(res2==3){
                    if(pm.getHDFCPinCount()!=1){
                        settingHDFCPin();
                    }
                    else{
                        HDFCBank cb = HDFCBank.getHDFCObject();
                        if(cb.blockCount != 3){
                            cb.HDFCOperation();                            
                        }else{
                            System.out.println("=======================================================");
                            System.out.println(ANSI_RED+"You blocked for 24 hours"+ANSI_RESET);
                            System.out.println("=======================================================");
                        }
                    } 
                }
                else if(res2>=4 && res2<=9 || res2==0){
                    System.out.println(ANSI_GREEN+"=====================Thanks for using Phone Pay come back soon...=========================="+ANSI_RESET);
                    break;
                }else{
                    System.out.println("Invalid choice...");
                }
                

            }catch(InputMismatchException e){
                System.out.println("Please enter vaild option..");
            }
            in.nextLine();
        }
    }

    
}
