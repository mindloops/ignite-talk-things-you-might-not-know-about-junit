package nl.mindloops;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.expectThrows;
import static org.junit.Assume.assumeThat;

public class GalaxyTest {

    @Test
    public void ourPlanetShouldBeEarth() {

        Planet ourPlanet = galaxyService.getOurPlanet();

        assertThat(ourPlanet, is(planetEarth));
    }

    // ==== assume
    Planet planetEarth = new Earth();
    private GalaxyService galaxyService = new GalaxyService();

    @Test
    public void planetShouldBeWithinReach() {

        assumeThat(System.getProperty("currentPlanet"), is("earth"));


        Set<Planet> planets = galaxyService.getPlanets();

        planets.getClass();
    }

    Rocket rocket = new Rocket();
    Planet jupiter = new Jupiter();

    // ==== exception testing

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowRocketLaunch() {

        rocket.launchFrom(jupiter);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotAllowRocketLaunchFromJupiter() {
        // other code

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("due to gas-surface");

        rocket.launchFrom(jupiter);


        assumeThat(System.getProperty("currentPlanet"), is("earth"));


        Set<Planet> planets = galaxyService.getPlanets();

        planets.getClass();
    }

    @Test
    public void shouldNotAllowRocketLaunchFromJupiterLambda() {
        // other code

        IllegalStateException e = expectThrows(IllegalStateException.class,
                () -> rocket.launchFrom(jupiter));

        assertThat(e.getMessage(), containsString("due to gas-surface"));
    }

    class Rocket {
        void launchFrom(Planet p) {
            throw new IllegalStateException("Can't launch rocket from Jupiter due to gas-surface");
        }
    }

    // ==== rules

    @Rule
    public TestRule timeout = new DisableOnDebug(Timeout.seconds(300000));

    @ClassRule
    public static TestRule timeoutAllTestsCombined
            = new DisableOnDebug(new Timeout(20, TimeUnit.MINUTES));


    @ClassRule
    @Rule
    public static GalaxySimulatorRule galaxy = GalaxySimulatorRule.veryBigGalaxy();

    @Test
    public void pass() {
        assertTrue(true);
    }

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();


    @Test
    public void files() throws IOException {

        File rocketManual = temporaryFolder.newFile("rocketManual.pdf");


        rocketManual.canRead();
    }


    @Rule
    public MockServerRule mockServer = new MockServerRule(this);

    private MockServerClient mockServerClient;
}
