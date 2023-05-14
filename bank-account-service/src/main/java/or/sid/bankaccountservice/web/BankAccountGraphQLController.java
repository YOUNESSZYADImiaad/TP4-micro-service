package or.sid.bankaccountservice.web;

import or.sid.bankaccountservice.entities.BankAccount;
import or.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountbyid(@Argument String id){
        return bankAccountRepository.findById(id).
                orElseThrow(()->new RuntimeException(String.format("Account %s Not Found Try Another id",id)));
    }

    @MutationMapping
    public BankAccount addAccount(@Argument BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @MutationMapping
    public BankAccount updateAccount(@Argument BankAccount bankAccount) {
        BankAccount existingAccount = bankAccountRepository.findById(bankAccount.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Account %s Not Found", bankAccount.getId())));
        existingAccount.setBalance(bankAccount.getBalance());
        existingAccount.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(existingAccount);
    }

    @MutationMapping
    public String deleteAccount(@Argument String id) {
        BankAccount accountToDelete = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s Not Found", id)));
        bankAccountRepository.delete(accountToDelete);
        return String.format("Account %s successfully deleted", id);
    }

}
