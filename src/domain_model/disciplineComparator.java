package domain_model;

import java.util.Comparator;

public class disciplineComparator implements Comparator<ResultSwimmer> {
    @Override
    public int compare(ResultSwimmer o1, ResultSwimmer o2) {
        return o1.getSwimDiscipline().compareTo(o2.getSwimDiscipline());
    }
}
