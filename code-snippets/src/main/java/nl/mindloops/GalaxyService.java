package nl.mindloops;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GalaxyService {

    public Planet getOurPlanet() {
        return new Earth();
    }

    Set<Planet> getInhabitalPlanets() {
        Planet earth = new Earth();
        return Collections.singleton(earth);
    }

    Set<Planet> getPlanets() {
        return new HashSet<Planet>() {{
            add(new Earth());
            add(new Jupiter());
            add(new Mars());
        }};
    }

    Planet getInhabitalPlanet() {
        return new Earth();
    }

    public boolean exists(Planet planet) {
        return true;
    }

    public boolean exists(String planet) {
        return true;
    }
}
