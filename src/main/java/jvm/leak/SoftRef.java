package jvm.leak;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class SoftRef {
    public static void main(String[] args) {
        // VM Option:-Xmx200m
        ArrayList<SoftReference> softReferences = new ArrayList<>();
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 10; i++) {
            byte[] bytes = new byte[1024 * 1024 * 100];
            SoftReference<byte[]> softReference = new SoftReference<>(bytes, queue);
            softReferences.add(softReference);//SoftReference需要強引用保持
        }

        int delete = 0;
        while (queue.poll() != null) {
            delete++;
        }
        System.out.println(delete);
    }
}