package com.example.demo.controller;

import com.example.demo.dto.AccountCreateReq;
import com.example.demo.dto.AccountUpdateReq;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    public final AccountService accountService;

    @PostMapping()
    public String create (@RequestBody AccountCreateReq request) {
        accountService.saveAccount(request);
        return "success";
    }


    @PutMapping("/{id}")
    public String update (@RequestBody AccountUpdateReq request , @PathVariable Long id) {
        accountService.updateAccount(request, id);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id) {
        accountService.deletedAccount(id);
        return "success";
    }
//
//    @GetMapping("account/{id}")
//    public AccountDto getAccountId (Integer id) {
//        return accountService.getAccount(id);
//    }
//
//    @GetMapping("account")
//    public List<AccountDto> getAccounts() {
//        return accountService.getAllAccounts();
//    }
}
