package com.imooc.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class HdfsClient {

	public static void main(String[] args) throws Exception {
		// 1 获取文件系统
				Configuration configuration = new Configuration();
				configuration.set("dfs.client.use.datanode.hostname", "true");
				FileSystem fs = FileSystem.get(new URI("hdfs://Master:9000"), configuration, "root");
				// 2 上传文件 参数：原数据路径，目标路径
				fs.mkdirs(new Path("/cbeann/abc"));

				// 3 关闭资源
				fs.close();
				System.out.println("over");
	}

}
