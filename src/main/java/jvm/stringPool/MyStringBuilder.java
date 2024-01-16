package jvm.stringPool;

public class MyStringBuilder {
    public static void main(String[] args) {
        String a = "1";
        String b = "2";
        String c = "12";
        String d1 = (a+b).intern();
        String d2 = "1" + "2";

        System.out.println(c == d1); // false : 當 + 連接兩個變數(a,b)，底層new StringBuilder創建新的String讓入heap
        System.out.println(c == d2); // true : 當

        String s1 = new StringBuilder().append("abc").append("123").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder().append("Ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
