package cn.ldm.repository;

import cn.ldm.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRopository extends ElasticsearchRepository<Item,Integer> {
}
