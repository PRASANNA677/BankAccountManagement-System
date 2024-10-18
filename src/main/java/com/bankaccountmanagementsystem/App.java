package com.bankaccountmanagementsystem;

import java.util.List;
import java.util.Scanner;

import com.bankaccountmanagementsystem.dao.AccountDao;
import com.bankaccountmanagementsystem.daoimpl.AccountDaoImpl;
import com.bankaccountmanagementsystem.entity.Account;

/**
 * Hello world!
 *
 */
public class App {

    private static AccountDao accountdao = new AccountDaoImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Account");
            System.out.println("2. View Account");
            System.out.println("3. View All Accounts");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    viewAccount();
                    break;
                case 3:
                    viewAllAccounts();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addAccount() {
        System.out.println("Enter Account Number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter Account Holder Name:");
        String accountHolder = scanner.nextLine();
        System.out.println("Enter The Balance:");
        double balance = scanner.nextDouble();

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountHolder(accountHolder);
        account.setBalance(balance);

        accountdao.addAccount(account);
        System.out.println("Account added successfully!");
    }

    private static void viewAccount() {
        System.out.print("Enter account ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); 

        Account account = accountdao.getAccountById(id);
        if (account != null) {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewAllAccounts() {
        List<Account> accounts = accountdao.getAllAccounts();
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("--------------------------");
        }
    }

    private static void deposit() {
        System.out.print("Enter account ID: ");
        Long id = scanner.nextLong();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        accountdao.deposit(id, amount);
        System.out.println("Deposit successful.");
    }

    private static void withdraw() {
        System.out.print("Enter account ID: ");
        Long id = scanner.nextLong();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        accountdao.withdraw(id, amount);
        System.out.println("Withdrawal successful.");
    }

    private static void deleteAccount() {
        System.out.println("Enter Account ID: ");
        Long accountId = scanner.nextLong();

        accountdao.deleteAccount(accountId);
        System.out.println("Account deleted successfully.");
    }
}
