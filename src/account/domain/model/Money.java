package account.domain.model;

import java.math.BigDecimal;
import lombok.NonNull;
import lombok.Value;
public class Money {
    public static Money NONE = Money.of(0);

    @NonNull
    private final BigDecimal amount;

    public Money(BigDecimal add) {
        this.amount = add;

    }

    public boolean isPositive() {
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }
    public static Money add(Money a, Money b) {
        return new Money(a.amount.add(b.amount));
    }

    public static Money of(long value) {
        return new Money(BigDecimal.valueOf(value));
    }

    public Money negate() {
        return new Money(this.amount.negate());
    }
}
