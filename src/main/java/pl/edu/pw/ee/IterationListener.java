package pl.edu.pw.ee;

import java.util.Map;

public interface IterationListener {
    void incrementSize();
    void incrementIteration();
    void writeIteration();
    Map<Integer, Integer> getResults();
}
