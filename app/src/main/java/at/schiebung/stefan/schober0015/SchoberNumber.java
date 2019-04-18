package at.schiebung.stefan.schober0015;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class SchoberNumber
{
    public static boolean isInt(String iString)
    {
        boolean result = true;
        try
        {
            int i = Integer.parseInt(iString);
        }
        catch (NumberFormatException | NullPointerException e)
        {
            result = false;
        }
        return result;
    }
    public static boolean isDouble(String dString)
    {
        boolean result = true;
        try
        {
            double d = Double.parseDouble(dString);
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
	        return  Double.parseDouble(number.toString());

    }

}