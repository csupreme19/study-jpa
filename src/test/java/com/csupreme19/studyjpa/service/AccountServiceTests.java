package com.csupreme19.studyjpa.service;

import com.csupreme19.studyjpa.domain.Account;
import com.csupreme19.studyjpa.dto.AccountDto;
import com.csupreme19.studyjpa.exception.CustomNoSuchDataException;
import com.csupreme19.studyjpa.repository.AccountRepository;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@SpringBootTest(classes = {AccountService.class, ModelMapper.class})
public class AccountServiceTests {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceTests.class);

    @Autowired
    AccountService accountService;

    @Autowired
    ModelMapper modelMapper;

    @MockBean
    AccountRepository accountRepository;

    @BeforeAll
    private static void testSetUp() {

    }

    @BeforeEach
    private void setUp() {

    }

    @Nested
    @DisplayName("getAccount 메소드는")
    class Describe_getAccount {
        @Nested
        @DisplayName("id 값이 존재할 때")
        class Context_with_exists_id {

            @Test
            @DisplayName("AccountDto를 리턴한다.")
            void it_returns_AccountDto() {
                // given
                String givenId = "csupreme19";
                Account expectedAccount = Account.builder()
                        .id(givenId)
                        .build();
                given(accountRepository.findById(givenId))
                        .willReturn(Optional.of(expectedAccount));

                // when
                AccountDto actualResult = accountService.getAccount(givenId);

                // then
                assertThat(actualResult).isNotNull();
            }
        }

        @Nested
        @DisplayName("id 값이 존재하지 않을 때")
        class Context_with_not_exists_id {

            @Test
            @DisplayName("CustomNoSuchDataException 예외를 던진다.")
            void it_throws_CustomNoSuchDataException() {
                // given
                String givenId = "csupreme19";
                given(accountRepository.findById(givenId)).willThrow(CustomNoSuchDataException.class);

                // when & then
                assertThrows(CustomNoSuchDataException.class, () -> accountService.getAccount(givenId));
            }
        }
    }

    @Nested
    @DisplayName("getAccounts 메소드는")
    class Describe_getAccounts {
        @Nested
        @DisplayName("정상 조회시")
        class Context {
            @Test
            @DisplayName("AccountDto 목록을 리턴한다.")
            void it_returns_List_AccountDto() {
                // given
                String givenId = "csupreme19";
                String givenId2 = "honggildong19";
                List<Account> expectedResult = new ArrayList<>();
                expectedResult.add(Account.builder()
                        .id(givenId)
                        .build());
                expectedResult.add(Account.builder()
                        .id(givenId2)
                        .build());
                given(accountRepository.findAll())
                        .willReturn(expectedResult);

                // when
                List<AccountDto> actualResult = accountService.getAccounts();

                // then
                assertThat(actualResult).isNotNull();
                assertThat(actualResult.size()).isNotZero();
            }
        }
    }

    @Nested
    @DisplayName("createAccount 메소드는")
    class Describe_createAccount {
        @Nested
        @DisplayName("Account가 유효할 때")
        class Context_with_valid_account {

            @Test
            @DisplayName("동일한 AccountDto를 응답한다.")
            void it_returns_AccountDto() {
                // given
                String givenId = "csupreme19";
                Account givenAccount = Account.builder()
                        .id(givenId)
                        .build();
                AccountDto expectedResult = modelMapper.map(givenAccount, AccountDto.class);
                given(accountRepository.save(any()))
                        .willReturn(givenAccount);

                // when
                AccountDto actualResult = accountService.createAccount(expectedResult);

                // then
                assertThat(actualResult).isNotNull();
            }
        }
    }

    @AfterEach
    private void tearDown() {

    }

    @AfterAll
    private static void testTearDown() {

    }
}
