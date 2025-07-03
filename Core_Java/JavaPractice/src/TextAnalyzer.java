import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzer {

    public static String cleanText(String input){
        if(input==null) return "";
        String s1 = input.trim().replaceAll("\\s+"," ");
        return s1;
    }

    public static void countCharacters(String input){
        int count=0;
        for (int i=0;i<input.length();i++){
            char curr = input.charAt(i);
            if(curr!=' '){
                count++;
            }
        }
        System.out.println(count);
    }

    public static Map<String, Integer> countWords(String input){
        Map<String, Integer> countFreq = new HashMap<>();
        String[] words = input.split(" ");
        for (int i = 0; i<words.length;i++){
            countFreq.put(words[i], countFreq.getOrDefault(words,0)+1);
        }
        return countFreq;
    }

    //Vowel and consonant counter
    public static void countVowelAndConsonants(String input){
        int vowelsCount = 0;
        int consonantsCount = 0;

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='a' ||input.charAt(i)=='e' || input.charAt(i)=='i' || input.charAt(i)=='o'||input.charAt(i)=='u'){
                vowelsCount++;
            }else
                consonantsCount++;
        }
        System.out.println("VowelsCount in the String :"+vowelsCount+"\n"
                +"ConsonantsCount in String "+consonantsCount);
    }

    public static Map<Character, Integer> getCharFreq(String input){
        Map<Character, Integer> charFreq = new HashMap<>();
            String alphaOnly = input.replaceAll("[^a-zA-Z]", "");
            char[] charArray = alphaOnly.toLowerCase().toCharArray();
            for (char c: charArray){
                charFreq.put(c, charFreq.getOrDefault(c,0)+1);
            }
            return charFreq;
    }

    public static List<String> getPalindrome(String input){
        List<String> palindromes = new ArrayList<>();
        String[] words = input.split(" ");

        for (int i =0; i<words.length;i++){
            String reversed="";
            for (int j=words[i].length()-1;j>=0;j--){
                reversed += words[i].charAt(j);
            }
            if (words[i].equalsIgnoreCase(reversed)){
                palindromes.add(words[i]);
            }
        }
        return palindromes;
    }

    public static String reverseSentence(String input){
        String reversed = "";
        for (int i=input.length()-1;i>=0;i--){
            reversed+=input.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        String input = " Hello there! Madam Arora teaches malayalam. Wow, what a radar level this is. ";
        String res = cleanText(input);
        System.out.println(res);
        countCharacters(input);
        System.out.println(countWords(input));
        countVowelAndConsonants(input);
        System.out.println(getCharFreq(input));
        System.out.println(getPalindrome(input));
        System.out.println(reverseSentence(input));
    }
}
