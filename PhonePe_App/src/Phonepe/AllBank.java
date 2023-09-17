package Phonepe;


import java.util.InputMismatchException;
import java.util.Scanner;

class AllBank{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public void settingAxisPin(){
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_YELLOW+"===========================Axis Bank============================="+ANSI_RESET);
        while(true){
            System.out.println("Please set 6 digit UPI pin for axis bank account. ");
            try{                
                System.out.print("Enter the pin : ");
                int axispin = in.nextInt();
                System.out.println(ANSI_YELLOW+"==================================================="+ ANSI_RESET);
                int temp = axispin;
                int count = 0;
                while(temp>0){
                    count++;
                    temp/=10;
                }
                try{
                    if(count!=6) throw new axisPinException();
                    else{
                        while(true){
                            try{
                                System.out.print("Reenter to set : ");
                                int reaxispin = in.nextInt();
                                System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
                                int temp2 = axispin;
                                int cou2 = 0;
                                while(temp2>0){
                                    cou2++;
                                    temp2/=10;
                                }
                                try{
                                    if(cou2!=6 || reaxispin!=axispin) throw new axisPinException();
                                    else{
                                        if(axispin==reaxispin){
                                            System.out.println(ANSI_GREEN+"Your Axis Bank UPI pin successfully set..."+ANSI_RESET);
                                            System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
                                            PhoneMain pm = PhoneMain.PhonePayObject();
                                            pm.setAxisPin(reaxispin);
                                            pm.setAxisPinCount(1);
                                            break;
                                        }
                                    }

                                }catch(axisPinException e){
                                    System.out.println("Please reenter correct 6 digit pin..");
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Please enter valid numeric number..");
                            }
                            in.nextLine();
                        }
                    }
                }catch(axisPinException e){
                    System.out.println("Please set exact 6 digit pin..");
                }
                break;

            }catch(InputMismatchException e){
                System.out.println("Please set numeric value..");
            }
            in.nextLine();
        }
        
    }

    public void settingCanaraPin(){
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_YELLOW+"===========================Canara Bank============================="+ANSI_RESET);
        while(true){
            System.out.println("Please set 6 digit UPI pin for Canara bank account. ");
            try{                
                System.out.print("Enter the pin : ");
                int axispin = in.nextInt();
                System.out.println(ANSI_YELLOW+"==================================================="+ ANSI_RESET);
                int temp = axispin;
                int count = 0;
                while(temp>0){
                    count++;
                    temp/=10;
                }
                try{
                    if(count!=6) throw new axisPinException();
                    else{
                        while(true){
                            try{
                                System.out.print("Reenter to set : ");
                                int reaxispin = in.nextInt();
                                System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
                                int temp2 = axispin;
                                int cou2 = 0;
                                while(temp2>0){
                                    cou2++;
                                    temp2/=10;
                                }
                                try{
                                    if(cou2!=6 || reaxispin!=axispin) throw new axisPinException();
                                    else{
                                        if(axispin==reaxispin){
                                            System.out.println(ANSI_GREEN+"Your Canara Bank UPI pin successfully set..."+ANSI_RESET);
                                            System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
                                            PhoneMain pm = PhoneMain.PhonePayObject();
                                            pm.setCanaraPin(reaxispin);
                                            pm.setCanaraPinCount(1);
                                            break;
                                        }
                                    }

                                }catch(axisPinException e){
                                    System.out.println("Please reenter correct 6 digit pin..");
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Please enter valid numeric number..");
                            }
                            in.nextLine();
                        }
                    }
                }catch(axisPinException e){
                    System.out.println("Please set exact 6 digit pin..");
                }
                break;

            }catch(InputMismatchException e){
                System.out.println("Please set numeric value..");
            }
            in.nextLine();
        }
        
    }


    public void settingHDFCPin(){
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_YELLOW+"===========================HDFC Bank============================="+ANSI_RESET);
        while(true){
            System.out.println("Please set 6 digit UPI pin for HDFC bank account. ");
            try{                
                System.out.print("Enter the pin : ");
                int axispin = in.nextInt();
                System.out.println(ANSI_YELLOW+"==================================================="+ ANSI_RESET);
                int temp = axispin;
                int count = 0;
                while(temp>0){
                    count++;
                    temp/=10;
                }
                try{
                    if(count!=6) throw new axisPinException();
                    else{
                        while(true){
                            try{
                                System.out.print("Reenter to set : ");
                                int reaxispin = in.nextInt();
                                System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
                                int temp2 = axispin;
                                int cou2 = 0;
                                while(temp2>0){
                                    cou2++;
                                    temp2/=10;
                                }
                                try{
                                    if(cou2!=6 || reaxispin!=axispin) throw new axisPinException();
                                    else{
                                        if(axispin==reaxispin){
                                            System.out.println(ANSI_GREEN+"Your HDFC Bank UPI pin successfully set..."+ANSI_RESET);
                                            System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
                                            PhoneMain pm = PhoneMain.PhonePayObject();
                                            pm.setHDFCPin(reaxispin);
                                            pm.setHDFCPinCount(1);
                                            break;
                                        }
                                    }

                                }catch(axisPinException e){
                                    System.out.println("Please reenter correct 6 digit pin..");
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Please enter valid numeric number..");
                            }
                            in.nextLine();
                        }
                    }
                }catch(axisPinException e){
                    System.out.println("Please set exact 6 digit pin..");
                }
                break;

            }catch(InputMismatchException e){
                System.out.println("Please set numeric value..");
            }
            in.nextLine();
        }
    }
}
