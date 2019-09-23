package com.nandu.oddity.common;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

import java.util.HashMap;
import java.util.Map;

public class RuleLauncher {

    public static Map<String,Object> getRules(){

        /**
         * 创建规则执行引擎
         * 注意: skipOnFirstAppliedRule意思是，只要匹配到第一条规则就跳过后面规则匹配
         */
        Map<String,Object> map = new HashMap<>();
        RulesEngineParameters parameters = new
                RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);
        //创建规则
        Rules rules = new Rules();
        Facts facts = new Facts();

        map.put("rules",rules);
        map.put("facts",facts);
        map.put("rulesEngine",rulesEngine);

        return map;

    }


}













