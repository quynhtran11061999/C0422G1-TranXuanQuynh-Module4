package com.mailbox.repository.impl;

import com.mailbox.model.Mailbox;
import com.mailbox.repository.IMailboxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository {
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public List<String> languages() {
        return languagesList;
    }

    @Override
    public List<Integer> pageSize() {
        return pageSizeList;
    }
}
