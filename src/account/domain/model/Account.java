package account.domain.model;

import java.time.LocalDateTime;

public class Account {
    private AccountId id;
    private Money baseBalance;
    private ActivityWindow activityWindow;

    public Money calculateBalance() {
        return Money.add(
                this.baseBalance,
                this.activityWindow.calculateBalance(this.id));
    }


    public boolean withdraw(Money money, AccountId targetAccountId) {
        if (!canWithdraw(money)) {
            return false;
        }

        ActivityWindow withdrawal = new Activity(
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money);
        this.activityWindow.addActivity(withdrawal);
        return true;

    }

    private boolean canWithdraw(Money money) {
        return Money.add(
                this.calculateBalance(),
                money.negate()).isPositive();
    }

    public boolean deposit(Money money, AccountId sourceAccountId){
        Activity deposit = new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money);
        this.activityWindow.addActivity(deposit);
        return true;
    }


}
