package com.bakigoal.mvc.controller;

import com.bakigoal.mvc.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileHandler(@RequestParam("name") String name,
                                    @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                FileUtil.upload(name, file);
                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultipleFileHandler(@RequestParam("name") String[] names,
                                            @RequestParam("file") MultipartFile[] files) {
        if (files.length != names.length) {
            return "Mandatory information missing";
        }
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                FileUtil.upload(name, file);
                message.append("You successfully uploaded file=").append(name).append("; ");
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return message.toString();
    }
}
