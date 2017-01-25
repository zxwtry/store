#include<iostream>
#include<string.h>
#include<algorithm>
#include<math.h>

using namespace std;

//输入4个数字，若能得到运算结果为24，输出对应的运算表达式
//如11, 8, 3, 5
//输出(11-8)*(3+5)=24

const double threshold = 1E-6;
const int cardsNumber = 4;
const int resultValue = 24;
double number[cardsNumber];
string result[cardsNumber];

bool pointsGame(int n) {
    if (n == 1) {
        if (fabs(number[0] - resultValue) < threshold) {
           cout << result[0] << endl;
           return true;
        } else {
            return false;
        }
    }
    for (int i = 0; i < n; i ++) {
        for (int j = i+1; j < n; j ++) {
            double a, b;
            string expa, expb;

            a = number[i];
            b = number[j];
            number[j] = number[n - 1];

            expa = result[i];
            expb = result[j];
            result[j] = result[n - 1];

            result[i] = '(' + expa + '+' + expb + ')';
            number[i] = a + b;
            if (pointsGame(n - 1))
                return true;

            result[i] = '(' + expa + '-' + expb + ')';
            number[i] = a - b;
            if (pointsGame(n - 1))
                return true;

            result[i] = '(' + expb + '-' + expa + ')';
            number[i] = b - a;
            if (pointsGame(n - 1))
                return true;

            result[i] = '(' + expb + '*' + expa + ')';
            number[i] = b * a;
            if (pointsGame(n - 1))
                return true;
            
            if (b != 0) {
	            result[i] = '(' + expa + '/' + expb + ')';
	            number[i] = a / b;
	            if (pointsGame(n - 1))
	                return true;
            }

            if (a != 0) {
	            result[i] = '(' + expb + '/' + expa + ')';
	            number[i] = b / a;
	            if (pointsGame(n - 1))
	                return true;
            }

            number[i] = a;
            number[j] = b;
            result[i] = expa;
            result[j] = expb;
        }
    }
    return false;
}

int main() {
    int x;
    for (int i = 0; i < cardsNumber; i ++) {
        char buffer[20];
        cout << "the " << i <<"th number:";
        cin >> x;
        number[i] = x;
        //itoa(x, buffer, 10);
        //不知道itoa应该引用什么头文件
        //自己实现itoa从数字到string
        int t = x;
        int bi = 0;
        if (x < 0) {
            buffer[bi ++] = '-';
            x = -x;
        }
        while (t != 0) {
            buffer[bi ++] = '0' + (t % 10);
            t = t / 10;
        }
        buffer[bi] = '\0';
        result[i] = buffer;
    }
    if (pointsGame(cardsNumber)) {
        cout << "Success." << endl;
    } else {
        cout << "Fail." << endl;
    }
}
