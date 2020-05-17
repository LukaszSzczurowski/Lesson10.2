import java.util.InputMismatchException;
import java.util.Scanner;

public class CashMachine {
    private static final int EXIT = 0;
    private static final int DRAW = 1;
    private static final int WITHDRAW = 2;
    private static final int SHOW_ACCOUNT = 3;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Person person = new Person("Lukasz", "Szczawski");
        int choise = 0;
        do {
            showOptions();
            try {
                BankAccount bankAccount = new BankAccount(person, 900);
                choise = scanner.nextInt();
                menuOperation(choise, bankAccount);

            } catch (InputMismatchException ex) {
                System.out.println("Nie ma takiej opcji. Spróbuj ponownie");
            }

        } while (choise != 0);

    }

    private static void menuOperation(int choise, BankAccount bankAccount) {
        switch (choise) {
            case DRAW:
                System.out.println("Jaką kwotę wpłacasz?");
                bankAccount.deposit(scanner.nextDouble());
                break;
            case WITHDRAW:
                System.out.println("Jaką kwotę wypłacasz?");
                try {
                    bankAccount.withdrow(scanner.nextDouble());
                } catch (NoMoneyToWithdrawExeption myExeption) {
                    myExeption.printStackTrace();
                } catch (NoMoreThenThuosendExeption noMoreThenThuosend) {
                    noMoreThenThuosend.printStackTrace();
                }
                break;
            case SHOW_ACCOUNT:
                System.out.println("Stan konta: " + bankAccount.toString());
            default:
                System.out.println("Nie ma takiej opcji");
        }
    }


    private static void showOptions() {
        System.out.println("Wybierz opcję:");
        System.out.println(DRAW + " - żeby wpłacić pieniądze");
        System.out.println(WITHDRAW + " - żeby podjąć gotówkę");
        System.out.println(SHOW_ACCOUNT + " - żeby wyświetlić stan konta");
        System.out.println(EXIT + " - Zakończyć");
    }
}
