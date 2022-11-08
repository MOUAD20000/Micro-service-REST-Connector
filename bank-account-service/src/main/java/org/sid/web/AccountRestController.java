package org.sid.web;

import org.sid.dto.BankAccountRepsonceDTO;
import org.sid.dto.BankAccountRequestDTO;
import org.sid.entities.BankAccount;
import org.sid.mappers.AccountMaaper;
import org.sid.repositories.BankAccountRepository;
import org.sid.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository ;
    private AccountService accountService ;
    private AccountMaaper accountMaaper ;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMaaper accountMaaper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMaaper = accountMaaper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){

        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found" ,id)));

    }

    @PostMapping("/bankAccounts")
    public BankAccountRepsonceDTO save(@RequestBody BankAccountRequestDTO requestDTO){
      return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}") // je modifie que les donnes que j'ai recu
    public BankAccount update(@PathVariable String id , @RequestBody BankAccount bankAccount ){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAT()!=null) account.setCreatedAT(new Date());
        if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }








}
