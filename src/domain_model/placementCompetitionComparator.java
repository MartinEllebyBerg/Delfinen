package domain_model;

import java.util.Comparator;

public class placementCompetitionComparator implements Comparator<ResultSwimmer> {
    @Override
    public int compare(ResultSwimmer o1, ResultSwimmer o2) {
        return Integer.compare(o1.getPlacementCompetition(), o2.getPlacementCompetition());
    }
}
