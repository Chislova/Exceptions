public class Dishwasher {

    private int maxLoad;
    private String[] content;
    private Status status;
    int numberOfDishes;

    public int getMaxLoad() {
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
        content = new String[maxLoad];
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
     * @throws EmptyDishwasher to print error message if dishwasher is empty.
     */
    public void start() throws EmptyDishwasher {
        switch (status) {
            case EMPTY:
                throw new EmptyDishwasher();

            case DIRTY:
                status = Status.IN_PROGRESS;
                break;
        }
    }

    /**
     * Checks if it possible to stop a program. If succeed - changes the status.
     *
     * @throws ProgramNotStarted to return an error if the program hadn't been started.
     */
    public void stop() throws ProgramNotStarted {
        if (status == Status.IN_PROGRESS) {
            status = Status.CLEAN;
            return;
        }
        throw new ProgramNotStarted();
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
        if (status == Status.EMPTY && numberOfDishes == 0) {
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
     * @throws MaxCount         returns error if the max count fo dishes is reached.
     * @throws ProgramIsRunning returns error that it's impossible to add a dish if the status is "In progress".
     * @throws CleanDishes      returns error that it's impossible to add a dish if the status is "Clean".
     */
    public void addDishes(String dish) throws MaxCount, ProgramIsRunning, CleanDishes {
        if (status == Status.IN_PROGRESS) {
            throw new ProgramIsRunning();
        } else if (status == Status.CLEAN) {
            throw new CleanDishes();
        } else if (numberOfDishes < content.length) {
            content[numberOfDishes] = dish;
            numberOfDishes++;
            status = Status.DIRTY;
        } else throw new MaxCount();
    }
}
