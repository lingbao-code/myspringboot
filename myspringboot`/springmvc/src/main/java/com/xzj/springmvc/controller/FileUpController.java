package com.xzj.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/fileup")
public class FileUpController {

    @PostMapping("/form")
    @ResponseBody
    public String handleFileup(String name, MultipartFile file){
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            System.out.println(file.getSize());
            System.out.println(fileName );
            //file.transferTo();
            try {
                //InputStream is = file.getInputStream();
                //File destFile = new File(fileName);
                //file.transferTo(destFile);
                String upPath = "C:/uploadfile";

                /*if(!destFile.exists()){
                    destFile.mkdirs();
                }*/
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss_");
                String _fileName = sdf.format(new Date())+fileName;
                //File dFile = new File(destFile, currentDate+fileName);
                File destFile = new File(upPath+_fileName);
                //file.transferTo(dFile);
                byte[] bytes = file.getBytes();
                Path path = Paths.get(upPath,_fileName);
                Files.write(path, bytes);
                System.out.println("上传成功");
                return "success";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "failure";
    }

    @PostMapping("/form_multi")
    @ResponseBody
    public String handleFileupMultiFile(@RequestParam(required = false,value = "files") MultipartFile[] multipartFiles){
        System.out.println(multipartFiles);
        System.out.println(multipartFiles.length);
        String uploadPath="C:/uploadfile/";
        for (MultipartFile mf:
               multipartFiles) {
            /*String filename = mf.getOriginalFilename();
            String upPath = "C:/uploadfile";
            File file = new File(upPath+filename);*/
            System.out.println(mf.getOriginalFilename());
            String fileName = mf.getOriginalFilename();
            try {
                //File destFile = new File(uploadPath);
                String newFileName = (new SimpleDateFormat("yyyyMMdd_hhmmss_")).format(new Date()) + fileName;

                //File dfile = new File(destFile, newFileName);
                //mf.transferTo(dfile);
                byte[] byteContent = mf.getBytes();//获取文件字节数组
                Path path = Paths.get(uploadPath, newFileName);
                //mf.transferTo(file);
                Files.write(path, byteContent);
                System.out.println("上传成功");

                //return "上传成功";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "success";

    }
}
