package nl.mindloops;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class GalaxyTheories {

    @Theory
    public void rocketCanReachPlanet(
        @ParametersSuppliedBy(PlanetSupplier.class) Planet planet,
        @ParametersSuppliedBy(RocketSupplier.class) Rocket rocket) {

        assumeTrue(isInOurGalaxy(planet));
        // complex assertion
    }

    private boolean isInOurGalaxy(Planet planet) {
        return true;
    }


    public static class PlanetSupplier extends ParameterSupplier {
        @Override
        public List getValueSources(ParameterSignature sig) {
            return null;
        }
    }

    public static class RocketSupplier extends ParameterSupplier {
        @Override
        public List getValueSources(ParameterSignature sig) {
            return null;
        }
    }

}