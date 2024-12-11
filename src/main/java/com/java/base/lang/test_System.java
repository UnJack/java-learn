package com.java.base.lang;

/**
 * User: jimjian
 * Date: 16-7-20 上午11:34
 */
public class test_System {

    public static void main(String[] args) {
        try {
            System.out.println("try...");
            //非0的状态码表示异常终止,System.exit(status),status不管值为多少都会退出
            //System.exit(0);是将你的整个虚拟机里的内容都停掉了
            //return是回到上一层,而System.exit(status)是回到最上层
            System.exit(0);
//            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally...");
        }
    }
}
