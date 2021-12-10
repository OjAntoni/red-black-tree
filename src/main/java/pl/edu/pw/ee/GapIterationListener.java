package pl.edu.pw.ee;

import java.util.LinkedHashMap;
import java.util.Map;

public class GapIterationListener implements IterationListener{

    private final Map<Integer, Integer> resultsMap = new LinkedHashMap<>();
    private int sourceSize;
    private final int gap;
    private int currentElemCount;
    private int iteration;

    public GapIterationListener(int gapSize){
        gap = gapSize > 0 ? gapSize : 10;
        currentElemCount = 0;
    }

    @Override
    public void incrementSize() {
        sourceSize++;
        currentElemCount++;
    }

    @Override
    public void incrementIteration() {
        if(currentElemCount < gap){
            return;
        }
        iteration++;
    }

    @Override
    public void writeIteration() {
        if(currentElemCount == gap){
            resultsMap.put(sourceSize, iteration);
            iteration = 0;
            currentElemCount = 0;
        }
    }

    @Override
    public Map<Integer, Integer> getResults() {
        return resultsMap;
    }

}
