package com.nandu.oddity.modules.rule.pojo;

import org.jeasy.rules.support.UnitRuleGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreeEightRuleUnitGroup extends UnitRuleGroup {

    private final Logger logger = LoggerFactory.getLogger(ThreeRule.class);

    public ThreeEightRuleUnitGroup(Object... rules){
        for (Object rule:rules){
            addRule(rule);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }

}
