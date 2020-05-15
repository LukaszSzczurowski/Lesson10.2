public class BankAccount {
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

    public void withdrow(double takeMoneyFromAccount) {
        if ((getAccountState() - takeMoneyFromAccount) < 0)
            throw new IllegalArgumentException();
        else
            setAccountState(getAccountState() - takeMoneyFromAccount);
    }

    @Override
    public String toString() {
        return "Osoba: " + person.getName() + "" + person.getLastName() +
                ". Stan konta: " + accountState;
    }
}
