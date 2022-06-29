package com.luckyboy.sun.MP4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TOOD
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-3-5-0005 21:50:58
 */
public class MergeVideos {
    /**
     * source为源地址，destination为合并之后的文件地址，videoName为合并后视频的名字，num为视频数量
     * @param source
     * @param destination
     * @throws IOException
     */
    public static void MergeVideos(File source, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        FileInputStream in = null;
        File[] files = source.listFiles();
        for(File file: files){
            in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = in.read(bytes)) > 0){
                out.write(bytes,0,len);
            }
        }
        in.close();
        out.close();
    }

}
