package nl.mindloops;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by rickette on 24-10-15.
 */
public class GalaxySimulatorRule implements TestRule {

    private Galaxy galaxy;

    public static GalaxySimulatorRule veryBigGalaxy() {
        return new GalaxySimulatorRule();
    }

    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                if (galaxy != null) {
                    try {
                        // evaluate method
                        base.evaluate();
                    } finally {
                        galaxy.resetPlanets();
                    }
                } else {
                    galaxy = new Galaxy();
                    galaxy.bigBang();
                    try {
                        // evaluate all methods in class
                        base.evaluate();
                    } finally {
                        galaxy.destroy();
                    }
                }
            }
        };
    }
}
