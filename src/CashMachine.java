public class CashMachine {
    public static void main(String[] args) {

        Person person = new Person("Lukasz","Szczawski");
        try {
            BankAccount bankAccount = new BankAccount(person,5000);
            System.out.println(bankAccount);
            bankAccount.deposit(500);
            bankAccount.deposit(500);
            System.out.println(bankAccount);
            bankAccount.withdrow(10000);
            System.out.println(bankAccount);
        } catch (NullPointerException ex){
            System.err.println("Nie podałeś właściciela konta");
        } catch (IllegalArgumentException ex){
            System.err.println("Brak środków na koncie");
        }



    }
}
