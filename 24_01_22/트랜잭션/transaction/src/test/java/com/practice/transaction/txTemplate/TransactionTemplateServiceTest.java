package com.practice.transaction.txTemplate;

import com.practice.transaction.Account;
import com.practice.transaction.Transaction.TransactionManagerService;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionTemplateServiceTest {
    private Long SENDER_ID = 1L;
    private Long RECEIVER_ID = 2L;
    private Long AMOUNT = 5000L;

    @Autowired
    private TransactionTemplateService service;
    @Autowired
    private TransactionMapper mapper;


    @BeforeEach
    void before() {
        Account sender = service.getAccountById(SENDER_ID);
        Account receiver = service.getAccountById(RECEIVER_ID);
        sender.setBalance(10000L);
        receiver.setBalance(0L);
        mapper.updateAccountBalance(sender);
        mapper.updateAccountBalance(receiver);
    }


    @Test
    @DisplayName("이체테스트 001: 정상 이체")
    void testTransfer_001() {
        Transfer transfer = service.transfer(SENDER_ID, RECEIVER_ID, AMOUNT);
        assertEquals(5000L,transfer.getSender().getBalance());
        assertEquals(5000L,transfer.getReceiver().getBalance());
    }

    @Test
    @DisplayName("이체테스트 002: send OK / receive fail")
    void testTransfer_002() {
        service.transfer(SENDER_ID, 901L, AMOUNT);

        assertEquals(10000L,service.getAccountById(SENDER_ID).getBalance());
        assertEquals(0L,service.getAccountById(RECEIVER_ID).getBalance());
    }

}