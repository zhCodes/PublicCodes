package com.zh.code.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Date: 2023/4/23 20:00
 * @Author: Zhanghuihui
 * @Description: 直连交换机  配置
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue ZDirectQueue() {
        // durable true持久化
        // exclusive 只能被当前创建的连接使用
        // autoDelete 自动删除 没有生产者消费者使用时队列自动删除
        return new Queue("DirectQueue",true,false,false);

    }

    DirectExchange ZDirectExchange(){

        return new DirectExchange("ZDirectExchange",true,false);
    }

    //队列绑定交换机 匹配键：ZDirectRouting
    Binding bindingDirect(){
        return BindingBuilder.bind(ZDirectQueue()).to(ZDirectExchange()).with("ZDirectRouting");
    }

    @Bean
    DirectExchange lonelyDirectExchange(){
        return new DirectExchange("lonelyDirectExchange");
    }








}
