public class CashMachine {
    public static void main(String[] args) {

        Person person = new Person("Lukasz","Szczawski");
        try {
            BankAccount bankAccount = new BankAccount(person,900);
            System.out.println(bankAccount);
            System.out.println(bankAccount);
            bankAccount.withdrow(1000);
            System.out.println(bankAccount);
        } catch (NullPointerException ex){
            System.err.println("Nie podałeś właściciela konta");
        } catch (MyExeption myExeption) {
            System.out.println(myExeption.getMessage());
        } catch (NoMoreThenThuosend noMoreThenThuosend) {
            System.out.println(noMoreThenThuosend.getMessage());
        }


    }
}
