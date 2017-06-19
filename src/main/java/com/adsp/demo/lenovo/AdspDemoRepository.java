package com.adsp.demo.lenovo;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by caoliuxue on 2017/6/19.
 */
@Component
public class AdspDemoRepository {


    Settings settings = Settings.builder()
            .put("cluster.name", "dev-es")
            .put("xpack.security.user", "ovp-dev:ovp-dev")
            .build();

    public IndexResponse write() {
        try {
            TransportClient client = new PreBuiltXPackTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.120.112.143"), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.120.112.144"), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.120.112.145"), 9300));

            IndexResponse response = client.prepareIndex("sample", "order", "1")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user", "kimchy")
                            .field("postDate", new Date())
                            .field("message", "trying out Elasticsearch")
                            .endObject()
                    ).get();
            client.close();
            return response;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public GetResponse read() {
        try {
            TransportClient client = new PreBuiltXPackTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.120.112.143"), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.120.112.144"), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.120.112.145"), 9300));
            GetResponse response = client.prepareGet("sample", "order", "1").get();
            return response;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
