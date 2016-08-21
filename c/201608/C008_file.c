//这是一个标准的将字符串写入文件的应用，待创建的文件名由argv[1]给出
//写入字符串的长度不是一个固定值，而是由strlen函数返回
//实例输出创建文件的文件描述符fd和写入文件的字符串长度
#include<fcntl.h>
#include<stdio.h>
#include<string.h>
int main(int argc, char *argv[]) {
	int fd, temp;
	char writebuf[] = "This is a test!\n";
	if (argc != 2) {
		printf("请输入两个字符串，前面是内容，后面是文件名\n");
		return 1;
	}
	fd = open(*(argv+1), O_RDWR|O_CREATE, S_IRWXU);
	printf("文件描述符是: %d\n", fd);
	temp=write(fd, writebuf, strlen(writebuf));
	printf("输出的长度是: %d\n", temp);
	printf("关闭文件的返回是: %d\n", close(fd));
	return 0;
}
