import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Watcher watcher = watchedEvent -> {
            Watcher.Event.KeeperState state = watchedEvent.getState();
            Watcher.Event.EventType type = watchedEvent.getType();
            String path1 = watchedEvent.getPath();

            if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                countDownLatch.countDown();
            }

            System.out.println("zk --- > state " + state + " type " + type + " path " + path1);
        };

        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 100000, watcher);
        countDownLatch.await();

        String path = "/test6";
        byte[] data = "test_data".getBytes();


        Stat exists = zooKeeper.exists(path, watcher);

        if(!Objects.isNull(exists)) {
            zooKeeper.delete(path, -1);
        }

        String s1 = zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s1);

        while (true) {
            Thread.sleep(1000);
            byte[] data1 = zooKeeper.getData(path, watcher, null);
            System.out.println(new String(data1));
        }

        // 节点类型有4种：“PERSISTENT、PERSISTENT_SEQUENTIAL、EPHEMERAL、EPHEMERAL_SEQUENTIAL”其中“EPHEMERAL、EPHEMERAL_SEQUENTIAL”两种是客户端断开连接(Session无效时)节点会被自动删除；“PERSISTENT_SEQUENTIAL、EPHEMERAL_SEQUENTIAL”两种是节点名后缀是一个自动增长序号。
        //节点访问权限说明：
        //节点访问权限由List<ACL>确定，但是有几个便捷的静态属性可以选择：
        //    Ids.CREATOR_ALL_ACL：只有创建节点的客户端才有所有权限
        //    Ids.OPEN_ACL_UNSAFE：这是一个完全开放的权限，所有客户端都有权限
        //    Ids.READ_ACL_UNSAFE：所有客户端只有读取的
    }
}
