import java.util.*;
// ^ IMPORT: Using Java Collections, Optional, Date, Map, List, etc.

// ============================================================
// 1. CUSTOM EXCEPTION
// ============================================================

// INHERITANCE:
// InsufficientBalanceException IS-A RuntimeException.
// We are extending an existing Java class.
class InsufficientBalanceException extends RuntimeException {

    // CONSTRUCTOR:
    // Used to initialize the exception with a message.
    public InsufficientBalanceException(String message) {
        super(message);
        // ^ super() calls the parent class constructor.
    }
}


// ============================================================
// 2. ENUM
// ============================================================

// ENUM:
// Used when we have a fixed set of values.
enum AccountType {
    SAVINGS,
    CURRENT
}


// ============================================================
// 3. ACCOUNT CLASS
// ============================================================

// CLASS:
// A class is a blueprint for creating objects.
class Account {

    // ENCAPSULATION:
    // Variables are private so they cannot be directly accessed
    // from outside this class.
    private int accountNumber;
    private String holderName;
    private AccountType accountType;
    private double balance;


    // CONSTRUCTOR:
    // Used to initialize an Account object.
    public Account(int accountNumber,
                   String holderName,
                   AccountType accountType,
                   double balance) {

        this.accountNumber = accountNumber;
        // ^ "this" refers to the current object.

        this.holderName = holderName;
        this.accountType = accountType;
        this.balance = balance;
    }


    // GETTER:
    // Provides controlled access to private data.
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }


    // BUSINESS METHOD:
    // Deposit money into the account.
    public void deposit(double amount) {

        // CONDITIONAL STATEMENT:
        // Validating input before processing.
        if (amount <= 0) {

            // EXCEPTION:
            // IllegalArgumentException is a built-in Java exception.
            throw new IllegalArgumentException(
                    "Amount must be greater than 0");
        }

        balance = balance + amount;
        // ^ Modifying private data through a public method.
        // This is ENCAPSULATION.
    }


    // BUSINESS METHOD:
    // Withdraw money from the account.
    public void withdraw(double amount) {

        if (amount <= 0) {

            throw new IllegalArgumentException(
                    "Amount must be greater than 0");
        }


        // BUSINESS RULE:
        // User cannot withdraw more than balance.
        if (amount > balance) {

            // CUSTOM EXCEPTION:
            throw new InsufficientBalanceException(
                    "Insufficient balance");
        }


        balance = balance - amount;
    }


    // toString():
    // METHOD OVERRIDING:
    // Object class already has toString().
    // We are overriding it to provide our own implementation.
    @Override
    public String toString() {

        return "Account{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }
}


// ============================================================
// 4. TRANSACTION CLASS
// ============================================================

class Transaction {

    private int accountNumber;
    private String type;
    private double amount;
    private Date date;


    // CONSTRUCTOR
    public Transaction(int accountNumber,
                       String type,
                       double amount) {

        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;

        // OBJECT CREATION:
        // Creating a Date object.
        this.date = new Date();
    }


    @Override
    public String toString() {

        return "Transaction{" +
                "accountNumber=" + accountNumber +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}


// ============================================================
// 5. INTERFACE
// ============================================================

// ABSTRACTION:
//
// Interface tells WHAT operations a bank should have,
// but doesn't tell HOW they should be implemented.
//
// This is one of the major OOP concepts.
interface BankOperations {

    void createAccount(Account account);

    Account findAccount(int accountNumber);

    void deposit(int accountNumber, double amount);

    void withdraw(int accountNumber, double amount);

    void transfer(int from, int to, double amount);

    void deleteAccount(int accountNumber);
}


// ============================================================
// 6. BANK SERVICE
// ============================================================

// IMPLEMENTS:
//
// BankService promises to implement all methods
// defined inside BankOperations.
//
// This demonstrates ABSTRACTION + POLYMORPHISM.
class BankService implements BankOperations {


    // COLLECTION - HASHMAP:
    //
    // Key   = account number
    // Value = Account object
    //
    // HashMap provides fast lookup using account number.
    private final Map<Integer, Account> accounts =
            new HashMap<>();


