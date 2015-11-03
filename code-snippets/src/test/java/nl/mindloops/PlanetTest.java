package nl.mindloops;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PlanetTest {

    @Parameters(name = "planet: {0}")
    public static List<String> planets() {
        return Arrays.asList("Earth", "Mars", "Saturn", "Jupiter");
    }

    @Parameter
    public String planet;

    @Test
    public void shouldExistInGalaxy() {
        assertTrue(galaxyService.exists(planet));
    }

    private GalaxyService galaxyService = new GalaxyService();
}