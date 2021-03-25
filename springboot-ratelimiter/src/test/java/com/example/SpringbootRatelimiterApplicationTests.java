package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootRatelimiterApplication.class) // 制定SpinrgBoot的启动类
@WebAppConfiguration
class SpringbootRatelimiterApplicationTests {


    @Test
    void demo1() {

        System.out.println(longestValidParentheses(")()()"));


    }





    //最长有效括号匹配
    public int longestValidParentheses(String s) {

        int res = 0;


        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                dp[i] = 0;
            } else {

                if (i > 0) {

                    if (chars[i - 1] == '(') {
                        int before = ((i - 2 >= 0) ? dp[i - 2] : 0);
                        dp[i] = 2 + before;
                    } else {
                        if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                            dp[i] = dp[i - 1] + 2;



                        } else {
                            dp[i] = 0;
                        }


                    }


                }


            }
            res = Math.max(res,dp[i]);
        }


        return res;

    }
}

