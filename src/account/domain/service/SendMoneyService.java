package account.domain.service;

public class SendMoneyService implements SendMoneyUseCase
{

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;

    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command){
        requireAccountExists(command.getSourceAccountId());
        requireAccountExists(command.getTargetAccountId());
    }
}
