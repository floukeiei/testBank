import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(!"0".equals(input)) {


            System.out.println("1: Create Account");
            System.out.println("2: Deposit money");
            System.out.println("3: Withdraw money");
            System.out.println("4: Check balance");
            System.out.println("5: Display Account Details");
            System.out.println("6: Increase year");
            System.out.println("0: Exit");

             input = sc.nextLine();

            switch (input) {
                case "1":
                    account = new Account();
                    System.out.print(" name :");
                    String name = sc.nextLine();
                    account.setName(name);
                    account.setBalance(0);
                    break;
                case "2":
                    System.out.print(" money :");
                    String money = sc.nextLine();
                    if(money.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                        account.setBalance(account.getBalance() + Double.parseDouble(money));
                    }
                    break;
                case "3":
                    System.out.print(" money :");
                    String withdraw = sc.nextLine();
                    if(withdraw.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                        if(account.getBalance() - Double.parseDouble(withdraw) <0){
                            System.out.print(" cannot withdraw");
                        }else if(account.getBalance() != 0 ){
                            account.setBalance( account.getBalance() - Double.parseDouble(withdraw));
                        }
                    }
                    break;
                case "4":
                    System.out.println("Your balance : " +account.getBalance());
                    break;
                case "5":
                    System.out.println("name : " +account.getName());
                    System.out.println("balance : " +account.getBalance());
                    break;
                case "6":
                    account.setBalance(calInterest(account.getBalance()));
                    System.out.println(account.getBalance());
                    break;
                default:
            }
        }
    }

    private static double calInterest(double balance ){
        return (0.015*balance)+balance;
    }
}
