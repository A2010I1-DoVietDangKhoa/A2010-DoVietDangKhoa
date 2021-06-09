package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import repository.BaseRepository;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    //private DictionaryService dictionaryService;
    @Autowired
    private BaseRepository baseRepository;

    @Bean
    public DictionaryService dictionaryService(){
        return new DictionaryServiceImpl();
    }

    @Override
    public String getDefinition(String word) {
        String result = baseRepository.getDefinition(word);
        if (result == null){
            return "No definition found.";
        }
        else {
            return result;
        }
    }

    public void addDefinition(String word, String meaning){
        baseRepository.addDefinition(word, meaning);
    }
}
