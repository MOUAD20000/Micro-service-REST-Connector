package org.sid.mappers;

import org.sid.dto.BankAccountRepsonceDTO;
import org.sid.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMaaper {

    public BankAccountRepsonceDTO fromBankBanlAcount(BankAccount bankAccount){

        BankAccountRepsonceDTO bankAccountRepsonceDTO = new BankAccountRepsonceDTO() ;
        BeanUtils.copyProperties(bankAccount,bankAccountRepsonceDTO);
        return  bankAccountRepsonceDTO ;

    }
}
