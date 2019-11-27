package xx.love.datastructure.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zhijun.li on 2019/6/17
 */
public class JewelsStones {
    public int jewelsStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        char[] cj = J.toCharArray();
        char[] cs = S.toCharArray();
        for (char c : cj) set.add(c);

        for (char c : cs) count += set.contains(c) ? 1 : 0;
        return count;
    }

    public int jewelsStones2(String J, String S) {
        boolean letters[] = new boolean[256];

        for (char ch : J.toCharArray()) {
            letters[ch] = true;
        }

        int counter = 0;
        for (char ch : S.toCharArray()) {
            if (letters[ch]) {
                counter++;
            }
        }
        return counter;
    }

    public int jewelsStones3(String J, String S) {
        long jewels = 0;
//<<     :     左移运算符，num << 1,相当于num乘以2
//
//>>     :     右移运算符，num >> 1,相当于num除以2
//
//>>>    :     无符号右移，忽略符号位，空位都以0补齐
        for (int i = 0; i < J.length(); i++) {
//            J.charAt(i)-'A'  会让ascii/unicode值“移位”，使A - Z的值为0 - 25。因此更适合作为数组索引。
            System.out.println("J.charAt(i)=" + J.charAt(i));
            System.out.println("J.charAt(i)-'A'=" + (J.charAt(i) - 'A'));
            System.out.println("1L<<J.charAt(i)-'A'=" + ((J.charAt(i) - 'A') >> 1L));
            jewels = jewels | (1L << (J.charAt(i) - 'A'));

            System.out.println("jewels=" + jewels);
        }

        int count = 0;

        for (int i = 0; i < S.length(); i++) {

            if ((jewels & (1L << S.charAt(i) - 'A')) != 0) count++;

        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println("------start-----" + System.currentTimeMillis());
        JewelsStones stones = new JewelsStones();
        System.out.println(stones.jewelsStones3("aA", "aAAbbbbb"));
        System.out.println("------end-----" + System.currentTimeMillis());
    }

}
