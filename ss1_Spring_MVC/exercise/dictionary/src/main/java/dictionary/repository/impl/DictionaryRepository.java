package dictionary.repository.impl;

import dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> languageMap = new HashMap<>();

    static {
        languageMap.put("hello","xin chào");
        languageMap.put("book","sách");
        languageMap.put("computer","máy tính");
        languageMap.put("pen","bút");
        languageMap.put("sorry","xin lỗi");
    };

    @Override
    public String translate(String language) {
        String result = "Không tìm thấy từ điển";
        if (languageMap.containsKey(language)){
            result = languageMap.get(language);
        }
        return result;
    }
}
