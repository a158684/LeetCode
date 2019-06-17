package xx.love.datastructure.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zhijun.li on 2019/6/17
 */
public class JewelsStones {
    public int jewelsStones(String l1,String l2){
        int count=0;
        Set<Character> characterSet=new HashSet<>(255);
        char[] j=l1.toCharArray();
        char[] s=l2.toCharArray();
        for (char c : j) {
            characterSet.add(c);
        }
        for (char c : s) {
            count+=characterSet.contains(c)?1:0;
        }
        return count;
    }
    public int jewelsStones2(String J,String S){
        boolean letters[] = new boolean[256];

        for(char ch : J.toCharArray()){
            letters[ch] = true;
        }

        int counter = 0;
        for(char ch: S.toCharArray()){
            if(letters[ch]){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println("------start-----"+System.currentTimeMillis());
        JewelsStones stones=new JewelsStones();
        System.out.println(stones.jewelsStones2("aA","aAAbbbbb"));
        System.out.println("------end-----"+System.currentTimeMillis());
    }
}
