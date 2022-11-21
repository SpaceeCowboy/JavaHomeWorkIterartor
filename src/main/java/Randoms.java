import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;

    List<Integer> list = new ArrayList<>();


    public Randoms(int min, int max) {
        this.min = min;
        this.max = ++max;
        random = new Random();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < list.size()) {
                    return true;
                } else {
                    list.add(random.nextInt(min, max));
                    return index < list.size();
                }
            }

            @Override
            public Integer next() {
                if (index < list.size()) {
                    list.add(random.nextInt(min, max));
                }
                return list.get(index++);
            }
        };
    }

}
