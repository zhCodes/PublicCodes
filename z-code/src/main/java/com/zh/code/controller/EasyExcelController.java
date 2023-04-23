package com.zh.code.controller;

import com.alibaba.excel.EasyExcel;
import com.zh.code.business.exception.BusinessException;
import com.zh.code.business.listener.ZUserListener;
import com.zh.code.config.Response;
import com.zh.code.dao.ZUserMapper;
import com.zh.code.dto.ZUserImportForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Date: 2023/4/12 13:47
 * @Author: Zhanghuihui
 * @Description: excel处理
 */
@Api(tags = "excel导入导出")
@RestController
@RequestMapping("/easy-excel")
public class EasyExcelController {
    @Autowired
    private ZUserMapper userMapper;

    @ApiOperation(value = "excel导入")
    @PostMapping("import-excel")
    public Response importExcel(@RequestParam MultipartFile file) {

        if (file != null && file.getOriginalFilename().toLowerCase().endsWith("xlsx")) {
            try {
                EasyExcel.read(file.getInputStream(), ZUserImportForm.class, new ZUserListener(userMapper)).sheet().doRead();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new BusinessException(-1, "模板错误格式不是XLSX");
        }
        return Response.success("成功");
    }
}
