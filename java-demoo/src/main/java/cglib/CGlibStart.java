package cglib;


public class CGlibStart {
    public static void main(String[] args) {

//        MQService mqService = new MQService();
//        mqService.setMessage("123123");

        CGlibProxy cGlibProxy = new CGlibProxy();
        MQService proxy = (MQService) cGlibProxy.getProxy(MQService.class);
        proxy.setMessage("123");
        System.out.println("-----------------------");


//        执行结果
//        -----------------------             System.out.println("-----------------------");
//        开始发送MQmessage--------->睡3秒     proxy.setMessage("123");
//        结束发送MQmessage<-------------
    }
}
