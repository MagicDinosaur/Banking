package account.app.port.in;

import account.domain.model.Money;

public interface GetAccountBalanceUseCase {

    Money getAccountBalance(GetAccountBalanceQuery query);
    record GetAccountBalanceQuery(AccountId accountId){

    }

}
