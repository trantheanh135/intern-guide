package com.example.demo.controller;

import com.example.demo.dto.AccountDTO.AccountCreateReq;
import com.example.demo.dto.AccountDTO.AccountUpdateReq;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public AccountEntity getAccountId (@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @GetMapping()
    public Page<AccountEntity> getAccounts(@RequestParam(value = "page" ,required = false) Integer pageNumber,
                                        @RequestParam(value = "limit",  required = false) Integer limitNumber,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "order", required = false) String sortOrder) {
        if(pageNumber==null) pageNumber=0;
        if(limitNumber==null) limitNumber=0;
        return accountService.getAllAccounts(pageNumber, limitNumber, sort, sortOrder);
    }

    @GetMapping("/search")
    public List<AccountEntity> searchAccount(@RequestParam(value = "username", required = false) String search) {
        return accountService.searchAccount(search);
    }
}
