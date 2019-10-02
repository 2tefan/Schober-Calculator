package at.schiebung.stefan.schober0015;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import timber.log.Timber;

import static at.schiebung.stefan.schober0015.Value.DIVIDED;
import static at.schiebung.stefan.schober0015.Value.MINUS;
import static at.schiebung.stefan.schober0015.Value.MULTIPLIED;
import static at.schiebung.stefan.schober0015.Value.PLUS;

public class MainActivity extends AppCompatActivity {

    private StringBuilder stb = new StringBuilder();
    private int pasLastOperator = 0;
    private Value[] value = new Value[0];
    private byte operator = PLUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        setTextView();
    }

    public void button(View view) {
        switch (view.getId()) {
            case R.id.button0:
                stb.append(0);
                break;
            case R.id.button1:
                stb.append(1);
                break;
            case R.id.button2:
                stb.append(2);
                break;
            case R.id.button3:
                stb.append(3);
                break;
            case R.id.button4:
                stb.append(4);
                break;
            case R.id.button5:
                stb.append(5);
                break;
            case R.id.button6:
                stb.append(6);
                break;
            case R.id.button7:
                stb.append(7);
                break;
            case R.id.button8:
                stb.append(8);
                break;
            case R.id.button9:
                stb.append(9);
                break;
            case R.id.buttonClear:
                reset();
                break;
            case R.id.buttonDelete:
                deleteLastItem();
                break;
            case R.id.buttonPoint:
                if (!isPointAlreadyHere()) {
                    stb.append(".");
                }
                break;
        }
        setTextView();
    }

    public void operators(View view) {

        if (stb.length() > 0) {
            addNumber();

            switch (view.getId()) {
                case R.id.buttonPlus:
                    operator = PLUS;
                    stb.append("+");
                    break;
                case R.id.buttonMinus:
                    operator = MINUS;
                    stb.append("-");
                    break;
                case R.id.buttonMultiplied:
                    operator = MULTIPLIED;
                    stb.append("*");
                    break;
                case R.id.buttonDivided:
                    operator = DIVIDED;
                    stb.append("/");
                    break;
            }
            pasLastOperator = stb.length();
            setTextView();
        }
    }

    public void btnEquals(@SuppressWarnings("unused") View view) {
        if (stb.length() > 0) {
            addNumber();

            simplify(new byte[]{MULTIPLIED, DIVIDED, PLUS, MINUS});

            printResult(value[0].getNumber());
        }
    }

    private void simplify(byte[] operators) {
        for (byte b : operators) {
            for (int j = 1; j < value.length; j++) {
                if (b == value[j].getOperator()) {
                    calcNumber(j);
                    j--;
                }
                printValue();
            }
        }
    }

    private void setTextView() {
        TextView txtOutput = findViewById(R.id.txtOutput);
        txtOutput.setText(stb.toString());
    }

    private void printResult(double d) {
        reset();
        NumberFormat numberFormat = new DecimalFormat("#,###.########");
        stb.append(numberFormat.format(d));

        setTextView();
    }

    private void addValue(double number, byte operator) {
        Value[] temp = new Value[this.value.length + 1];

        System.arraycopy(this.value, 0, temp, 0, this.value.length);

        temp[temp.length - 1] = new Value();
        temp[temp.length - 1].setNumber(number);
        temp[temp.length - 1].setOperator(operator);

        this.value = temp;
    }

    private void calcNumber(int index) {
        if (index > 0) {
            switch (value[index].getOperator()) {
                case PLUS:
                    value[index - 1].setNumber(value[index - 1].getNumber() + value[index].getNumber());
                    break;
                case MINUS:
                    value[index - 1].setNumber(value[index - 1].getNumber() - value[index].getNumber());
                    break;
                case MULTIPLIED:
                    value[index - 1].setNumber(value[index - 1].getNumber() * value[index].getNumber());
                    break;
                case DIVIDED:
                    value[index - 1].setNumber(value[index - 1].getNumber() / value[index].getNumber());
                    break;
            }
            removeOldNumber(index);
        }
    }

    private void removeOldNumber(int index) {
        Value[] temp = new Value[value.length - 1];

        for (int i = 0; i < temp.length; i++) {
            if (i < index) {
                temp[i] = value[i];
            } else {
                temp[i] = value[i + 1];
            }
        }

        value = temp;
    }

    private void addNumber() {
        try {
            double number = Double.parseDouble(stb.substring(pasLastOperator));
            addValue(number, operator);
        } catch (Exception e) {
            deleteLastItem();
        }
    }

    private void deleteLastItem() {
        if (stb.length() > 0) {
            stb.deleteCharAt(stb.length() - 1);
        }
    }

    private void reset() {
        pasLastOperator = 0;
        stb = new StringBuilder();
        value = new Value[0];
        operator = PLUS;
    }

    private boolean isPointAlreadyHere() {
        String s = stb.substring(pasLastOperator);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                return true;
            }
        }

        return false;
    }

    private void printValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Value item : value) {
            switch (item.getOperator()) {
                case PLUS:
                    stringBuilder.append("+");
                    break;
                case MINUS:
                    stringBuilder.append("-");
                    break;
                case MULTIPLIED:
                    stringBuilder.append("*");
                    break;
                case DIVIDED:
                    stringBuilder.append("/");
                    break;
            }

            stringBuilder.append(item.getNumber());
        }

        Timber.v(stringBuilder.toString());
    }
}
