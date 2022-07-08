package com.csupreme19.studyjpa.controller;

import com.csupreme19.studyjpa.dto.AccountDto;
import com.csupreme19.studyjpa.model.CommonResponse;
import com.csupreme19.studyjpa.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 계정 컨트롤러
 * @author csupreme19
 * @since 2022.06.22
 */
@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<CommonResponse<?>> getAccounts(Pageable pageable) {
        return new ResponseEntity<>(new CommonResponse<>(this.accountService.getAccounts()), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CommonResponse<?>> getAccount(@PathVariable String id) {
        return new ResponseEntity<>(new CommonResponse<>(this.accountService.getAccount(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createAccount(@Valid @RequestBody AccountDto dto) {
        return new ResponseEntity<>(new CommonResponse<>(this.accountService.createAccount(dto)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CommonResponse<?>> updateAccount(@Valid @RequestBody AccountDto dto) {
        return new ResponseEntity<>(new CommonResponse<>(this.accountService.updateAccount(dto)), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<CommonResponse<?>> deleteAccount(@PathVariable String id) {
        this.accountService.deleteAccount(id);
        return new ResponseEntity<>(new CommonResponse<>(), HttpStatus.OK);
    }
}