    // COLLECTION - ARRAYLIST:
    //
    // Stores transaction history.
    private final List<Transaction> transactions =
            new ArrayList<>();


    // ========================================================
    // CREATE ACCOUNT
    // ========================================================

    // @Override:
    // This method comes from the BankOperations interface.
    @Override
    public void createAccount(Account account) {

        // HASHMAP:
        // containsKey() checks whether account already exists.
        if (accounts.containsKey(
                account.getAccountNumber())) {

            System.out.println(
                    "Account already exists!");

            return;
        }


        // HASHMAP:
        // put() stores key-value pair.
        accounts.put(
                account.getAccountNumber(),
                account);

        System.out.println(
                "Account created successfully.");
    }


    // ========================================================
    // FIND ACCOUNT
    // ========================================================

    @Override
    public Account findAccount(int accountNumber) {

        // HASHMAP:
        // get() searches using account number.
        Account account = accounts.get(accountNumber);


        if (account == null) {

            // THROW:
            // Manually throwing a custom exception.
            throw new AccountNotFoundException(
                    "Account not found: " +
                    accountNumber);
        }


        return account;
    }


    // ========================================================
    // DEPOSIT
    // ========================================================

    @Override
    public void deposit(int accountNumber,
                        double amount) {

        // OBJECT:
        // findAccount() returns an Account object.
        Account account =
                findAccount(accountNumber);


        // ENCAPSULATION:
        // We don't directly modify balance.
        //
        // Instead, we call the Account object's
        // deposit() method.
        account.deposit(amount);


        // OBJECT CREATION:
        // Creating a new Transaction object.
        Transaction transaction =
                new Transaction(
                        accountNumber,
                        "DEPOSIT",
                        amount);


        // ARRAYLIST:
        // Add transaction to list.
        transactions.add(transaction);


        System.out.println(
                "Deposit successful.");
    }


    // ========================================================
    // WITHDRAW
    // ========================================================

    @Override
    public void withdraw(int accountNumber,
                         double amount) {

        Account account =
                findAccount(accountNumber);


        // ENCAPSULATION:
        // Account controls its own balance.
        account.withdraw(amount);


        // CREATE OBJECT:
        Transaction transaction =
                new Transaction(
                        accountNumber,
                        "WITHDRAW",
                        amount);


        transactions.add(transaction);


        System.out.println(
                "Withdrawal successful.");
    }


    // ========================================================
    // TRANSFER
    // ========================================================

    @Override
    public void transfer(int from,
                         int to,
                         double amount) {

        // OBJECT REFERENCES:
        //
        // sender and receiver both refer to Account objects.
        Account sender =
                findAccount(from);

        Account receiver =
                findAccount(to);


        // WITHDRAW from sender.
        sender.withdraw(amount);


        // DEPOSIT into receiver.
        receiver.deposit(amount);


        // TRANSACTION OBJECT:
        transactions.add(
                new Transaction(
                        from,
                        "TRANSFER_OUT",
                        amount));


        transactions.add(
                new Transaction(
                        to,
                        "TRANSFER_IN",
                        amount));


        System.out.println(
                "Transfer successful.");
    }


    // ========================================================
    // DELETE ACCOUNT
    // ========================================================

    @Override
    public void deleteAccount(int accountNumber) {

        // First check whether account exists.
        findAccount(accountNumber);


        // HASHMAP:
        // remove() deletes key-value pair.
        accounts.remove(accountNumber);


        System.out.println(
                "Account deleted.");
    }


    // ========================================================
    // SHOW ALL ACCOUNTS
    // ========================================================

    public void showAllAccounts() {

        // COLLECTION:
        // values() returns all Account objects.
        //
        // forEach() is a Java 8 feature.
        //
        // :: is METHOD REFERENCE.
        accounts.values()
                .forEach(System.out::println);
    }


    // ========================================================
    // SORT ACCOUNTS BY BALANCE
    // ========================================================

