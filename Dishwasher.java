
public class Dishwasher {

    private static int maxLoad;
    private String[] content = new String[maxLoad];
    Status status;
    int numberOfDishes;

    public static int getMaxLoad() {
        return maxLoad;
    }

    /**
     * Constructor for Dishwasher.
     *
     * @param quantity - determines the size of the array.
     * @throws IllegalArgumentException returns error if the size of the array initialized less or equal 0.
     */
    public Dishwasher(int quantity) throws IllegalArgumentException {
        status = Status.EMPTY;
        maxLoad = quantity;
        if (maxLoad <= 0) {
            throw new IllegalArgumentException("The number of plates must be greater than zero!");
        }

    }

    public void getStatus() {
        System.out.println(status);
    }


    /**
     * Checks if it possible to start a program. If succeed - changes the status.
     *
     * @throws emptyDishwasher to print error message if dishwasher is empty.
     */
    public void start() throws emptyDishwasher {
        switch (status) {
            case EMPTY:
                throw new emptyDishwasher();

            case DIRTY:
                status = Status.IN_PROGRESS;
                break;
        }
    }

    /**
     * Checks if it possible to stop a program. If succeed - changes the status.
     *
     * @throws programNotStarted to return an error if the program hadn't been started.
     */
    public void stop() throws programNotStarted {
        if (status == Status.IN_PROGRESS) {
            status = Status.CLEAN;
        } else throw new programNotStarted();


    }

    /**
     * Changes the status of the dishwasher and cleans the array
     */
    public void empty() {
        status = Status.EMPTY;
        numberOfDishes = 0;
        content = new String[maxLoad];

    }

    /**
     * Gets and prints the content according to the status.
     */
    public void getContent() {
        if (status.equals(Status.EMPTY) && numberOfDishes == 0) {
            System.out.println("[ ]");
        } else {
            for (int i = 0; i < content.length; i++) {
                String message = content[i] + " ";

                if (i == (content.length - 1)) {
                    System.out.println(message);
                } else {
                    System.out.print(message + ", ");
                }
            }
        }
    }

    /**
     * Allows to fill the array (fills the dishwasher) and change the status
     *
     * @param dish - name of the dish.
     * @throws maxCount         returns error if the max count fo dishes is reached.
     * @throws programIsRunning returns error that it's impossible to add a dish if the status is "In progress".
     * @throws cleanDishes      returns error that it's impossible to add a dish if the status is "Clean".
     */
    public void addDishes(String dish) throws maxCount {
        if (status == Status.IN_PROGRESS) {
            try {
                throw new programIsRunning();
            } catch (programIsRunning programIsRunning) {
                programIsRunning.printStackTrace();
            }
        } else if (status == Status.CLEAN) {
            try {
                throw new cleanDishes();
            } catch (cleanDishes cleanDishes) {
                cleanDishes.getStackTrace();
            }

        } else if (numberOfDishes < content.length) {
            content[numberOfDishes] = dish;
            numberOfDishes++;
            status = Status.DIRTY;
        } else throw new maxCount();
    }
}




