/*
 *  这里友好的意思是：(假设保存小数点后两位)
 *      1,  1.2345  ---  1.23
 *      2,  0.1234  ---  1.23E-1
 *      3,  999999  ---  1.00E6
 *      4,  555555  ---  5.56E5
 *      5, -555555  --- -5.56E5
 *      6, -0.0001  --- -1.00E-4
 */

//代码如下：
//numAfterDot代表小数点后数字位数
//n代表输入的双精度浮点数
public static String DoubleToString(int numAfterDot, double n)
{
    char[] cs = new char[numAfterDot + 2];
    int ENum = 0;
    double num = Math.Abs(n);
    double small = 1;
    if (num > 10)
    {
        while (num > 10)
        {
            ENum++;
            num = num / 10;
            small *= 10;
        }
    }
    else if (num < 1)
    {
        while (num < 1)
        {
            ENum--;
            num = num * 10;
            small /= 10;
        }
    
    }
    int csIndex = 0;
    cs[csIndex++] = (char)((int)num + '0');
    cs[csIndex++] = '.';
    while (csIndex < cs.Length)
    {
        num = num * 10;
        cs[csIndex++] = (char)(((int)num % 10) + '0');
        small /= 10;
    }
    if ((int)((num * 10) % 10) > 4)
    {
        return (n >= 0 ? "" : "-") + DoubleToString(numAfterDot, Math.Abs(n) + (small / 2));
    }
    if (ENum == 0)
    {
        return (n >= 0 ? "" : "-") + new String(cs);
    }
    else
    {
        return (n >= 0 ? "" : "-") + new String(cs) + "E" + ENum;
    }
}
