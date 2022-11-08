package org.sid.service;

import org.sid.dto.BankAccountRepsonceDTO;
import org.sid.dto.BankAccountRequestDTO;
import org.sid.entities.BankAccount;

public interface AccountService  {

    public BankAccountRepsonceDTO addAccount(BankAccountRequestDTO bankAccountDTO) ;
}
