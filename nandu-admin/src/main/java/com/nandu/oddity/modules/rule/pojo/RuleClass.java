package com.nandu.oddity.modules.rule.pojo;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.support.UnitRuleGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RuleClass {

    private static final Logger logger = LoggerFactory.getLogger(RuleClass.class);

    @Rule(priority = 1)
    public static class FizzRule{

        @Condition
        public boolean isFizz(@Fact("number") Integer number){
            return number % 5 == 0;
        }

        @Action
        public void printFizz(){
            logger.info("fizz");
        }

    }

    @Rule(priority = 2)
    public static class BuzzRule{

        @Condition
        public boolean isBuzz(@Fact("number") Integer number){
            return number % 7 == 0;
        }

        @Action
        public void printBuzz(){
            logger.info("buzz");
        }
    }

    public static class FizzBuzzRule extends UnitRuleGroup {

        public FizzBuzzRule(Object... rules) {
            for (Object rule : rules) {
                addRule(rule);
            }
        }

        @Override
        public int getPriority() {
            return 0;
        }
    }


    @Rule(priority = 3)
    public static class NonFizzBuzzRule {

        @Condition
        public boolean isNotFizzNorBuzz(@Fact("number") Integer number) {
            // can return true, because this is the latest rule to trigger according to
            // assigned priorities
            // and in which case, the number is not fizz nor buzz
            return number % 5 != 0 || number % 7 != 0;
        }

        @Action
        public void printInput(@Fact("number") Integer number) {
            System.out.print(number);
        }
    }

}
