package jvm.leak;

import java.util.ArrayList;

public class HeapLeak {
    public static void main(String[] args) {

        ArrayList<byte[]> bytesList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            byte[] bytes = new byte[1024 * 1024 * 100];
            bytesList.add(bytes);
            System.out.println(i);
        }
    }
}
