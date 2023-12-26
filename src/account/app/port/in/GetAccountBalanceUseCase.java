package account.app.port.in;

public interface GetAccountBalanceUseCase {

    Money getAccountBalance(GetAccountBalanceQuery query);
    record GetAccountBalanceQuery(AccountId accountId){

    }

}
