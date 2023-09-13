package com.zh.publiccode.controller;

import com.zh.publiccode.config.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Date: 2023/4/11 15:23
 * @Author: Zhanghuihui
 * @Description:
 */
@RestController
@Api(tags = "上传接口")
@RequestMapping("/uploadDir")
@CrossOrigin
public class UploadFileController {

    @Value("${uploadPath}")
    private String uploadPath;

    @PostMapping(value = "/uploadFiles", name = "上传文件夹")
    @ApiOperation(value = "上传文件夹")
    public Response<Object> upload(@RequestParam("folder") final MultipartFile[] file) {

        try {
            for (MultipartFile multipartFile : file) {
                String filename = multipartFile.getOriginalFilename();
                System.out.println("uploadPath:"+uploadPath);
                System.out.printf(filename);
                String dirPath = filename.substring(0, filename.lastIndexOf("/"));
                File fileDir = new File(uploadPath + dirPath);
                fileDir.mkdirs();
                File fileData = new File(uploadPath + filename);
                multipartFile.transferTo(fileData);
                return Response.success("上传成功");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}




