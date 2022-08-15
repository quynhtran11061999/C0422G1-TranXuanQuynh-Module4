package dictionary.service.impl;

import dictionary.repository.IDictionaryRepository;
import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository iDictionaryRepository;


    @Override
    public String Translate(String language) {
        return iDictionaryRepository.Translate(language);
    }
}
