package account.domain.service;

import account.app.port.in.SendMoneyCommand;
import account.app.port.in.SendMoneyUseCase;

public class SendMoneyService implements SendMoneyUseCase
{

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;

    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command){
        requireAccountExists(command.getSourceAccountId());
        requireAccountExists(command.getTargetAccountId());
        return doSendMoney(command);
    }


}
