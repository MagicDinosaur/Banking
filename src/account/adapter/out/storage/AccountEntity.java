package account.adapter.out.storage;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue
    private  long id;
}


