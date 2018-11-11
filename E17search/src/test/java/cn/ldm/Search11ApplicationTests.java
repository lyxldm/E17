package cn.ldm;

import cn.ldm.pojo.Item;
import cn.ldm.pojo.man;
import cn.ldm.repository.ItemRopository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.Field;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Search11ApplicationTests {

	@Autowired
	ItemRopository itemRopository;

	@Test
	public void contextLoads1() throws  Exception{
		Item item = new Item ();
		item.setId (221);
		item.setDes ("罗永祥在1111sd");
		itemRopository.save (item);
	}
	@Test
	public void contextLoads() throws  Exception{
		Field field = (Field) new HighlightBuilder.Field("des").preTags("<em style='color:red'>").postTags("</em>").fragmentSize(250);
		// 根据地址值过滤
		Pageable page = new PageRequest(0,3);
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		queryBuilder.must(QueryBuilders.matchQuery("des","罗"));
		SearchQuery query =
				new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(page).build ();
		Page<Item> pages = itemRopository.search(query);
		List<Item> content = pages.getContent ( );
	}
}
