public class cleanDishes extends Exception {
    int errorNumber;
    String errorText;

    public cleanDishes() {
        errorNumber = 431;
        errorText = "You can't add dirty dishes to the clean ones!";
        System.out.println(errorText + " See the instruction. Error Number: " + errorNumber);

    }

}
