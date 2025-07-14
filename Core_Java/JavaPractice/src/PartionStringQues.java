import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PartionStringQues {
    public static List<String> partitionString(String s) {
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();
        StringBuilder segment = new StringBuilder();

        for(int i=0;i<s.length();i++){
            segment.append(s.charAt(i));
            String current = segment.toString();
            if(!seen.contains(current)){
                result.add(current);
                seen.add(current);
                segment = new StringBuilder();
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String input = "abbccccd";
        System.out.println(partitionString(input));
    }
}