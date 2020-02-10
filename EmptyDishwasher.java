
public class EmptyDishwasher extends Exception {

    public EmptyDishwasher() {
        super("Can't start; add some dishes first!");
        System.out.println("For further assistance read the instruction.");

    }
}
