package repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Repository
public class BaseRepository {
    private HashMap<String, String> dictionary = new HashMap<String, String>();
    //private BaseRepository baseRepository;

    @Bean
    public BaseRepository baseRepository(){
        return new BaseRepository();
    }

    public String getDefinition(String word){
        return dictionary.get(word.toLowerCase());
    }

    public void addDefinition(String word, String meaning) {
        dictionary.put(word, meaning);
    }
}
