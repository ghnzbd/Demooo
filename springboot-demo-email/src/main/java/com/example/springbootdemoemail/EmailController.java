package com.example.springbootdemoemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;


@Controller
public class EmailController {

    int count = 1;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/email")
    @ResponseBody
    public String sendEmail(HttpServletRequest request) {
        System.out.println(request.getRequestURI());

        InputStream is = null;
        try {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1; ) {
                sb.append(new String(b, 0, n));
            }
            System.out.println("----------------------->");
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 发送邮件
        //emailService.sendSimpleMail("2568230656@qq.com", "cbeann@163.com", "主题：合并分支邮件", "gitlab合并分支触发钩子程序");

        return "success";
    }


    @PostMapping("/msg")
    @ResponseBody
    public String sendMsg(@RequestBody WHRoot whRoot) {


        final String MERGE_STATUS = "can_be_merged";
        final String TARGET_BRANCH = "master";
        final String STATUS = "merged";
        LocalDateTime now = LocalDateTime.now();

        System.out.println("-----------开始------------------>" + now);
        //System.out.println(whRoot);

        try {
            //获取项目名称
            String projectName = whRoot.getProject().getName();
            //获取merge请求的状态
            String merge_status = whRoot.getObject_attributes().getMerge_status();
            String state = whRoot.getObject_attributes().getState();
            //获取source分支和获取target分支
            String target_branch = whRoot.getObject_attributes().getTarget_branch();
            String source_branch = whRoot.getObject_attributes().getSource_branch();
            //获取操作用户邮箱
            String user_email = whRoot.getObject_attributes().getLast_commit().getAuthor().getEmail();

            if (null != merge_status && MERGE_STATUS.equals(merge_status)
                    && null != state && STATUS.equals(state)
                    && TARGET_BRANCH.equals(target_branch)) {

                System.out.println("--------------->发邮件");
                System.out.println("projectName：" + projectName);
                System.out.println("target_branch：" + target_branch);
                System.out.println("source_branch：" + source_branch);
                System.out.println("user_email" + user_email);
            } else {
                System.out.println("--------------->啥都不做");
                System.out.println("target_branch：" + target_branch);
                System.out.println("source_branch" + source_branch);
                System.out.println("user_email" + user_email);


            }

        } catch (Exception e) {

            System.out.println("出错了。。。。。。。。。。。。。。");

        }


        System.out.println("-----------结束------------------>" + count++);
        return "success";
    }

}