    public List<Account> sortByBalance() {

        // STREAM API:
        //
        // stream() allows us to process collection data.
        return accounts.values()

                // STREAM:
                // sorted() sorts the objects.
                .stream()

                // LAMBDA:
                // Comparator compares account balances.
                .sorted(
                        Comparator.comparingDouble(
                                Account::getBalance)
                                .reversed())

                // COLLECT:
                // Convert Stream back into List.
                .toList();
    }


    // ========================================================
    // HIGHEST BALANCE
    // ========================================================

    public Optional<Account> highestBalance() {

        return accounts.values()

                // STREAM API
                .stream()

                // MAX:
                // Find account with maximum balance.
                .max(
                        Comparator.comparingDouble(
                                Account::getBalance));
    }


    // ========================================================
    // LOWEST BALANCE
    // ========================================================

    public Optional<Account> lowestBalance() {

        return accounts.values()
                .stream()

                // MIN:
                // Find account with minimum balance.
                .min(
                        Comparator.comparingDouble(
                                Account::getBalance));
    }


    // ========================================================
    // TOTAL BALANCE
    // ========================================================

    public double totalBankBalance() {

        return accounts.values()

                .stream()

                // mapToDouble():
                // Convert Account objects into salary/balance values.
                .mapToDouble(
                        Account::getBalance)

                // SUM:
                // Add all balances.
                .sum();
    }


    // ========================================================
    // AVERAGE BALANCE
    // ========================================================

    public double averageBalance() {

        return accounts.values()

                .stream()

                .mapToDouble(
                        Account::getBalance)

                // AVERAGE:
                .average()

                // OPTIONAL:
                // average() returns OptionalDouble.
                .orElse(0);
    }


    // ========================================================
    // ACCOUNTS ABOVE A CERTAIN BALANCE
    // ========================================================

    public List<Account> accountsAbove(
            double amount) {

        return accounts.values()

                .stream()

                // FILTER:
                // Keep only accounts matching condition.
                .filter(
                        account ->
                                account.getBalance()
                                > amount)

                .toList();
    }


    // ========================================================
    // COUNT ACCOUNTS BY TYPE
    // ========================================================

    public Map<AccountType, Long>
    countByAccountType() {

        return accounts.values()

                .stream()

                // COLLECTORS:
                // GROUPING BY account type.
                .collect(
                        java.util.stream.Collectors
                                .groupingBy(
                                        Account::getAccountType,

                                        // COUNT:
                                        // Count accounts in each group.
                                        java.util.stream.Collectors
                                                .counting()));
    }


    // ========================================================
    // SHOW TRANSACTIONS
    // ========================================================

    public void showTransactions() {

        // ARRAYLIST + LAMBDA + METHOD REFERENCE
        transactions.forEach(
                System.out::println);
    }
}


// ============================================================
// 7. SECOND CUSTOM EXCEPTION
// ============================================================

class AccountNotFoundException
        extends RuntimeException {

    public AccountNotFoundException(
            String message) {

        super(message);
    }
}


// ============================================================
// 8. MAIN CLASS
// ============================================================

public class ATMmg {

