package jvm.leak;

import java.util.ArrayList;
import java.util.List;

public class OuterLeak {
    private String key ="123";

    private byte[] bytes = new byte[1024 * 1024 * 100];

    public List<Integer> listLeak() {
        // new ArrayList<必填>() {} 這樣是一個匿名內部類，.class文件可以看出 extends ArrayList，並持有調用者實例
        List<Integer> list = new ArrayList<Integer>() {
            private String name;

        };
        return list;
    }

    public List<Integer> listNormal() {
        List<Integer> list = new ArrayList<>();
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        int count = 0;
        while (true) {
            count++;
            System.out.println(count);
            OuterLeak outerLeak = new OuterLeak();
            List<Integer> list = outerLeak.listNormal();
            objects.add(list);
        }
    }
}
