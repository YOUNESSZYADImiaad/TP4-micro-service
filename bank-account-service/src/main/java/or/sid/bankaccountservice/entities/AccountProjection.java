package or.sid.bankaccountservice.entities;

import or.sid.bankaccountservice.enums.AccountType;
import or.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "idtype")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
