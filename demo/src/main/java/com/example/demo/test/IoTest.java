package com.example.demo.test;

import java.io.FileReader;
import java.io.FileWriter;

public class IoTest {

    public static void main(String[] args) {
        //字符流读取
        String path="D:\\test\\test.txt";
        try {
//            FileReader r = new FileReader(path);

            //方式一：读取单个字符的方式
            //每读取一次，向下移动一个字符单位，返回读取的字节数
//            int temp1 = r.read();
//            System.out.println((char)temp1);
//            int temp2 = r.read();
//            System.out.println((char)temp2);

//            while (true) {
//                int temp = r.read();
//                if (temp == -1) {
//                    break;
//                }
//                System.out.print((char)temp);
//            }


//        //FileWriter  字符流的写入
//            FileWriter w = null;
//            //以path为路径创建一个新的FileWriter对象
//            //如果需要追加数据，而不是覆盖，则使用FileWriter（path，true）构造方法
//            w = new FileWriter(path);
//            //将字符串写入到流中，\r\n表示换行想有好的
//            w.write("Nerxious is a good boy\r\n");
//            //如果想马上看到写入效果，则需要调用w.flush()方法
//            w.flush();

            int data[][] = new int[][] {
                    {1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
            //如果在进行输出的时候一定要使用双重循环，
            //外部的循环控制输出的行数，而内部的循环控制输出列数
            for(int i = 0; i < data.length; i++) {
                for(int j = 0; j < data[i].length; j++) {
                    System.out.print("data[" + i + "][" + j + "]=" + data[i][j] + "、");
                }
                System.out.println();
            }










        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
