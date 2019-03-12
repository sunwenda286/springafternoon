package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("addBanner")
    public void addBanner(Banner b, @RequestParam(value="addFile", required=false) MultipartFile addFile, HttpServletRequest request) throws IllegalStateException, IOException {
        //System.out.println("addBanner");
        //System.out.println(b);
        b.setId(UUID.randomUUID().toString().replace("-", ""));

        String realPath = request.getServletContext().getRealPath("/pic");
        String name = addFile.getOriginalFilename();
        String contentType=addFile.getContentType();
        try {
            addFile.transferTo(new File(realPath+"\\"+name));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        b.setPicPath("pic/"+name);

        System.out.println("***"+b);
        bannerService.addBanner(b);


    }
    @RequestMapping("/download")
    public void downloadChapter(HttpServletRequest request, String url, HttpServletResponse response) throws IOException{
        //根据文件名，到文件储存位置加载到一个文件
        String realPath = request.getSession().getServletContext().getRealPath("/pic");
        File file = new File(realPath+"/"+"2.jpg");
        byte[] bs= FileUtils.readFileToByteArray(file);
        response.setHeader("content-disposition", "attachment;filename="+"2.jpg");
        ServletOutputStream out=response.getOutputStream();
        out.write(bs);
        out.flush();
    }
}
