package rave.code.utility.log.message;

public class JavaUtilLogMessage {

    private String message = "";

    public JavaUtilLogMessage(String message) {
        this.message = message;
    }

    public String getDecoratedLogMessage() {
        int length = this.message.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("| [[[**********     ").append(this.message).append("     **********]]] |");
        int modifiedLength = stringBuilder.toString().length();

        String topLine = this.line(modifiedLength);
        String middleLine = stringBuilder.toString();
        String bottomLine = this.line(modifiedLength);

        stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(topLine).append("\n");
        stringBuilder.append(middleLine).append("\n");
        stringBuilder.append(bottomLine);

        return stringBuilder.toString();
    }

    private String line(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                stringBuilder.append("+");
            } else {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        JavaUtilLogMessage logMessage = new JavaUtilLogMessage("This is a simple message");
        System.out.println(logMessage.getDecoratedLogMessage());
    }
}
