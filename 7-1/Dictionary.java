/*
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/
import java.util.*;

public class Dictionary {
    HashMap<String, String[]> dictionary = new HashMap();

    public void addTranslations(String key, String[] translations) {
        String[] newValue = translations;

    	if (dictionary.containsKey(key)) {
            // Keep old translations
            ArrayList<String> tempList = new ArrayList(Arrays.asList(dictionary.get(key)));
            tempList.addAll(Arrays.asList(translations));
            newValue = tempList.toArray(new String[tempList.size()]);
        } 

        dictionary.put(key, newValue);
    }

    public List<String> translate(String key) throws WordNotFoundException {
    	if (!dictionary.containsKey(key)) {
    		throw new WordNotFoundException("Word not found.");
    	}

    	String[] translations = dictionary.get(key);
    	return Arrays.asList(translations);
    }
}