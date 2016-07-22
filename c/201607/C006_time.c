#include<time.h>
#include<stdio.h>
int main() {
	time_t tmp;
	char *wday[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	struct tm *p;
	time(&tmp);
	printf("%s", asctime(gmtime(&tmp)));
	p = localtime(&tmp);
	printf("年：%d\n", (1900+p->tm_year));
	printf("月：%d\n", (1+p->tm_mon));
	printf("日：%d\n", p->tm_mday);
	printf("时：%d\n", p->tm_hour);
	printf("分：%d\n", p->tm_min);
	printf("秒：%d\n", p->tm_sec);
	printf("星期：%s\n", wday[p->tm_wday]);
	return 0;
}
