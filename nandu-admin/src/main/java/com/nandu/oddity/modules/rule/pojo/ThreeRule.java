package com.nandu.oddity.modules.rule.pojo;

import org.jeasy.rules.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Rule(name = "被三整除",description = "number如果被三整除,打印: number is three")
public class ThreeRule {

    private final Logger logger = LoggerFactory.getLogger(ThreeRule.class);

    @Condition //条件判断注解:如果return true,执行 Action
    public boolean isTree(
            @Fact("number") int number){
        return number % 3 == 0;
    }

    @Action //执行方法注解
    public void threeAction(
            @Fact("number") int number){
        logger.info(number + "is three"); // 整型加字符串 = 字符串
    }

    @Priority //优先级: return数值越小,优先级越高
    public int getPriority(){
        return 1;
    }

}
