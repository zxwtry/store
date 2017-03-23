package Java8编程官方参考教程;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Page704_探究NIO_操作文件 {
    public static void main(String[] args) {
        System.out.println(Byte.MAX_VALUE + "..." + Byte.MIN_VALUE);
        System.out.println((int)Character.MAX_VALUE + "..." + (int)Character.MIN_VALUE);
    }
    //完成读取文件
    static class Solution1 {
        public void solve() {
            Path path = Paths.get("E:/file/data/Template_ConvexHull.txt");
            //在try-with-resources中获取Channel，能够自动关闭文件
            try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(path)) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                while (true) {
                    int count = seekableByteChannel.read(byteBuffer);
                    if (count == -1) break;
                    //rewind之后，byteBuffer就能读了
                    byteBuffer.rewind();
                    for (int i = 0; i < count; i ++)
                        System.out.print((char)byteBuffer.get());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //和Solution1的不同就是少了一个变量
    static class Solution2 {
        public void solve() {
            //在try-with-resources中获取Channel，能够自动关闭文件
            try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(
                    Paths.get("E:/file/data/Template_ConvexHull.txt"))) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                while (true) {
                    int count = seekableByteChannel.read(byteBuffer);
                    if (count == -1) break;
                    //rewind之后，byteBuffer就能读了
                    byteBuffer.rewind();
                    for (int i = 0; i < count; i ++)
                        System.out.print((char)byteBuffer.get());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //将文件映射到缓存区
    static class Solution3 {
        public void solve() {
            try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                    Paths.get("E:/file/data/Template_ConvexHull.txt"))) {
                long channelSize = fileChannel.size();
                MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_ONLY, 0, channelSize);
                for (int i = 0; i < channelSize; i ++)
                    System.out.print((char)mappedByteBuffer.get());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //通过管道写入文件
    static class Solution4 {
        public void solve() {
            try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("E:/a.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(26);
                for (int i = 0; i < 26; i ++)
                    byteBuffer.put((byte)('A' + i));
                byteBuffer.rewind();
                fileChannel.write(byteBuffer);
            } catch (IOException e) {}
        }
    }
    //通过管道写入多次文件
    static class Solution5 {
        public void solve() {
            try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("E:/a.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(26);
                for (int time = 0; time < 3; time ++) {
                    for (int i = 25; i > -1; i --)
                        byteBuffer.put((byte)('A' + i));
                    byteBuffer.rewind();
                    fileChannel.write(byteBuffer);
                    byteBuffer.rewind();    //需要增加这一句
                }
            } catch (IOException e) {}
        }
    }
    //映射到缓存区写文件
    static class Solution6 {
        public void solve() {
            try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("E:/a.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
                MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);
                for (int i = 0; i < 26; i ++)
                    mappedByteBuffer.put((byte)('a' + i));
            } catch (IOException e) {} 
        }
    }
    static class Solution7 {
        public void solve() {
            try {
                Files.copy(Paths.get("E:/a.txt"), Paths.get("E:/b.txt"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
