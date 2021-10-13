import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private DictionaryService dictService;

    public void setDictionaryService(DictionaryService dictService){
        this.dictService = dictService;
    }

   
    public List<String> getDictionary() {
        return dictService.getDictionary();
    }

  
    public boolean isEnglishWord(String word) {
        return dictService.isEnglishWord(word);
    }

 
    public List<String> findPossibleWords(String input) {
        ArrayList <String> matches = new ArrayList <String> ();
        List<String> dictionary = getDictionary();
        input = input.toLowerCase();

       
        for (String word : dictionary) {
            

           
            Boolean nonMatch = true;

            for (char chWord : word.toCharArray()) {
                String w = Character.toString(chWord);

                
                if (word.length() - word.replace(w, "").length() !=
                        input.length() - input.replace(w, "").length()) {
                    nonMatch = false;
                    break;
                }
            }
            if (nonMatch) {
                matches.add(word);
            }
        }
        System.out.println(matches);
        return matches;
    }
}
