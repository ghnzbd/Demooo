//package lockdemo;
//
//import org.I0Itec.zkclient.IZkChildListener;
//import org.I0Itec.zkclient.IZkDataListener;
//import org.I0Itec.zkclient.ZkClient;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author CBeann
// * @create 2020-03-13 11:20
// */
//public class ZookeeperLock {
//
//    private String path;
//
//    private ZkClient zkClient;
//
//    //连接zk服务器
//    public ZookeeperLock(String url, String path) {
//
//        zkClient = new ZkClient("39.105.30.146:2181", 5000, 20000);
//        this.path = "/zklock";
//
//
//    }
//
//    //获取锁
//    public Lock lock(String lockId, long timeout) {
//        Lock lockNode = createLockNode(lockId);
//        lockNode = tryActiveLock(lockNode);
//        if (!lockNode.isActive()) {
//            try {
//                synchronized (lockNode) {
//                    lockNode.wait(timeout);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        return lockNode;
//    }
//
//    //激活锁
//    public Lock tryActiveLock(Lock lockNode) {
//        //判断是否获取锁
//        List<String> list = zkClient.getChildren(path).stream().sorted().map((x) -> (path + "/" + path)).collect(Collectors.toList());
//
//        String firstPath = list.get(0);
//        if (firstPath.equals(lockNode.getPath())) {
//            lockNode.setActive(true);
//        } else {
//            //添加监听
//            String upNodePath = list.get(list.indexOf(lockNode.getPath()) - 1);
//            zkClient.subscribeDataChanges(upNodePath, new IZkDataListener() {
//                @Override
//                public void handleDataChange(String s, Object o) throws Exception {
//
//                }
//
//                @Override
//                public void handleDataDeleted(String dataPath) throws Exception {
//                    System.out.println("删除节点：" + dataPath);
//                    Lock lock = tryActiveLock(lockNode);
//                    synchronized (lockNode) {
//                        if (lock.isActive()) {
//                            lock.notify();
//                        }
//                    }
//
//                    zkClient.unsubscribeChildChanges(upNodePath,this);
//
//                }
//            });
//        }
//
//        //在尝试获取锁
//        return lockNode;
//    }
//
//    //释放锁
//    public void unlock(Lock lock) {
//
//    }
//
//    //创建临时节点
//    public Lock createLockNode(String lockId) {
//        String path = zkClient.createEphemeralSequential(this.path + "/" + lockId, "w");
//
//        Lock lock = new Lock();
//        lock.setActive(false);
//        lock.setLockId(lockId);
//        lock.setPath(path);
//        return lock;
//
//
//    }
//
//
//}
