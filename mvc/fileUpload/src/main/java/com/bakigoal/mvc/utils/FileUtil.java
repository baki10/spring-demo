package com.bakigoal.mvc.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {

    public static void upload(String name, MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();

        // Creating the directory to store file
        File dir = new File("uploads" + File.separator + "tmpFiles");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Create the file on server
        File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        System.out.println("Server File Location=" + serverFile.getAbsolutePath());
    }
}
