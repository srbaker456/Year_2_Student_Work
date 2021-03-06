import java.util.HashMap;
import java.util.HashSet;

/**
 * For Q2 part a:
 * This Thesaurus class can be used to look up the alternative words of a given word, 
 * also known as a synonym. New synonyms can be added to the thesaurus and it can change
 * words for their synonyms in a given sentence. Synonyms can also be cross-referenced
 * to further populate the thesaurus.
 * 
 *
 * @author (Steven Baker)
 * @version (05/02/2022)
 */
public class Thesaurus
{
    // For Q2 part b:
    // The HashMap, synonyms, containing string keys of string values.
    private HashMap<String, HashSet<String>> synonyms;
    
     
    /**
     * For Q2 part c:
     * Constructor for objects of class Thesaurus
     * with zero parameters. Initialises an empty
     * HashMap to store words and their  synonyms.
     */
    public Thesaurus()
    {
        // Initialise the HashMap for the synonyms.
        synonyms = new HashMap<>();
    }

    /**
     * For Q2 part d:
     * For testing purposes, this is a getter method that
     * returns the synonyms HashMap.
     *
     * @return A HashMap of the thesaurus.
     */
    public HashMap<String,HashSet<String>> getThesaurus()
    {
        // Return the HashMap of synonyms.
        return synonyms;
    }
    
    /**
     * For Q2 part e:
     * Also for testing, 
     * this method puts two sample (key-value) entries into the HashMap.
     *
     */
    public void populate()
    {
        // Add the keys to the thesaurus.
        synonyms.put("happy", new HashSet<>());
        synonyms.put("angry", new HashSet<>());
        
        // Then add the values for each key.
        synonyms.get("happy").add("joyful");
        synonyms.get("happy").add("contented");
        synonyms.get("happy").add("cheerful");
        //
        synonyms.get("angry").add("annoyed");
        synonyms.get("angry").add("vexed");
    }
    
    /**
     * For Q2 part f:
     * This method prints out the whole thesaurus in the form of a word, 
     * that is the key value, followed by its synonyms.
     *
     */
    public void print()
    {
        // Print out the thesaurus.
        System.out.println(getThesaurus());
    }
    
    /**
     * For Q2 part g:
     * This method adds a new synonym to the thesaurus.  
     *
     * @param aWord A String of the word to add to or update the thesaurus.
     * @param aSynonym A String of the synonym of the given word. 
     */
    public void addSynonym(String aWord, String aSynonym)
    {
        // If aWord already exists as a key in the synonyms map, this method will add a new synonym to it.
        if (synonyms.containsKey(aWord)) {
            synonyms.get(aWord).add(aSynonym);
        }
        // Otherwise, a new key and its synonym will be added to the synonyms map.
        else {
            synonyms.put(aWord, new HashSet<>());
            synonyms.get(aWord).add(aSynonym);
        }
        
    }
    
    /**
     * For Q2 part h:
     * This method prints out new variations of a given sentence. 
     * The inputted word is replaced by a different synonym each time.
     *
     * @param aWord A String of the word that should be replaced.
     * @param aSentence A String of a sentence  that has the word to replace.
     */
    public void replaceWord(String aWord, String aSentence)
    {
        String updatedSentence = aSentence;
        // In the given sentence, specify the word that we need to change. 
        // For each value of the matched key word, print a sentence with 
        // the key word replaced with a value, for each value.
        for (String aReplacement : synonyms.get(aWord)) {
            // In the given sentence, specify the word that needs to change and replace it with a synonym. 
            System.out.println(updatedSentence.replace(aWord, aReplacement));
            System.out.println();
        }
        
    }
    
    /**
     * For Q2 part i:
     * This method cross-references every word in the thesaurus, 
     * further populating the thesaurus by adding values as keys and visa versa.
     *
     */
    public void crossReference()
    {
        // Initialise a map to contain the cross-referenced keys and values: 
        HashMap<String, HashSet<String>> crossReferencedSynonyms = new HashMap<>();
        // For each key in the synonyms map...
        for (String aKey : synonyms.keySet()) {
            // ...and for each value in a key...
            for (String aValue : synonyms.get(aKey)) {
            // Create a key of that value and add it to the cross-referenced map.
            crossReferencedSynonyms.put(aValue, new HashSet<>());
                // Then for each value of that key in synonyms map...
                for (String aKeyValue : synonyms.get(aKey)) {
                      // ...add the values to the new key, unless the value is the new key.
                      if (!aValue.equals(aKeyValue)) {
                      crossReferencedSynonyms.get(aValue).add(aKeyValue);
                       
                    }
                }
            // Add the original key to the values of the new key, made from its synonym.
            crossReferencedSynonyms.get(aValue).add(aKey);
        }
        
        }
        
        // Add the new keys and values to the synonyms map.
        
        // For each key in the crossReferencedSynonyms map:
        for (String aReferencedKey : crossReferencedSynonyms.keySet()) {
             // Add the key to the synonyms map.
             synonyms.put(aReferencedKey, new HashSet<>());
             // Then for each value of that key...
             for (String aReferencedValue : crossReferencedSynonyms.get(aReferencedKey)) {
                      // ...add the synonym value to the key.
                      synonyms.get(aReferencedKey).add(aReferencedValue);
                }
             
        }
        
    }
}
