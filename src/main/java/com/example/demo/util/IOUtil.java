package com.example.demo.util;

import java.io.*;

/**
 * I/O流操作
 */
public class IOUtil {
    /**
     * 字节流
     * 文件内容追加
     * @param append 要追加的内容
     * @param filePath 被追加文件的路径
     */
    public static void appendFile(String append, String filePath){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try{
            //1.将文件的内容输出成字符串
            fos = new FileOutputStream(filePath, true);
            //2.将字符串 转换成 字节数组
            byte[] words = append.getBytes();
            //3.写入文件
            fos.write(words,0,words.length);
            System.out.println("文件已被追加：");
            //4.将文件输入到程序
            fis = new FileInputStream(filePath);
            //5.文件打印输出到控制台
            byte[] bytes = new byte[1024];
            int ch;
            System.out.println("文件输出：");
            while ((ch = fis.read(bytes)) != -1){
                for (int i = 0; i < ch; i++){
                    System.out.println((char) bytes[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符流
     * 文件内容追加
     * @param content 追加的内容
     * @param filePath 被追加文件
     */
    public static void appendFile1(String content, String filePath){
        FileWriter fw = null;
        FileReader fr = null;
        try {
            //1.输出字符到txt文件中
            //加上true表示追加
            fw = new FileWriter(filePath,true);
            //2.直接写入字符
            fw.write(content);
            System.out.println("文件已被更新：");
            //再输入txt中的字符，并在控制台输出
            fr = new FileReader(filePath);
//          一个字节一个字节读的方法
//			int ch;
//			while((ch = fr.read()) !=-1){
//				System.out.println((char)ch);
//			}
            //存到数组里读的方法
            //ch表示读了多少字节，如果文件内容为空，则为-1
            //一次读1024
            System.out.println("文件输出：");
            //使用StringBuffer将字符缓存
            StringBuffer s=new StringBuffer();
            char[] ch =new char[1024];
            int len = -1;
            while((len = fr.read(ch)) != -1){
                s.append(ch); //append方法追加字符
            }
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 缓冲流
     * 文件内容追加
     * @param content 追加的内容
     * @param filePath 被追加文件
     */
    public static void appendFile2(String content, String content1, String filePath){
        BufferedWriter bw = null;
        FileWriter fw = null;
        Reader reader = null;
        BufferedReader br = null;
        try {
            //输出字符到txt文件中
            fw=new FileWriter(filePath,true);
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();//空行指令
            bw.write(content1);
            bw.newLine();
            bw.flush();//清空缓存
            System.out.println("文件已被更新！");
            //再输入txt中的字符，并在控制台输出
            reader = new FileReader(filePath);
            br = new BufferedReader(reader);
            //BufferedReader可以一行一行的读
            System.out.println("文件输出：");
            String line = null;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读写二进制流
     * 图片复制
     * @param sourceFile
     * @param targetFile
     */
    public static void copyPhoto(String sourceFile, String targetFile){
//输入流
        FileInputStream fis = null;
        DataInputStream dis = null;
        //输出流
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fis = new FileInputStream(sourceFile);
            dis = new DataInputStream(fis);
            fos = new FileOutputStream(targetFile);
            dos = new DataOutputStream(fos);
            int data;
            while((data = dis.read()) !=-1){
                dos.write(data);
            }
            System.out.println("复制成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                dos.close();
                fos.close();
                dis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        String filePath = "E:/1aydhyj/util/test.txt";
        String filePath1 = "E:/1aydhyj/util/test1.txt";
        String sourceFile = "E:/1aydhyj/util/q6.jpg";
        String targetFile = "E:/1aydhyj/util/xw.jpg";
        String content = "i like u";
        String content1 = "not pro";

        appendFile(content, filePath);

        appendFile1(content1,filePath);

        appendFile2(content,content1,filePath1);

        copyPhoto(sourceFile,targetFile);
    }

}
