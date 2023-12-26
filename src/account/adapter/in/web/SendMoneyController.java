package account.adapter.in.web;

import account.app.port.in.SendMoneyCommand;

@RestController
public class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;
    @PortMapping(path = "/accounts/sendMoney/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount
    ){
        SendMoneyCommand command = new SendMoneyCommand(
                new AccountId(sourceAccountId),
                new AccountId(targetAccountId),
                Money.of(amount)
        );

        sendMoneyUseCase.sendMoney(command);
    }



}

