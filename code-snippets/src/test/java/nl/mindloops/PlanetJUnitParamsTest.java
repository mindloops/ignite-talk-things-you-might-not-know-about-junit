package nl.mindloops;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PlanetJUnitParamsTest {

    @Test
    @Parameters({"Earth", "Mars", "Saturn", "Jupiter"})
    @FileParameters("classpath:planets.csv")
    public void planetShouldExistInGalaxy(String planet) {
        assertTrue(galaxyService.exists(planet));
    }

    private GalaxyService galaxyService = new GalaxyService();
}