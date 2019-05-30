package at.schiebung.stefan.schober0015;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Objects;

class SchoberNumber
{
    public static boolean isDouble(String dString)
    {
        boolean result = true;
        try
        {
            @SuppressWarnings("unused") double d = Double.parseDouble(dString);
        }
        catch (NumberFormatException | NullPointerException e)
        {
            result = false;
        }
        return result;
    }
    public double formatDouble(String s)
    {
        NumberFormat format = Vars.decimalFormat;
        Number       number = null;
        try
        {
            number = format.parse(s);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return Double.parseDouble(Objects.requireNonNull(number).toString());

    }

}