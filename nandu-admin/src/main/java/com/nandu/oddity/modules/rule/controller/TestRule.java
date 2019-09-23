package com.nandu.oddity.modules.rule.controller;

import com.nandu.oddity.common.RuleLauncher;
import com.nandu.oddity.modules.rule.pojo.RuleClass;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TestRule {

    private static final Logger logger = LoggerFactory.getLogger(TestRule.class);

    public static void main(String[] args){

        Map<String,Object> rulesMap = RuleLauncher.getRules();

        Rules rules = (Rules)rulesMap.get("rules");
        Facts facts = (Facts)rulesMap.get("facts");
        RulesEngine rulesEngine = (RulesEngine)rulesMap.get("rulesEngine");

        rules.register(new RuleClass.FizzRule());
        rules.register(new RuleClass.BuzzRule());
        rules.register(new RuleClass.NonFizzBuzzRule());
        rules.register(new RuleClass.FizzBuzzRule(new RuleClass.FizzRule(), new RuleClass.BuzzRule()));

        for (int i = 0 ; i < 100 ; i ++){
            facts.put("number",i);
            rulesEngine.fire(rules,facts);
            System.out.println();
        }

    }

}
