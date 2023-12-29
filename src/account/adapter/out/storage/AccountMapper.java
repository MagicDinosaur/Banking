package account.adapter.out.storage;
import java.util.ArrayList;
import java.util.List;

import account.domain.model.Account;
import account.domain.model.Account.AccountId;
import account.domain.model.Activity;
import account.domain.model.Activity.ActivityId;
import account.domain.model.Activity.ActivityWindow;
import account.domain.model.Money;
import org.springframework.stereotype.Component;
public class AccountMapper {


    Account mapToDomainEntity(
            AccountEntity account,
            List<ActivityEntity> activities,
            Long withdrawalBalance,
            Long depositBalance) {

        Money baselineBalance = Money.subtract(
                Money.of(depositBalance),
                Money.of(withdrawalBalance));



        return Account.withId(
                new AccountId(account.getId()),
                baselineBalance,
                mapToActivityWindow(activities));

    }

    ActivityWindow mapToActivityWindow(List<ActivityEntity> activities) {
        List<Activity> mappedActivities = new ArrayList<>();

        for (ActivityEntity activity : activities) {
            mappedActivities.add(new Activity(
                    new ActivityId(activity.getId()),
                    new AccountId(activity.getOwnerAccountId()),
                    new AccountId(activity.getSourceAccountId()),
                    new AccountId(activity.getTargetAccountId()),
                    activity.getTimestamp(),
                    Money.of(activity.getAmount())));
        }

        return new ActivityWindow(mappedActivities);
    }

    ActivityEntity mapToJpaEntity(Activity activity) {
        return new ActivityEntity(
                activity.getId() == null ? null : activity.getId().getValue(),
                activity.getTimestamp(),
                activity.getOwnerAccountId().getValue(),
                activity.getSourceAccountId().getValue(),
                activity.getTargetAccountId().getValue(),
                activity.getMoney().getAmount().longValue());
    }
}
