package org.example.bankaccountservice1.web;

import org.example.bankaccountservice1.dto.BankAccountRequestDTO;
import org.example.bankaccountservice1.dto.BankAccountResponseDTO;
import org.example.bankaccountservice1.entities.BankAccount;
import org.example.bankaccountservice1.entities.Customer;
import org.example.bankaccountservice1.repositories.BankAccountRepository;
import org.example.bankaccountservice1.repositories.CustomerRepository;
import org.example.bankaccountservice1.service.AccountService;
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
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount>accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument  String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
         bankAccountRepository.deleteById(id);
         return true;
    }
    @QueryMapping
    public List<Customer>customers(){
        return customerRepository.findAll();
    }


}
/*record BankAccountDTO(Double balance,String type,String currency){

}*/