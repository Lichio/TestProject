package org.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by LiChaojie on 2016/3/11.
 */
public class PathTest {
    public static void main(String[] args)throws  Exception{
        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量：" + path.getNameCount());
        System.out.println("path的根路径： " + path.getRoot());

        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);

    }
}
