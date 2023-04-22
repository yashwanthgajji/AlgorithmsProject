import java.util.HashSet;

public class HashTableV1<T extends Comparable<T>> implements DataStructureV1<T> {

    HashSet<T> hashSet;

    public HashTableV1() {
        hashSet = new HashSet<>();
    }
    @Override
    public void insert(T key) {
        hashSet.add(key);
    }

    @Override
    public void delete(T key) throws ElementNotFoundException {
        if (!hashSet.contains(key)) {
            throw new ElementNotFoundException();
        } else {
            hashSet.remove(key);
        }
    }

    @Override
    public void ascendingOrder() {
        System.out.println("Ascending order of data:");
        for(T i: hashSet) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
