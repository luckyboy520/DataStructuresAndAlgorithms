package com.luckyboy.sun.MP4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TOOD
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-3-5-0005 22:24:28
 */
public class M3u8ToMP4 {

    public static void main(String[] args) throws IOException {
        File file = new File("d:\\good\\no");
        File[] files = file.listFiles();// 文件夹
        for(File file1 : files) {
            if(file1.isDirectory()){
                one(file1.getPath(),file1.getName());
            }
        }

    }

    public static void one (String property, String name2) throws IOException {

        File file = new File(property);// 文件夹
        String runFilePath = property + "\\new.bat";
        File runFile = new File(runFilePath);// 生成的可执行文件
        runFile.createNewFile();
        FileWriter fw = null;

        try {
            fw = new FileWriter(runFile);
            fw.append("copy /b ");
            fw.flush();
            if (file.exists()) {// 1.判断文件是否存在
                if (file.isDirectory()) {// 2.判断是否为文件夹
                    File[] listFiles = file.listFiles();
                    List<String> sortList = new ArrayList<>();
                    for (File file2 : listFiles) {
                        String ii = "^\\d+$";
                        Pattern pat = Pattern.compile(ii);
                        Matcher mat = pat.matcher(file2.getName());
                        if (!mat.find()) {
                            continue;
                        }
                        if (file2.isDirectory()) {
                            continue;
                        }
                        if (file2.getName().startsWith("config")) {
                            continue;
                        }
                        if (file2.getName().length() == 32) {
                            continue;
                        }
                        String name = file2.getName();// 获取名字
                        if (!(name.endsWith(".class") || name.endsWith(".bat")))
                            sortList.add(name);
                    }
                    //4.排序
                    sortList.sort((o1, o2) -> {
                        String split1 = o1.split("\\.")[0];
                        String split2 = o2.split("\\.")[0];
                        int parseInt1;
                        int parseInt2;
                        try {
                            parseInt1 = Integer.parseInt(split1);
                            parseInt2 = Integer.parseInt(split2);
                        } catch (NumberFormatException e) {//如果是非数字，按照原来的顺序
                            return 0;
                        }
                        if (parseInt1 > parseInt2) {
                            return 1;
                        } else {
                            return -1;
                        }
                    });
                    int size = sortList.size();
                    for (int i = 0; i < size; i++) {
                        System.out.println(sortList.get(i));
                        if (i == size - 1) {
                            fw.append(sortList.get(i));
                            break;
                        }
                        fw.append(sortList.get(i) + "+");
                        fw.flush();
                    }
                    fw.append(" " + (int)((Math.random()*9+1)*1000) + ".mp4");
                    fw.flush();
                    fw.close();
                }
            }
            String one = null;
            fw.write(one);
            callCmd(runFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                fw.close();
            }
        }}

    private static void callCmd(String locationCmd) {
        StringBuilder sb = new StringBuilder();
        InputStream in = null;
        BufferedReader bufferedReader = null;
        try {
            Process child = Runtime.getRuntime().exec(locationCmd);
            in = child.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String substring = line.substring(line.indexOf(">") + 1, line.length());
                sb.append(substring);
            }
            bufferedReader.close();
            in.close();
            try {
                child.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("sb:" + sb.toString());
            System.out.println("callCmd execute finished");
            //执行完成后，将执行文件删除。
            File file = new File(locationCmd);
            file.delete();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                //将流关闭，从小往大关,防止流未关闭占用内存
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
    }

}