    public static void main(String[] args) {


        // ====================================================
        // OBJECT CREATION
        // ====================================================

        // "new" creates an object.
        //
        // account1 is a REFERENCE VARIABLE.
        Account account1 =
                new Account(
                        101,
                        "Rahul",
                        AccountType.SAVINGS,
                        50000);


        Account account2 =
                new Account(
                        102,
                        "Priya",
                        AccountType.SAVINGS,
                        75000);


        Account account3 =
                new Account(
                        103,
                        "Arun",
                        AccountType.CURRENT,
                        120000);


        Account account4 =
                new Account(
                        104,
                        "Sneha",
                        AccountType.CURRENT,
                        30000);


        // ====================================================
        // POLYMORPHISM
        // ====================================================

        // INTERFACE REFERENCE:
        //
        // BankOperations is the interface.
        // BankService is the implementation.
        //
        // This is RUNTIME POLYMORPHISM.
        BankOperations bank =
                new BankService();


        // ====================================================
        // CREATE ACCOUNTS
        // ====================================================

        bank.createAccount(account1);
        bank.createAccount(account2);
        bank.createAccount(account3);
        bank.createAccount(account4);


        // ====================================================
        // FIND ACCOUNT
        // ====================================================

        try {

            Account account =
                    bank.findAccount(101);

            System.out.println(
                    "\nFound Account:");

            System.out.println(account);

        } catch (AccountNotFoundException e) {

            // EXCEPTION HANDLING:
            // catch handles the exception.
            System.out.println(
                    "Error: " +
                    e.getMessage());
        }


        // ====================================================
        // DEPOSIT
        // ====================================================

        System.out.println(
                "\n===== DEPOSIT =====");

        bank.deposit(101, 10000);


        // ====================================================
        // WITHDRAW
        // ====================================================

        System.out.println(
                "\n===== WITHDRAW =====");

        bank.withdraw(102, 15000);


        // ====================================================
        // TRANSFER
        // ====================================================

        System.out.println(
                "\n===== TRANSFER =====");

        bank.transfer(
                101,
                103,
                20000);


        // ====================================================
        // SHOW ALL ACCOUNTS
        // ====================================================

        System.out.println(
                "\n===== ALL ACCOUNTS =====");

        // DOWNCASTING:
        //
        // bank is an interface reference.
        // We cast it back to BankService to access
        // methods that are not inside the interface.
        BankService service =
                (BankService) bank;

        service.showAllAccounts();


        // ====================================================
        // SORT
        // ====================================================

        System.out.println(
                "\n===== SORTED BY BALANCE =====");

        service.sortByBalance()
                .forEach(
                        System.out::println);


        // ====================================================
        // HIGHEST BALANCE
        // ====================================================

        System.out.println(
                "\n===== HIGHEST BALANCE =====");

        service.highestBalance()
                .ifPresent(
                        System.out::println);


        // ====================================================
        // LOWEST BALANCE
        // ====================================================

        System.out.println(
                "\n===== LOWEST BALANCE =====");

        service.lowestBalance()
                .ifPresent(
                        System.out::println);


        // ====================================================
        // TOTAL BALANCE
        // ====================================================

        System.out.println(
                "\n===== TOTAL BALANCE =====");

        System.out.println(
                service.totalBankBalance());


        // ====================================================
        // AVERAGE BALANCE
        // ====================================================

        System.out.println(
                "\n===== AVERAGE BALANCE =====");

        System.out.println(
                service.averageBalance());


        // ====================================================
        // FILTER
        // ====================================================

        System.out.println(
                "\n===== BALANCE ABOVE 60000 =====");

        service.accountsAbove(60000)
                .forEach(
                        System.out::println);


        // ====================================================
        // GROUPING
        // ====================================================

        System.out.println(
                "\n===== ACCOUNT TYPE COUNT =====");

        service.countByAccountType()
                .forEach(
                        (type, count) ->
                                System.out.println(
                                        type +
                                        " -> " +
                                        count));


        // ====================================================
        // TRANSACTIONS
        // ====================================================

        System.out.println(
                "\n===== TRANSACTIONS =====");

        service.showTransactions();


        // ====================================================
        // EXCEPTION HANDLING
        // ====================================================

        System.out.println(
                "\n===== EXCEPTION TEST =====");

        try {

            // Trying to withdraw more than balance.
            bank.withdraw(
                    104,
                    100000);

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Transaction failed: " +
                    e.getMessage());
        }


        // ====================================================
        // ACCOUNT NOT FOUND
        // ====================================================

        try {

            bank.findAccount(999);

        } catch (AccountNotFoundException e) {

            System.out.println(
                    "Error: " +
                    e.getMessage());
        }


        // ====================================================
        // DELETE ACCOUNT
        // ====================================================

        System.out.println(
                "\n===== DELETE ACCOUNT =====");

        bank.deleteAccount(104);

        service.showAllAccounts();
    }
}