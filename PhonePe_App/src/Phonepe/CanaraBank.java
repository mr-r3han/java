package Phonepe;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CanaraBank extends AllBank {
    private static CanaraBank canaraObject = null;  

    long balance = 5000;

    public void canaraOperation(){
        Scanner in = new Scanner(System.in);
        while(true){
            if(blockCount == 3) break;
            System.out.println(ANSI_YELLOW+"===================Welcome back to Canara Bank==================="+ANSI_RESET);
            System.out.println(" 1)Balance Check \n 2)Tranfer Money \n 3)Transaction History \n 4)To exit");
            try{
                System.out.print("Enter your response : ");
                int res = in.nextInt();
                if(res==1){
                    bankBalance();
                    // break;
                }else if(res==2){
                    transferMoney();
                    // break;
                }else if(res==3){
                    history();
                    // break;
                }else if(res==4){
                    System.out.println(ANSI_YELLOW+"=====================Thanks for using Canara Bank================================"+ANSI_RESET);
                    break;
                }else{
                    System.out.println("Invalid choice..");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter numeric value..");
            }
        }
    }

    int blockCount = 0;

    public void bankBalance(){
        while(true){
            Scanner in = new Scanner(System.in);
            try{
                System.out.println(ANSI_PURPLE+"========================================================="+ANSI_RESET);
                System.out.print("Please enter Canara Bank UPI pin to check Balance : ");
                int axisPinUser = in.nextInt();
                PhoneMain pm = PhoneMain.PhonePayObject();
                if(axisPinUser != pm.getCanaraPin()){
                    
                    blockCount++;
                    if(blockCount==3){
                        System.out.println(ANSI_RED+"==========You enter 3 times incoorect pin============="+ANSI_RESET);
                        System.out.println(ANSI_RED+"=================Come after 24 hours================" +ANSI_RESET);
                        break;
                    }
                    System.out.println("Invalid pin..");
                }else{
                    // System.out.println(ANSI_GREEN + "Balance : "+ balance +"" + ANSI_RESET);
                    String s = ANSI_GREEN + "Balance : "+ balance +"Rs.." + ANSI_RESET;
                    slowPrint(s);
                    break;
                }

            }catch(InputMismatchException e){
                // blockCount++;
                // if(blockCount == 3) break;
                System.out.println("Please enter numeric value..");
                
            }
        }
    }

    public void transferMoney(){
        Scanner in = new Scanner(System.in);
        System.out.println("To transfer amount we need reciver mobile number ..");
        System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
        while(true){
            try{
                System.out.print("Enter number : 91+");
                long number = in.nextLong();
                long temp = number;
                int count = 0;
                while(temp>0){
                    count++;
                    temp/=10;
                }
                try{
                    if(count<10 || count>10) throw new numberCheckException();
                    else{
                        System.out.println(ANSI_YELLOW+"================================================="+ANSI_RESET);
                        System.out.println("The mobile number "+number+" is verifed by Axis bank.");
                        while(true){
                            try{
                                System.out.print("Enter the amount to transfer : ");
                                int amountTrans = in.nextInt();
                                if(amountTrans<=0){ 
                                    throw new negativeCheckException();
                                }
                                else{
                                    while(true){
                                        if(blockCount==3) {
                                            System.out.println(ANSI_RED+"============3 times wrong pin come after 24 hours==========="+ANSI_RESET);
                                            System.out.println(ANSI_YELLOW+"-------------------------------------------------------------"+ANSI_RESET);
                                            break;
                                        }
                                        try{
                                            System.out.print("Enter the Axis Bank UPI pin : ");
                                            int pin = in.nextInt();
                                            PhoneMain pm = PhoneMain.PhonePayObject();
                                            if(pin!=pm.getCanaraPin()){ 
                                                blockCount++;
                                                System.out.println("Invalid pin...");
                                            }
                                            else{
                                                CanaraBank ab = CanaraBank.getcanaraObject();
                                                try{
                                                    if(amountTrans>ab.balance) throw new balanceCheckException();
                                                    else{
                                                        System.out.println(ANSI_YELLOW+"==================================================================="+ANSI_RESET);
                                                        String s1 = "transfering..";
                                                        slowPrint(ANSI_RED+s1+ANSI_RESET);
                                                        System.out.println(ANSI_GREEN+"The amount is successfully transfered to '"+number+ "' an amount : "+amountTrans+"rs."+ANSI_RESET);
                                                        ab.balance = ab.balance-amountTrans;
                                                        String s = amountTrans + "Rs is transfered to number " + number + ".";
                                                        ab.transactionHistory(s);
                                                        // transactionHistory(s);
                                                        break;
                                                    }
                                                }catch(balanceCheckException e){
                                                    System.out.println(ANSI_YELLOW+"==================================================================="+ANSI_RESET);
                                                    String s1 = "transfering..";
                                                    slowPrint(ANSI_RED + s1 + ANSI_RESET);
                                                    System.out.println(ANSI_RED+"Insuffient balance"+ANSI_RESET);
                                                    break;
                                                }
                                                                                
                                                                                        
                                            }
                                        }catch(InputMismatchException e){
                                            System.out.println("Please enter numeric values...");
                                        }
                                    
                                    }
                                }                               
                                
                                break;
                            }catch(InputMismatchException e){
                                System.out.println("Please enter numeric values...");
                            }catch(negativeCheckException e){
                                System.out.println("please don't enter negative values..");
                            }
                            in.nextLine();
                        }
                    
                    }
                    break;
                }catch(numberCheckException e){
                    System.out.println("Please enter 10 digit number..");
                }
                // break;
            }catch(InputMismatchException e){
                System.out.println("Please enter numeric values...");
            }
            in.nextLine();

        }
    }

    ArrayList<String> list = new ArrayList<String>(5);
    public ArrayList<String> transactionHistory(String s){      
        list.add(s);
        return list;
    }

    public void history(){
        if(list.isEmpty()){
            System.out.println(ANSI_PURPLE+"==============================================================="+ANSI_RESET);
            System.out.println("==Transaction History....");
            System.out.println(ANSI_GREEN+"--------------------------"+ANSI_RESET);
            System.out.println("We will update you soon");
        }else{
            System.out.println(ANSI_PURPLE+"==============================================================="+ANSI_RESET);
            String s = "Transaction history......";
            slowPrint(s);
            System.out.println(ANSI_GREEN+"-------------------"+ANSI_RESET);
            int i  = 1;
            for(String s1 : list){
                System.out.println(ANSI_YELLOW + i++ +") "+ANSI_RESET +s1);
            }
        }
        
        System.out.println(ANSI_PURPLE+"==============================================================="+ANSI_RESET);
    }




    public static void slowPrint(String output) {
        for (int i = 0; i<output.length(); i++) {
        char c = output.charAt(i);
        System.out.print(c);
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        }
        catch (Exception e) {

        }
        if(i==output.length()-1) System.out.println();
        }
    }   
    








    public static CanaraBank getcanaraObject(){
        if(canaraObject==null){
            canaraObject = new CanaraBank();
        }
        return canaraObject;
    }
}
