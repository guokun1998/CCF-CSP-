/*
试题编号：	201312-3
试题名称：	最大的矩形
时间限制：	1.0s
内存限制：	256.0MB
问题描述：	
问题描述
　　在横轴上放了n个相邻的矩形，每个矩形的宽度是1，而第i（1 ≤ i ≤ n）个矩形的高度是hi。这n个矩形构成了一个直方图。例如，下图中六个矩形的高度就分别是3, 1, 6, 5, 2, 3。



　　请找出能放在给定直方图里面积最大的矩形，它的边要与坐标轴平行。对于上面给出的例子，最大矩形如下图所示的阴影部分，面积是10。

输入格式
　　第一行包含一个整数n，即矩形的数量(1 ≤ n ≤ 1000)。
　　第二行包含n 个整数h1, h2, … , hn，相邻的数之间由空格分隔。(1 ≤ hi ≤ 10000)。hi是第i个矩形的高度。
输出格式
　　输出一行，包含一个整数，即给定直方图内的最大矩形的面积。
样例输入
6
3 1 6 5 2 3
样例输出
10
*/
public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int number = 0;
        int nowArea = 0;
        int maxArea = 0;
        int maxHeight = 0;
        //寻找最高的
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxHeight){
                maxHeight = arr[i];
            }
        }
        //算出每个高度的最大面积再和整个最大面积比较
        for (int height = 1; height <= maxHeight; height++) {
            //对于第height高度来讲
            for (int i = 0; i < n; i++) {
                if (arr[i] >= height){
                    number++;
                }
                else {
                    if (number*height > nowArea){
                        nowArea = number*height;

                    }
                    number = 0;
                }
                if (i == n-1){
                    if (number*height > nowArea){
                        nowArea = number*height;
                        number = 0;
                    }
                }
            }
            if (nowArea > maxArea){
                maxArea = nowArea;
            }
            number = 0;
            nowArea = 0;
        }
        System.out.println(maxArea);
    }
}
