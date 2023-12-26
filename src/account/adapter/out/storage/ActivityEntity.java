package account.adapter.out.storage;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActivityEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column private LocalDateTime timestamp;
    @Column private Long ownerAccountId;
    @Column private Long sourceAccountId;
    @Column private Long targetAccountId;
    @Column private Long amount;


}
