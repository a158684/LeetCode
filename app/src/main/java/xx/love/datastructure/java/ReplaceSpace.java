package xx.love.datastructure.java;

/**
 * @author : zhijun.li on 2020/3/17
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        final int length = s.length();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            if (c==' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace("We are happy."));
    }
}
