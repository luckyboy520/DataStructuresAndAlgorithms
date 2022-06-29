package com.luckyboy.sun.MP4;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * TOOD
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-3-5-0005 21:51:58
 */
public class M3u8Util {
    /**
     * 根目录
     * @param root
     */
    public static void findFile(File root) throws IOException {
        if(root.exists()){
            if(root.isDirectory()){
                File[] categorys=root.listFiles();
                for(File cate: categorys){
                    if(rename(cate)){
                        MergeVideos.MergeVideos(cate,cate.getName()+".ts");
                    }
                }
            }else{
                System.out.println("file name: "+root.getName());
            }
        }
    }

    /**
     * 将0 改成00或者 000
     * @param cat
     */
    public static boolean rename(File cat) {
        if (cat.exists()) {
            if (cat.isDirectory()) {
                File[] files = cat.listFiles();
                int len = String.valueOf(files.length).length();
                String file0 = files[0].getName();
                String pre = file0.substring(0, file0.length() - 1);
                Integer max = pre.length() + len;
                Arrays.stream(files)
                        .filter(temp -> max - temp.getName().length() > 0)
                        .forEach(item -> {
                            int fill = max - item.getName().length();
                            String name = "";
                            for (int i = 0; i < fill; i++) {
                                name += 0;
                            }
                            String n = item.getAbsolutePath().replace(pre, pre + name);
                            item.renameTo(new File(n));
                        });
                return true;
            } else {
                System.out.println("file name: " + cat.getName());
            }
        }
        return false;
    }
}
