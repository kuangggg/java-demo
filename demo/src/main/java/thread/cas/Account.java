package thread.cas;

public class Account {

    private final String name;

    private final int amount;

    public Account(String name, int v) {
        this.name = name;
        this.amount = v;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
