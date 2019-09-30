package at.schiebung.stefan.schober0015;

class Value {

    static final byte NOTHING = 0;
    static final byte PLUS = 1;
    static final byte MINUS = 2;
    static final byte MULTIPLIED = 3;
    static final byte DIVIDED = 4;
    private double number;
    private byte operator;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public byte getOperator() {
        return operator;
    }

    public void setOperator(byte operator) {
        this.operator = operator;
    }
}
