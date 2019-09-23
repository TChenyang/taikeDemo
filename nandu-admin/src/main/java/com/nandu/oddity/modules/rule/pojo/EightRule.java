package com.nandu.oddity.modules.rule.pojo;

import org.jeasy.rules.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Rule(name = "被8整除")
public class EightRule {

    private final Logger logger = LoggerFactory.getLogger(ThreeRule.class);

    @Condition
    public boolean isEight(@Fact("number") int number){
        return number % 8 == 0;
    }

    @Action
    public void eightAction(@Fact("number") int number){
        logger.info(number + " is eight");
    }

    @Priority
    public int getPriority(){
        return 2;
    }

}
