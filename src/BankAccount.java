public class BankAccount {
    private static final int DAY_WITHDRAW_LIMIT = 1000;
    private Person person;
    private double accountState;

    public BankAccount(Person person, double accountState) {
        if (person.equals(null))
            throw new NullPointerException();
        else
            this.person = person;

        this.accountState = accountState;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getAccountState() {
        return accountState;
    }

    public void setAccountState(double accountState) {
        this.accountState = accountState;
    }

    public void deposit(double addMoneyToAccount) {
        setAccountState(getAccountState() + addMoneyToAccount);
    }

    public void withdrow(double takeMoneyFromAccount) throws NoMoneyToWithdrawExeption, NoMoreThenThuosendExeption {
        if (takeMoneyFromAccount > DAY_WITHDRAW_LIMIT)
            throw new NoMoreThenThuosendExeption("Dzienny limit wypłat wynosi 1000 zł");
        if ((getAccountState() - takeMoneyFromAccount) < 0)
            throw new NoMoneyToWithdrawExeption("Próbujesz wypłacić więcej niż masz na koncie");
        else
            setAccountState(getAccountState() - takeMoneyFromAccount);
    }

    @Override
    public String toString() {
        return "Osoba: " + person.getName() + "" + person.getLastName() +
                ". Stan konta: " + accountState;
    }
}
