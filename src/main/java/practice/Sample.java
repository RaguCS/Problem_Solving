package practice;

import java.util.*;

public class Sample {
    Map<Integer, String> keys = new HashMap<Integer, String>();
    List<String> list=new ArrayList<>();
    StringBuilder stringBuilder=new StringBuilder();
    public static void main(String[] args) {
        Sample sample=new Sample();
        System.out.println(sample.letterCombinations("23"));

    }

    public List<String> letterCombinations(String digits) {
        keys.put(2,"abc");
        keys.put(3,"def");
        keys.put(4,"ghi");
        keys.put(5,"jkl");
        keys.put(6,"mno");
        keys.put(7,"pqrs");
        keys.put(8,"tuv");
        keys.put(9,"wxyz");
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        backTrack(digits.toCharArray(),digits.length());

        return list;
    }
    public void backTrack(char[] arr,int N){
        if(stringBuilder.length()==N){
            list.add(stringBuilder.toString());
            return;
        }
        for (char c:keys.get(arr[0]-'0').toCharArray()) {
            stringBuilder.append(c);
            backTrack(Arrays.copyOfRange(arr, 1, arr.length), N);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
