package org.sid.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.enums.AccountType;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRepsonceDTO {

    private  String id ;
    private Date CreatedAT ;
    private Double balance;
    private String currency ;
    private AccountType type ;
}
