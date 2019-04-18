package at.schiebung.stefan.schober0015;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Methods
{
	public void dfSetup()
	{
		DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
		formatSymbols.setDecimalSeparator('.');
		formatSymbols.setGroupingSeparator(' ');

		Vars.decimalFormat = new DecimalFormat(Vars.pattern, formatSymbols);
	}
}
