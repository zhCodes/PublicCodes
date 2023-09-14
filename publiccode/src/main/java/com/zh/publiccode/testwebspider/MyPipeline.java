package com.zh.publiccode.testwebspider;


import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description 结果处理
 */
public class MyPipeline implements Pipeline {


    @Override
    public void process(ResultItems resultItems, Task task) {
        // TODO 入库
        String title = resultItems.get("title").toString();
        // System.out.println(title);
        List<String> contents = resultItems.get("contents");

        for (String content : contents) {
            System.out.println(content);
        }

    }
}
