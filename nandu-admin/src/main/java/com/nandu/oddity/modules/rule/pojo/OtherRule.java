package com.nandu.oddity.modules.rule.pojo;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherRule {

    private final Logger logger = LoggerFactory.getLogger(ThreeRule.class);

    @Condition
    public boolean isOther(@Fact("number") int number){
        return number % 3 != 0 || number % 8 != 0;
    }

    @Action
    public void printSelf(@Fact("number") int number){
        logger.info(String.valueOf(number));
    }

    @Priority
    public int getPriority(){
        return 3;
    }

}
