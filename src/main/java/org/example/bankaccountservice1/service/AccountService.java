package org.example.bankaccountservice1.service;


import org.example.bankaccountservice1.dto.BankAccountRequestDTO;
import org.example.bankaccountservice1.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
