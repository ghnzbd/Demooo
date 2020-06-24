import java.util.Arrays;

/**
 * @author CBeann
 * @create 2020-02-20 2:49
 */
public class Start {

    public static void main(String[] args) throws Exception {

        final String TEAM_EMAIL = "huangmengyan@corp.netease.com,ybjiang@corp.netease.com,liusanchuan@corp.netease.com,wanglingcong@corp.netease.com,wangruifeng01@corp.netease.com,luzhichun@corp.netease.com,chairongdian@corp.netease.com";


        System.out.println(TEAM_EMAIL);

        String[] split = TEAM_EMAIL.split(",");

        Arrays.stream(split).forEach(email -> {
            System.out.println(email);
        });




    }
}
