package com.mailbox.service;

import com.mailbox.model.Mailbox;

import java.util.List;

public interface IMailboxService {
    List<String> languages();

    List<Integer> pageSize();
}
