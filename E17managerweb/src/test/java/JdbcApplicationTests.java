import cn.ldm.AppMW;
import cn.ldm.utills.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppMW.class)
public class JdbcApplicationTests {
	@Test
	public void contextLoads() throws Exception {
		FastDFSClient fastDFSClient = new  FastDFSClient("I:/E17/E17managerweb/src/main/resources/fdfs.conf");
		String s = fastDFSClient.uploadFile ("F:/photo/1.jpg");
	}

}
