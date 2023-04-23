package com.zh.code.business.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.holder.ReadRowHolder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zh.code.business.exception.BusinessException;
import com.zh.code.common.CommonConstant;
import com.zh.code.dao.ZUserMapper;
import com.zh.code.dto.ZUserImportForm;
import com.zh.code.entity.ZUser;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Date: 2023/4/12 10:46
 * @Author: Zhanghuihui
 * @Description:
 */
public class ZUserListener extends AnalysisEventListener<ZUserImportForm> {


    private final List<ZUser> userList = new ArrayList<>();
    private final List<ZUserImportForm> formList = new ArrayList<>();
    public StringBuilder errorMsg = new StringBuilder();
    private ZUserMapper userMapper;
    public Integer errCount = 0;
    private Integer batchInsert=10;
    public ZUserListener(ZUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        // 校验表头
        String[] headValue = {"用户名", "密码", "电子邮件", "性别", "年龄", "省份", "城市", "区/县", "详细地址", "电话号码"};
        for (int i = 0; i < headValue.length; i++) {
            String head = headMap.get(i);
            if (!headValue[i].equals(head)) {
                throw new BusinessException(-1, CommonConstant.ERROR_HEAD_VALUE);
            }
        }
    }

    @Override
    public void invoke(ZUserImportForm zUserImportForm, AnalysisContext analysisContext) {
        formList.add(zUserImportForm);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        ReadRowHolder rowHolder = context.readRowHolder();
        Integer rowIndex = rowHolder.getRowIndex();
        //校验数据后入库
        //1必填：用户名密码不能为空
        //2唯一：用户名
        if (formList.size() > 0) {
            for (ZUserImportForm form : formList) {
                String username = form.getUsername();
                String password = form.getPassword();
                if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                    errorMsg.append("第").append(rowIndex).append("行").append("用户名或密码为空");
                    errCount++;
                    continue;
                }
                if (!StringUtils.isEmpty(username)) {
                    QueryWrapper<ZUser> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("username", username);
                    ZUser zUser = userMapper.selectOne(queryWrapper);
                    if (!Objects.isNull(zUser)) {
                        errorMsg.append("第").append(rowIndex).append("行").append("用户名与数据库重复");
                        errCount++;
                        continue;
                    }
                }
                ZUser zUser = new ZUser();
                BeanUtils.copyProperties(form, zUser);
                userList.add(zUser);
            }
            saveDataList(userList);
        }

    }

    private void saveDataList(List<ZUser> userList){
        for (ZUser zUser : userList) {
            zUser.getPassword();
            userMapper.insert(zUser);
        }
//        userMapper.insertBatchSomeColumn (userList);
    }
}
