package account.domain.model;


import java.time.LocalDateTime;
import lombok.NonNull;
import lombok.Value;
import lombok.RequireArgsConstructor;
import lombok.Value;

public class Activity {

    @Getter
    private ActivityId id;

    @Getter
    @NonNull
    private final Account.AccountId ownerAccountId;

    @Getter
    @NonNull
    private final Account.AccountId sourceAccountId;

    @Getter
    @NonNull
    private final LocalDateTime timestamp;

    @Getter
    @NonNull
    private final Money money;

    public Activity(@NonNull Account.AccountId ownerAccountId,
                    @NonNull Account.AccountId sourceAccountId,
                    @NonNull LocalDateTime timestamp,
                    @NonNull Money money) {
        this.id = new ActivityId();
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.timestamp = timestamp;
        this.money = money;
    }

    @Value
    public static class ActivityId {
        private final UUID value;
    }

}
