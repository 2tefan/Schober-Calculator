package at.schiebung.stefan.schober0015;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import static at.schiebung.stefan.schober0015.Value.DIVIDED;
import static at.schiebung.stefan.schober0015.Value.MINUS;
import static at.schiebung.stefan.schober0015.Value.MULTIPLIED;
import static at.schiebung.stefan.schober0015.Value.NOTHING;
import static at.schiebung.stefan.schober0015.Value.PLUS;

public class MainActivity extends AppCompatActivity {

    private StringBuilder stb = new StringBuilder();
    private Value[] value = new Value[0];
    private byte operator = NOTHING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                if (stb.length() > 0) {
                    stb.deleteCharAt(stb.length() - 1);
                }
                break;
            case R.id.buttonPoint:
                stb.append(".");
                break;
        }
        setTextView(false);
    }

    public void operators(View view) {

        addNumber();

        switch (view.getId()) {
            case R.id.buttonPlus:
                operator = PLUS;
                break;
            case R.id.buttonMinus:
                operator = MINUS;
                break;
            case R.id.buttonMultiplied:
                operator = MULTIPLIED;
                break;
            case R.id.buttonDivided:
                operator = DIVIDED;
                break;
        }

        stb = new StringBuilder();
    }

    public void btnEquals(@SuppressWarnings("unused") View view) {

        addNumber();

        double result = value[0].getNumber();


        for (int i = 1; i < value.length; i++) {
            switch (value[i].getOperator()) {
                case PLUS:
                    result += value[i].getNumber();
                    break;
                case MINUS:
                    result -= value[i].getNumber();
                    break;
                case MULTIPLIED:
                    result *= value[i].getNumber();
                    break;
                case DIVIDED:
                    result /= value[i].getNumber();
                    break;
            }
        }

        setTextView(result);
        stb = new StringBuilder();
    }

    private void setTextView() {

        TextView txtOutput = findViewById(R.id.txtOutput);

        if (!stb.toString().equals("")) {

            DecimalFormat df2 = new DecimalFormat("#,###,###,##0.##");
            txtOutput.setText(df2.format(Double.parseDouble(stb.toString())));
        } else {
            txtOutput.setText("");
        }
    }

    private void setTextView(double d) {
        TextView txtOutput = findViewById(R.id.txtOutput);
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.##");

        txtOutput.setText(df2.format(d));
    }

    private void setTextView(@SuppressWarnings("unused") boolean b) {
        TextView txtOutput = findViewById(R.id.txtOutput);
        txtOutput.setText(stb.toString());
    }

    private void addValue(double number, byte operator) {
        Value[] temp = new Value[this.value.length + 1];

        System.arraycopy(this.value, 0, temp, 0, this.value.length);

        temp[temp.length - 1] = new Value();
        temp[temp.length - 1].setNumber(number);
        temp[temp.length - 1].setOperator(operator);

        this.value = temp;
    }

    private void addNumber() {
        if (!stb.toString().equals("")) {
            double number = Double.parseDouble(stb.toString());
            addValue(number, operator);
        }
    }

    private void reset() {
        stb = new StringBuilder();
        value = new Value[0];
        operator = NOTHING;
    }
}
