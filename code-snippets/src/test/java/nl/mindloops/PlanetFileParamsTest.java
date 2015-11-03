package nl.mindloops;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PlanetFileParamsTest {

    @Test
    @FileParameters("classpath:planets.csv")
    public void planetShouldExistInGalaxy(String planet) {
        assertTrue(galaxyService.exists(planet));
    }

    private GalaxyService galaxyService = new GalaxyService();
}