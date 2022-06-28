package com.csupreme19.studyjpa.service;

import com.csupreme19.studyjpa.domain.Account;
import com.csupreme19.studyjpa.dto.AccountDto;
import com.csupreme19.studyjpa.exception.CustomNoSuchDataException;
import com.csupreme19.studyjpa.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 계정 서비스
 * @author csupreme19
 * @since 2022.06.22
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final ModelMapper modelMapper;

    private final AccountRepository accountRepository;

    public AccountDto getAccount(String id) {
        return accountRepository.findById(id).map(this::toDto).orElseThrow(CustomNoSuchDataException::new);
    }

    public List<AccountDto> getAccounts() {
        return accountRepository.findAll().stream().map(this::toDto).toList();
    }

    public AccountDto createAccount(AccountDto dto) {
        Account account = accountRepository.save(modelMapper.map(dto, Account.class));
        return this.toDto(account);
    }

    public AccountDto updateAccount(AccountDto dto) {
        String id = dto.getId();
        String password = dto.getPassword();
        Account account = accountRepository.findById(id).orElseThrow(CustomNoSuchDataException::new);
        account.updateAccount(dto.getUsername(), dto.getEnabled());
        if (!password.equals(account.getPassword())) {
            account.updatePassword(password);
        }
        return this.toDto(account);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    private Account toEntity(AccountDto dto) {
        return modelMapper.map(dto, Account.class);
    }

    private AccountDto toDto(Account entity) {
        return modelMapper.map(entity, AccountDto.class);
    }
}