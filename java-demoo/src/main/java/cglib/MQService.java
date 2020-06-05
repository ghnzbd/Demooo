package cglib;


public class MQService {

    @MyAsyncInterface
    public void setMessage(String messgae) {

        System.out.println("开始发送MQmessage--------->睡3秒");

        try {
            //Thread.sleep(1000 * 3);
        } catch (Exception e) {

        }
        System.out.println("结束发送MQmessage<-------------");

    }

    public void setMessage2(String messgae) {

        System.out.println("开始发送MQmessage--------->睡3秒");

        try {
            Thread.sleep(1000 * 3);
        } catch (Exception e) {

        }
        System.out.println("结束发送MQmessage<-------------");

    }
}