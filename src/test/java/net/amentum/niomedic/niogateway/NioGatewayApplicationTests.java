package net.amentum.niomedic.niogateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = {"classpath:application-test.properties"})
@SpringBootTest(classes = {NioGatewayApplication.class})
@ActiveProfiles("test")
public class NioGatewayApplicationTests {

	@Autowired
    protected MockMvc mockMvc;

    protected final ObjectMapper MAPPER;

    protected final MediaType JSON = MediaType.APPLICATION_JSON;

    public NioGatewayApplicationTests(){
        MAPPER = new ObjectMapper();
    }

}
