package com.zwh.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 打印菜单 - 选择功能
 */
public class SmallChangeSys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //创建Oop的对象
        Oop oop = new Oop();

        //循环打印菜单
        while(oop.flag){

            //打印菜单
            oop.mainMenu();

            //定义变量接收用户选择
            int selection = sc.nextInt();

            //利用switch语句查看用户选择
            switch(selection){
                case 1:
                    oop.detail();
                    break;

                case 2:
                    oop.income();
                    break;

                case 3:
                    oop.pay();
                    break;

                case 4:
                    oop.exit();
                    break;

                default:
                    System.out.println("当前没有这个功能呦，请重新输入!");
                    break;
            }
        }
    }
}
