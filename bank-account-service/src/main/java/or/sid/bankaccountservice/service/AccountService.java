package or.sid.bankaccountservice.service;

import or.sid.bankaccountservice.dto.BankAccountRequestDTO;
import or.sid.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
