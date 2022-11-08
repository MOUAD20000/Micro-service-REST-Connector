package org.sid.service;

import org.sid.dto.BankAccountRepsonceDTO;
import org.sid.dto.BankAccountRequestDTO;
import org.sid.entities.BankAccount;
import org.sid.mappers.AccountMaaper;
import org.sid.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository ;
    @Autowired
    private AccountMaaper accountMaaper ;

    @Override
    public BankAccountRepsonceDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .CreatedAT(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency((bankAccountDTO.getCurrency()))
                .build() ;
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

       BankAccountRepsonceDTO bankAccountRepsonceDTO =  accountMaaper.fromBankBanlAcount(saveBankAccount);

        return bankAccountRepsonceDTO;
    }
}
