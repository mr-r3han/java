package Phonepe;

import java.util.*;
public class Running extends AllBank {

    private static Running runObject=null;
    public static Long num;

    public void SettingPins(){
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_CYAN+"=================Welcome to PhonePay====================="+ANSI_RESET);
        System.out.println("Please register your mobile number..");
        

        // To check user entered correct number or not
        while(true){
            try{
                System.out.print("Enter mobile number : ");
                num = in.nextLong();
                int count = 0;
                Long temp = num;
                while(temp>0){
                    count++;
                    temp/=10;
                }
                try{
                    if(count>10 || count<10) throw new TenDigitException();
                }
                catch(TenDigitException e){
                    System.out.println("Please enter Exact 10 digit number..");
                }
                if(count == 10) break;
            }catch(InputMismatchException e){
                System.out.println("Please enter numeric number..");
            }
            in.nextLine();
        }

        // To check whether the OTP is 
        
        int OTP = Integer.parseInt(generateOTP(4));
        System.out.println(ANSI_CYAN+"=================================================="+ANSI_RESET);
        System.out.println("The OTP is sent to "+ num+" is : "+ANSI_GREEN + OTP +ANSI_RESET);
        while(true){            
            try{
                System.out.print("Enter OTP : ");
                int UserOtp=in.nextInt();
                int count = 0;
                int temp = UserOtp;
                while(temp>0){
                    count++;
                    temp/=10;
                }
                try{
                    if(count>4 || count<4) throw new OTPException();
                }
                catch(OTPException e){
                    System.out.println("Please enter Exact 4 digit number..");
                }
                if(OTP==UserOtp){
                    System.out.println(ANSI_CYAN+"============================================================"+ANSI_RESET);
                    System.out.println(ANSI_GREEN+"Your mobile number "+num+" is verifed and successfully registered..."+ANSI_RESET);  
                    System.out.println(ANSI_CYAN+"============================================================"+ANSI_RESET);                  
                    System.out.println("Please set 4 digit or 6 digit PhonePay pin..");
                    while(true){
                        try{
                        System.out.print("Enter pin : ");
                        int paypin1 = in.nextInt(); 
                        int count2=0;
                        int temp2=paypin1;
                        while(temp2>0){
                            count2++;
                            temp2/=10;
                        }
                        try{
                            if(count2<4 || count2>6 || count2==5){
                                throw new payPinException();
                            }else {
                                while(true){
                                    try{
                                        System.out.print("ReEnter pin : ");
                                        int paypin2 = in.nextInt();
                                        if(paypin1==paypin2){
                                            System.out.println(ANSI_GREEN+"--------------------------------------"+ANSI_RESET);
                                            System.out.println("Phone pay pin is successfully set..");
                                            System.out.println(ANSI_GREEN+"--------------------------------------"+ANSI_RESET);
                                            PhoneMain pm = PhoneMain.PhonePayObject();
                                            pm.setPhonePayPin(paypin1);
                                            System.out.println(ANSI_CYAN+"============================================================"+ANSI_RESET);
                                            System.out.println("Your mobile number "+num+" is linked with :\n 1)Axis Bank \n 2)Canara Bank \n 3)HDFC Bank ");
                                            while(true){
                                                try{
                                                    System.out.print("please enter phone pay pin to continue : ");
                                                    int userPPP = in.nextInt();
                                                    if(userPPP == pm.getPhonePayPin()){
                                                        System.out.println(ANSI_CYAN+"==========================================================="+ANSI_RESET);
                                                        settingPins sp = new settingPins();
                                                        sp.setPins();
                                                        break;
                                                    }else{
                                                        System.out.println("Invalid pin..");
                                                    }
                                                }catch(InputMismatchException e){
                                                    System.out.println("Please enter numeric numbers..");
                                                }
                                                in.nextLine();

                                                
                                            }
                                            break;
                                        }else{
                                            System.out.println("Please enter valid pin...");
                                        }
                                    }catch(InputMismatchException e){
                                        System.out.println("Please set valid 4 digit or 6 digit numeric pin..");
                                    }
                                    in.nextLine();

                                }  
                                                          
                                
                            }
                            break;
                            
                        }catch(payPinException e){
                            System.out.println("please set 4 digit or 6 digit pin");
                        }

                        }catch(InputMismatchException e){
                            System.out.println("Please set valid 4 digit or 6 digit numeric pin..");
                        }
                        in.nextLine();

                    }
                    break;
                }
                else System.out.println("Enter valid OTP..");
            }catch(InputMismatchException e){
                System.out.println("Please enter valid 4 digit numeric opt..");
            }
            in.nextLine();
        }

        
    }

    public Long getNum(){
        return num;
    }

    public static String generateOTP(int length) 
    {  
        String numbers = "0123456789";  
        Random rndm_method = new Random();  
        char[] otp = new char[length];  
        for (int i = 0; i < length; i++) {  
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));  
        }  
        return new String(otp);  
    }

    public static Running getRunObject(){
        if(runObject==null){
            runObject = new Running();
        }
        return runObject;
    }
}
