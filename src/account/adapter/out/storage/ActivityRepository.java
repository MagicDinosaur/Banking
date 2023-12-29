package account.adapter.out.storage;

import java.time.LocalDateTime;

interface ActivityRepository extends JpaRepository<ActivityEntity, Long>{
    @Query("select a from ActivityEntity a where a.ownerAccountId = :ownerAccountId and a.timestamp >= :since")
    List<ActivityEntity> findbyOwnerSince(
            @Param("ownerAccountId") long ownerAccountId,
            @Param("since")LocalDateTime since);

    @Query("select sum(a.amount) from ActivityEntity a where a.targetAccountId = :accountId and a.ownerAccountId = :accountId and a.timestamp <:until")
    Long getDepositBalanceUntil(
            @Param("accountId") Long accountId,
            @Param("until") LocalDateTime until
    );

    @Query("select sum(a.amount) from ActivityEntity a where a.sourceAccountId = :accountId and a.ownerAccountId = :accountId and a.timestamp < :until")
    Long getWithdrawalBalanceUntil(
            @Param("accountId") Long accountId,
            @Param("until") LocalDateTime until
    );

}
