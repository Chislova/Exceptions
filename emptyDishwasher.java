
public class emptyDishwasher extends Exception {

    public emptyDishwasher() {
        super("Can't start; add some dishes first!");
        System.out.println("For further assistance read the instruction.");

    }
}
