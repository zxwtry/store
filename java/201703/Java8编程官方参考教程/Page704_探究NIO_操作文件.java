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
    //复制文件
    static class Solution7 {
        public void solve() {
            try {
                Files.copy(Paths.get("E:/a.txt"), Paths.get("E:/b.txt"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //获取与路径和文件相关的信息
    static class Solution8 {
        public void solve() {
            Path path = Paths.get("E:/a.txt");
            System.out.printf("path.getFileName() is \"%s\"\r\n", path.getFileName());
            System.out.printf("path.getFileSystem().toString() is \"%s\"\r\n", path.getFileSystem().toString());
            System.out.printf("path.isAbsolute() is \"%b\"\r\n", path.isAbsolute());
            System.out.printf("path.getNameCount() is \"%d\"\r\n", path.getNameCount());
            System.out.printf("path.getParent().toString() is \"%s\"\r\n", path.getParent().toString());
            System.out.printf("path.getRoot().toString() is \"%s\"\r\n", path.getRoot().toString());
            System.out.printf("Files.exists(path) is \"%b\"\r\n", Files.exists(path));
            System.out.printf("Files.isWritable(path) is \"%b\"\r\n", Files.isWritable(path));
            System.out.printf("Files.isReadable(path) is \"%b\"\r\n", Files.isReadable(path));
            try {
                System.out.printf("Files.isHidden(path) is \"%b\"\r\n", Files.isHidden(path));
                BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.printf("basicFileAttributes.isDirectory() is \"%b\"\r\n", basicFileAttributes.isDirectory());
                System.out.printf("basicFileAttributes.isRegularFile() is \"%b\"\r\n", basicFileAttributes.isRegularFile());
                System.out.printf("basicFileAttributes.isSymbolicLink() is \"%b\"\r\n", basicFileAttributes.isSymbolicLink());
                System.out.printf("basicFileAttributes.lastModifiedTime() is \"%s\"\r\n", basicFileAttributes.lastModifiedTime().toString());
                System.out.printf("basicFileAttributes.size() is \"%d\"\r\n", basicFileAttributes.size());
                DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
                //UNIX like OS use PosixFileAttributes
                System.out.printf("dosFileAttributes.isDirectory() is \"%b\"\r\n", dosFileAttributes.isDirectory());
                System.out.printf("dosFileAttributes.isRegularFile() is \"%b\"\r\n", dosFileAttributes.isRegularFile());
                System.out.printf("dosFileAttributes.isSymbolicLink() is \"%b\"\r\n", dosFileAttributes.isSymbolicLink());
                System.out.printf("dosFileAttributes.lastModifiedTime() is \"%s\"\r\n", dosFileAttributes.lastModifiedTime().toString());
                System.out.printf("dosFileAttributes.size() is \"%d\"\r\n", dosFileAttributes.size());
            } catch (IOException e) {}
            
        }
    }
    //列出目录的内容
    static class Solution9 {
        public void solve() {
            String dirName = "E:/";
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirName))) {
                System.out.printf("dirName is %s\r\n", dirName);
                for (Path path : directoryStream) {
                    BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.printf("%s is dir ? %b!\r\n", path.getFileName(), basicFileAttributes.isDirectory());
                }
            } catch (IOException e) {}
        }
    }
    //只列出可目录文件
    static class Solution10 {
        public void solve() {
            String dirName = "E:/";
            DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return Files.isDirectory(entry);
                }
            };
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirName), how)) {
                System.out.printf("dirName is %s\r\n", dirName);
                for (Path path : directoryStream) {
                    BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.printf("%s is dir ? %b!\r\n", path.getFileName(), basicFileAttributes.isDirectory());
                }
            } catch (IOException e) {}
        }
    }
}
