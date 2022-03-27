package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class BankingApp {
    String customerName;
    int accountNumber;
    float balanceAmount;
   static   int acNo = 1122;
    public float getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(float balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    BankingApp(String name,  float balance) {
        customerName = name;
        balanceAmount = balance;
        setAccountNumber(acNo);
        acNo++;
        System.out.println(name +" account Number is : "+accountNumber);
        System.out.println(Display());
    }

    public String Display() {
        return ("Customer name : "+customerName)+
                (", Account Number : "+accountNumber)+
                (", Balance Amount : "+balanceAmount);
    }

    void Deposit(float amt) {
        if (amt > 0) {
            balanceAmount += amt;
            System.out.println(customerName+" amount " + amt + " was deposit");
        } else {
            System.out.println("Invalid amount");
        }
    }

    void Withdraw(float amt) {
        if (amt < balanceAmount) {
            if (amt > 0) {
                balanceAmount =balanceAmount - amt;
                System.out.println(customerName+" amount " + amt + " was withdraw");
            }
        } else {
            System.out.println("Invalid amount");
        }
        System.out.println(Display());
    }
}
public class Main {

    public static void main(String[] args) {
        BankingApp person1=new BankingApp("Bala",5000);
        BankingApp person2=new BankingApp("Esai",15000);
        List<BankingApp> bankingApps = new ArrayList<>();
        bankingApps.add(person1);
        bankingApps.add(person2);
        Scanner scan = new Scanner(System.in);
        boolean onOrOf = true;
       while (onOrOf)
       {
           System.out.print("You are Account creating you press the number 1 or  Deposited press the number 2 or Withdraw press the number 3 or stop press the number 0 : ");
           int number = scan.nextInt();
          if(number == 0)
          {
              break;
          }
           if(number==1)
           {
               scan.nextLine();
               System.out.print("Enter your name : ");
               String name = scan.nextLine();
               System.out.print("Enter string amount :");
               float amount = scan.nextFloat();
               BankingApp person3 = new BankingApp(name,amount);
               bankingApps.add(person3);
           }else if(number == 2)
           {
               System.out.print("Enter the yor account number : ");
               int acNo = scan.nextInt();
               BankingApp ac = null;

               for (int i=0;i< bankingApps.size();i++)
               {
                   if(bankingApps.get(i).getAccountNumber()==acNo)
                   {
                       ac = bankingApps.get(i);
                   }
               }
               if(ac != null)
               {
                   System.out.print("Enter the amount : ");
                   float amount = scan.nextFloat();
                  ac.Deposit(amount);
               }

           }else if(number == 3)
           {
               System.out.print("Enter the yor account number : ");
               int acNo = scan.nextInt();
               System.out.print("Enter the name : ");
               scan.nextLine();
               String name = scan.nextLine();
               BankingApp ac = null;

               for (int i=0;i< bankingApps.size();i++)
               {
                   if(bankingApps.get(i).getAccountNumber()==acNo && bankingApps.get(i).getCustomerName()==name)
                   {
                       ac = bankingApps.get(i);
                   }
               }
               if(ac != null)
               {
                   System.out.print("Ethe the amount : ");
                   float amount = scan.nextFloat();
                   ac.Withdraw(amount);
               }
           }

       }


    }
}