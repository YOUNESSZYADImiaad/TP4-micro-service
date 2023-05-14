package or.sid.bankaccountservice.mappers;

import or.sid.bankaccountservice.dto.BankAccountResponseDTO;
import or.sid.bankaccountservice.entities.BankAccount;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
