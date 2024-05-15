package domain_model;

import java.util.Comparator;

public class swimTimeComparator implements Comparator<ResultSwimmer> {
    @Override
    public int compare(ResultSwimmer o1, ResultSwimmer o2) {
        return Double.compare(o1.getSwimTime(),o2.getSwimTime());
    }
}
