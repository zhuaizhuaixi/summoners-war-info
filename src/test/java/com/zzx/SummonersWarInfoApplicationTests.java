package com.zzx;

import com.zzx.config.EsConfig;
import com.zzx.config.utils.EsClientUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummonersWarInfoApplicationTests {

	@Autowired
	private EsConfig esConfig;

	@Test
	public void contextLoads() throws IOException {
		RestHighLevelClient client = new EsClientUtil().getEsClient();
		SearchResponse sr = client.search(new SearchRequest("metrics-2018-01-17"));
		System.out.println(sr);

	}

	@Test
	public void testEsConfig() {
		System.out.println(esConfig);
	}
	}
