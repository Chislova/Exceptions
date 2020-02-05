public class Main {

    public static void main(String[] args) throws programNotStarted, emptyDishwasher, maxCount {
        Dishwasher dishwasher = new Dishwasher(3);
        //dishwasher.start();
        dishwasher.empty();
        dishwasher.addDishes("plate");
        dishwasher.addDishes("fork");
        dishwasher.addDishes("spoon");
        dishwasher.addDishes("bowl");
        dishwasher.getContent();
        dishwasher.getStatus();
        dishwasher.start();
        dishwasher.getStatus();
        dishwasher.addDishes("bowl");
        dishwasher.stop();
        dishwasher.getStatus();
        dishwasher.addDishes("bowl");
        dishwasher.empty();
        dishwasher.getContent();
        dishwasher.addDishes("bowl");
    }
}
