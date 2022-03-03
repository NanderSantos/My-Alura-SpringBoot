public class Phone {

    private String ddd;
    private String number;

    public Phone(String ddd, String number) {

        if (number == null
                || number.isBlank()
                || (number.length() != 8 && number.length() != 9)
        ) {
            throw new IllegalArgumentException("Invalid phone number!");
        }

        if (ddd == null
                || ddd.isBlank()
                || ddd.length() != 2
        ) {
            throw new IllegalArgumentException("Invalid DDD!");
        }

        this.ddd = ddd;
        this.number = number;
    }

    public String getFormattedNumber() {

        int numberLength = this.number.length();

        if (numberLength == 8) {
            return "(" + this.ddd + ") " + this.number.substring(0, 4) + "-" + this.number.substring(4, numberLength);
        }

        return "(" + this.ddd + ") " + this.number.charAt(0) + " " + this.number.substring(1, 5) + "-" + this.number.substring(5, numberLength);
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}
