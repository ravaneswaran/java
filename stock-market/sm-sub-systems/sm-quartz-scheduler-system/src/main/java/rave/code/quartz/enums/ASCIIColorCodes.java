package rave.code.quartz.enums;

public enum ASCIIColorCodes {

    RED("\u001B[31m"), GREEN("\u001B[92m"), YELLOW("\u001B[93m"), BLUE("\u001B[34m"), CYAN("\u001B[36m"),
    MAGENTA("\u001B[35m"), WHITE("\u001B[97m"), BLACK("\u001B[30m"), RESET("\u001B[0m");


    private final String colorCode;

    private ASCIIColorCodes(String colorCode) {
        this.colorCode = colorCode;
    }

    public String get() {
        return this.colorCode;
    }
}
