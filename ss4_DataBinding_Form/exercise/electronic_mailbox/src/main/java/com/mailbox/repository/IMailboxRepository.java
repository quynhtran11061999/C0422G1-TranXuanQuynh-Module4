package com.mailbox.repository;

import com.mailbox.model.Mailbox;

import java.util.List;

public interface IMailboxRepository {
    List<String> languages();

    List<Integer> pageSize();
}
