package net.turvo.rangeproblem.rangeproblem;

import net.turvo.rangeproblem.rangeproblem.service.RangeServiceImpl;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RangeproblemApplicationTests {

    @InjectMocks
    private RangeServiceImpl rangeService;

    @Mock
    private NodeService nodeService;



    @Test
    public void contextLoads() {
    }

}
