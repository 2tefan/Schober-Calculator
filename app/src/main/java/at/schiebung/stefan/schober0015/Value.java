package at.schiebung.stefan.schober0015;

class Value {

    static final byte PLUS = 1;
    static final byte MINUS = 2;
    static final byte MULTIPLIED = 3;
    static final byte DIVIDED = 4;
    private double number;
    private byte operator;

    double getNumber() {
        return number;
    }

    void setNumber(double number) {
        this.number = number;
    }

    byte getOperator() {
        return operator;
    }

    void setOperator(byte operator) {
        this.operator = operator;
    }
}
