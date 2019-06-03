import cn.ldm.AppS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.elasticsearch.action.admin.indices.stats.CommonStatsFlags.Flag.Search;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppS.class)
public class CacheApplicationTests {
	@Autowired
	StringRedisTemplate stringRedisTemplate;
 	@Test
	public void contextLoads() throws IOException {
		stringRedisTemplate.opsForValue ().set ("sessionid:","dasdsa",1800, TimeUnit.SECONDS);
	}
}
