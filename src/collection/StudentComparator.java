package Collection;

import java.util.Comparator;

/**
 * Created by james on 2016/10/8.
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
