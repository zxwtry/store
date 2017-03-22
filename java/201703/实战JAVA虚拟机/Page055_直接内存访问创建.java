package 实战JAVA虚拟机;

import java.nio.ByteBuffer;

public class Page055_直接内存访问创建 {
    public static void main(String[] args) {
        AccessDirectBuffer accessDirectBuffer = new AccessDirectBuffer();
        accessDirectBuffer.bufferAccess();
        accessDirectBuffer.directAccess();
        
        accessDirectBuffer.bufferAccess();
        accessDirectBuffer.directAccess();
        
        AllocDirectBuffer allocDirectBuffer = new AllocDirectBuffer();
        allocDirectBuffer.bufferAllocate();
        allocDirectBuffer.directAllocate();
        /*
                                输出：
                testBufferWrite: 201
                testDirectWrite: 164
                testBufferWrite: 240
                testDirectWrite: 149
                testBufferAllocate: 296
                testDirectAllocate: 664
                                结论：
                               　 　直接内存访问快
                              　　  堆内存申请快
         */
    }
    static class AccessDirectBuffer {
        public void directAccess() {
            long startTime = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(500);
            for (int i = 0; i < 1000000; i ++) {
                for (int j = 0; j < 99; j ++) {
                    byteBuffer.putInt(j);
                }
                byteBuffer.flip();
                for (int j = 0; j < 99; j ++) {
                    byteBuffer.getInt();
                }
                byteBuffer.clear();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("testDirectWrite: " + (endTime - startTime));
        }
        public void bufferAccess() {
            long startTime = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(500);
            for (int i = 0; i < 1000000; i ++) {
                for (int j = 0; j < 99; j ++) {
                    byteBuffer.putInt(j);
                }
                byteBuffer.flip();
                for (int j = 0; j < 99; j ++) {
                    byteBuffer.getInt();
                }
                byteBuffer.clear();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("testBufferWrite: " + (endTime - startTime));
        }
    }
    static class AllocDirectBuffer {
        public void directAllocate() {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 200000; i ++) {
                ByteBuffer.allocateDirect(10000);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("testDirectAllocate: " + (endTime - startTime));
        }
        public void bufferAllocate() {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 200000; i ++) {
                ByteBuffer.allocate(10000);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("testBufferAllocate: " + (endTime - startTime));
        }
    }
}
