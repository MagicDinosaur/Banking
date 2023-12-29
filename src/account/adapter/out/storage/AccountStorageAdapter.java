package account.adapter.out.storage;

public class AccountStorageAdapter implements
        LoadAccountPort,
        UpdateAccountStatePort {
    private final AccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(
            AccountId accountId,
            LocalDateTime baselineDate
    ) {
        AccountEntity account = accountRepository.findById(accountId.getValue()).orElseThrow(EntityNotFoundException::new);
        List<AccountEntity> activities = activityRepository.findbyOwnerSince(
                accountId.getValue(),
                baselineDate
        );

        Long withdrawalBalance = orZero(activityRepository.getWithdrawalBalanceUntil(
                accountId.getValue(),
                baselineDate
        ));
        Long depositBalance = orZero(activityRepository.getDepositBalanceUntil(
                accountId.getValue(),
                baselineDate
        ));

        return accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrawalBalance,
                depositBalance
        );
    }
    private Long orZero(Long value){
        return value == null ? 0L: value;
    }

    @Override
    public void updateActivites(Account account){
        for(Activity activity : account.getActivityWindow().getActivities()){
            if (activity.getId() == null ){
                activityRepository.save(accountMapper.mapToEntity(activity))''
            }
        }
    }
}
