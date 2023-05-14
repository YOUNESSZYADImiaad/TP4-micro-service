package or.sid.bankaccountservice.service;

import or.sid.bankaccountservice.dto.BankAccountRequestDTO;
import or.sid.bankaccountservice.dto.BankAccountResponseDTO;
import or.sid.bankaccountservice.entities.BankAccount;
import or.sid.bankaccountservice.enums.AccountType;
import or.sid.bankaccountservice.mappers.AccountMapper;
import or.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDTO.getType())
                .balance(bankAccountDTO.getBalance())
                .createdAt(new Date())
                .Currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount account = bankAccountRepository.save(bankAccount);
        /*BankAccountResponseDTO bankAccountResponseDT0 = BankAccountResponseDTO.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .type(account.getType())
                .createdAt(account.getCreatedAt())
                .Currency(account.getCurrency())
                .build();*/
        BankAccountResponseDTO bankAccountResponseDT0 = accountMapper.fromBankAccount(account);
        return bankAccountResponseDT0;
    }
}
