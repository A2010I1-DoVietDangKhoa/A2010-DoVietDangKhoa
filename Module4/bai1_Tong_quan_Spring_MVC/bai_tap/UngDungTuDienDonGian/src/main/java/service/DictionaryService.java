package service;

public interface DictionaryService {
    String getDefinition(String word);

    void addDefinition(String word, String meaning);
}
