package cn.ldm.controller;

import cn.ldm.pojo.Item;
import cn.ldm.pojo.man;
import cn.ldm.repository.ItemRopository;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.Field;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemRopository itemRopository;
    @PostMapping("/search/add")
    Boolean add(@RequestBody Item item){
        itemRopository.index (item);
        return true;
    }


    @PostMapping("/search")
    public List<Item> search(@RequestBody String searchText){
    /*@GetMapping("/search")
    public List<Item> search(String searchText){*/
        HighlightBuilder.Field hfield = new HighlightBuilder.Field ("title").preTags ("<em style='color:red'>").postTags ("</em>").fragmentSize (250);
        Pageable page = new PageRequest(0,16);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("title",searchText));
        SearchQuery query =
                new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(page).withHighlightFields (hfield).build ();
        Page<Item> pages = itemRopository.search(query);
        List<Item> content = pages.getContent ( );
        for(Item item:content){
            String substring = StringUtils.substring (item.getImg (), 0, 73);
            item.setImg (substring);
        }
        return content;
    }
}
