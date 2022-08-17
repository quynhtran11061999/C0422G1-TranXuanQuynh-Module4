package com.mailbox.service.impl;

import com.mailbox.model.Mailbox;
import com.mailbox.repository.IMailboxRepository;
import com.mailbox.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService implements IMailboxService {
    @Autowired
    private IMailboxRepository iMailboxRepository;

    @Override
    public List<String> languages() {
        return iMailboxRepository.languages();
    }

    @Override
    public List<Integer> pageSize() {
        return iMailboxRepository.pageSize();
    }
}
