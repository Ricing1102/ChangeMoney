package com.zwh.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 完成零钱通的各个功能
 * 把功能分别封装成方法
 */
public class Oop {

    //  创建Scanner类的对象
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat();

    //控制循环结束
    boolean flag = true;

    //利用字符串拼接保存数据
    String detail = "=================零钱通明细=================";

    //定义保存余额的变量 和 变化的量
    double balance = 0;
    double money;

    //定义保存日期的变量
    Date date = null;

    //保存消费原因
    String note = "";

    //显示菜单
    public void mainMenu(){
        System.out.println("------------零钱通菜单------------");
        System.out.println("\t\t" + "1 零钱明细");
        System.out.println("\t\t" + "2 收益入账");
        System.out.println("\t\t" + "3 消费情况");
        System.out.println("\t\t" + "4 退出系统");
        System.out.println("请选择功能(1 - 4): ");
    }


    //零钱明细
    public void detail(){
        System.out.println(detail);
    }

    //入账情况
    public void income(){
        System.out.println("请输入收益入账:");
        money = sc.nextDouble();

        //判断收入是否合理
        if(money <= 0){
            System.out.println("收益入账金额应该 >= 0");
            return; //退出方法
        }

        balance += money;

        //获取当前日期
        date = new Date();

        //将金额与日期拼接到detail字符串中
        detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" +balance;
    }

    //消费情况
    public void pay() {
        System.out.println("请输入消费金额:");
        money = sc.nextInt();

        //判断消费金额是否合理
        if (money > balance || money <= 0) {
            System.out.println("你的消费金额应该在 0-" + balance);
            return;
        }

        //请输入具体的消费说明
        System.out.println("输入消费说明:");
        note = sc.next();

        //获取消费时间
        date = new Date();

        //余额统计
        balance -= money;

        //拼接消费信息
        detail += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;

        }

        //退出系统
        public void exit(){
            String res = "";
            boolean loop = true;
            while(loop){
                System.out.println("是否确定退出系统？Y/N(不区分大小写)");
                res = sc.next();
                if(res.equals("Y") || res.equals("y") || res.equals("N") || res.equals("n")){
                    loop = false;
                }
            }

            //将判断的部分独立出来
            if(res.equals("Y") || res.equals("y")){
                System.out.println("系统退出,欢迎下次使用...");
                flag = false;
            }else{
                System.out.println("系统退出取消");
            }

        }

    }
