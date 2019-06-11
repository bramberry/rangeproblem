package net.turvo.rangeproblem.rangeproblem;

import static java.util.Arrays.asList;
import net.turvo.rangeproblem.rangeproblem.model.Neighbor;
import net.turvo.rangeproblem.rangeproblem.model.Node;
import net.turvo.rangeproblem.rangeproblem.service.RangeServiceImpl;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.*;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.*;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RangeproblemApplicationTests {

    @InjectMocks
    private RangeServiceImpl rangeService;

    @Mock
    private NodeService nodeService;

    @BeforeTest
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterMethod
    public void reset() {
        Mockito.reset(nodeService);
    }

    @Test(dataProvider = "input")
    public void testFindCitiesReturnOk(String inputCity, Integer inputTime, Set<String> expectedResult) {
        Map<String, Node> nodeMap = getNodes();

        for (String city : nodeMap.keySet()) {
            when(nodeService.getByName(city)).thenReturn(nodeMap.get(city));
        }

        Set<String> cities = rangeService.findCities(inputCity, inputTime);

        assertEquals(cities, expectedResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFindCitiesInvalidCityNameReturnIllegalArgumentException() {
        when(nodeService.getByName(anyString())).thenReturn(null);

        rangeService.findCities("Invalid City", anyInt());

    }

    @DataProvider(name = "input")
    public Object[][] inputData() {

        return new Object[][]{
                new Object[]{"Vitsebsk", 400, new HashSet<>(asList(
                        "Gomel",
                        "Brest",
                        "Grodno",
                        "Minsk",
                        "Zgodino",
                        "Orsha",
                        "Mogilev",
                        "Polask",
                        "Babruysk",
                        "Horki"))},
                new Object[]{"Minsk", 300, new HashSet<>(asList(
                        "Bialystok",
                        "Lida",
                        "Brest",
                        "Grodno",
                        "Vitsebsk",
                        "Zgodino",
                        "Orsha",
                        "Mogilev",
                        "Polask",
                        "Babruysk",
                        "Horki"))},
                new Object[]{"Mogilev", 30, new HashSet<>()},
                new Object[]{"Grodno", 360, new HashSet<>(asList(
                        "Brest",
                        "Bialystok",
                        "Minsk",
                        "Zgodino",
                        "Lida",
                        "Vitsebsk",
                        "Mogilev"))}

        };
    }

    private Map<String, Node> getNodes() {
        Node vitsebsk = new Node();
        Node minsk = new Node();
        Node mogilev = new Node();
        Node grodno = new Node();

        vitsebsk.setCity("Vitsebsk");
        minsk.setCity("Minsk");
        mogilev.setCity("Mogilev");
        grodno.setCity("Grodno");


        List<Neighbor> vitsebskNeighbors = new ArrayList<>(
                asList(
                        new Neighbor(210, "Minsk"),
                        new Neighbor(80, "Polask"),
                        new Neighbor(120, "Mogilev"),
                        new Neighbor(360, "Grodno"),
                        new Neighbor(65, "Orsha")));

        List<Neighbor> minskNeighbors = new ArrayList<>(
                asList(
                        new Neighbor(210, "Vitsebsk"),
                        new Neighbor(190, "Brest"),
                        new Neighbor(160, "Mogilev"),
                        new Neighbor(165, "Grodno"),
                        new Neighbor(65, "Zgodino")));

        List<Neighbor> grodnoNeighbors = new ArrayList<>(
                asList(
                        new Neighbor(165, "Minsk"),
                        new Neighbor(113, "Lida"),
                        new Neighbor(128, "Brest"),
                        new Neighbor(360, "Vitsebsk"),
                        new Neighbor(98, "Bialystok")));

        List<Neighbor> mogilevNeighbors = new ArrayList<>(
                asList(
                        new Neighbor(160, "Minsk"),
                        new Neighbor(90, "Babruysk"),
                        new Neighbor(65, "Horki"),
                        new Neighbor(120, "Vitsebsk"),
                        new Neighbor(150, "Gomel")));

        vitsebsk.setNeighbors(vitsebskNeighbors);
        minsk.setNeighbors(minskNeighbors);
        mogilev.setNeighbors(mogilevNeighbors);
        grodno.setNeighbors(grodnoNeighbors);

        Map<String, Node> nodeMap = new HashMap<>();
        nodeMap.put("Vitsebsk", vitsebsk);
        nodeMap.put("Minsk", minsk);
        nodeMap.put("Mogilev", mogilev);
        nodeMap.put("Grodno", grodno);

        return nodeMap;
    }

}
