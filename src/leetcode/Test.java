package leetcode;

import java.util.*;

/**
 * Created by jerry on 2017/11/5.
 */
public class Test {
    public static void main(String[] args) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size()==1)return accounts;
        accounts.sort(Comparator.comparing(o -> o.get(0)));
        Map<String, List<List<String>>> map = new HashMap<>(1000);
        for (int i = 0; i < accounts.size(); i++) {
            if (map.containsKey(accounts.get(i).get(0))){
                List<List<String>> t = map.get(accounts.get(i).get(0));
                t.add(accounts.get(i));
            }
//            map.put(accounts.get(i).get(0), accounts.get(i));
        }
        return accounts;
    }

    private List<List<String>> merge(List<List<String>> accounts){
        for (List<String> s : accounts){

        }
        return accounts;
    }

    public String longestWord(String[] words) {
        if(words.length==1)return words[0];
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else if (o1.length()>o2.length()) {
                return -1;
            }else {
                return 1;
            }
        });
        for (String word:words) {
            int i = 0;
            for (; i < word.length(); i++) {
                if (!contains(words, word.substring(0, i+1)))break;
            }
            if (i == word.length())return word;
        }
        return "";
    }
    private boolean contains(String[] words, String target){
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }
}

