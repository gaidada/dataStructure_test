package ch14.c4_kmp;

/**
 * @author gai
 * @create 2021--03--25
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String s1 = "中国你中你国你国中国你好";
        String s2 = "中国你好-";
        int i = violenceMatch(s1, s2);
        System.out.println(i);
    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0;//指向s1
        int j = 0;//指向s2
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {//匹配成功
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
