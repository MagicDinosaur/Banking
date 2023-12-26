package account.domain.service;

import account.app.port.in.GetAccountBalanceUseCase;

import java.time.LocalDateTime;

public class GetAccountBalanceService implements GetAccountBalanceUseCase {
    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(GetAccountBalanceQuery query) {
        return loadAccountPort.loadAccount(query.accountId(), LocalDateTime.now()).calculateBalance();
    }


}
