import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chaird
 * @create 2020-08-27 21:42
 */
public class Start {

    public static void main(String[] args) throws Exception {
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .put("client.transport.sniff", "true")//增加自动嗅探配置
                .build();

        PreBuiltTransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.129.221"), 9300));

        System.out.println(client.toString());


//        //创建索引
//        client.admin().indices().prepareCreate("book").get();
//        System.out.println("创建Index成功");


        Map<String,Object> source=new HashMap<>();
        source.put("name", "elasticsearch in action");
        source.put("desc", "es desc");
        source.put("price", 9.9);
        source.put("publish", "2020-01-01");
        IndexResponse indexResponse = client.prepareIndex("book", "book").setSource(source).execute().actionGet();
        System.out.println("status:"+indexResponse.status().getStatus()+" , response id"+indexResponse.getId());

    }
}
