package at.schiebung.stefan.schober0015;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

class Calculate
{
	private final SchoberNumber schoberNumber = new SchoberNumber();
	private void calc3(View V, int id1, int id2, int id3)
	{
		boolean funkt = true;

		TextView textView1 = V.findViewById(id1);
		TextView textView2 = V.findViewById(id2);
		TextView textView3 = V.findViewById(id3);

		String string1 = textView1.getText().toString();
		String string2 = textView2.getText().toString();
		String string3 = textView3.getText().toString();

		double value1 = 0;
		double value2 = 0;
		double value3 = 0;

		boolean b1 = SchoberNumber.isDouble(string1);
		boolean b2 = SchoberNumber.isDouble(string2);
		boolean b3 = SchoberNumber.isDouble(string3);


		if (b2 && b3 && b1)
		{
			value1 = schoberNumber.formatDouble(string1);
			value2 = schoberNumber.formatDouble(string2);
			value3 = schoberNumber.formatDouble(string3);

			if (value1 != value2 / value3)
			{
				value1 = value2 / value3;
			}
			else
			{
				alreadyCalculated(V);
			}
		}
		else if (b1 && b2)
		{
			value1 = schoberNumber.formatDouble(string1);
			value2 = schoberNumber.formatDouble(string2);

			value3 = value2 / value1;

		}
		else if (b1 && b3)
		{
			value1 = schoberNumber.formatDouble(string1);
			value3 = schoberNumber.formatDouble(string3);

			value2 = value1 * value3;
		}
		else if (b2 && b3)
		{
			value2 = schoberNumber.formatDouble(string2);
			value3 = schoberNumber.formatDouble(string3);

			value1 = value2 / value3;
		}
		else
		{
			funkt = false;
		}


		if (funkt)
		{
			textView1.setText(Vars.decimalFormat.format(value1));
			textView2.setText(Vars.decimalFormat.format(value2));
			textView3.setText(Vars.decimalFormat.format(value3));
		}
		else
		{
			notEnoughInformation(V);
		}
	}

	private void calc4(View V)
	{
		boolean funkt = true;

		TextView textView1 = V.findViewById(R.id.input_work);
		TextView textView2 = V.findViewById(R.id.input_mass);
		TextView textView3 = V.findViewById(R.id.input_height);
		TextView textView4 = V.findViewById(R.id.input_gravity);

		String string1 = textView1.getText().toString();
		String string2 = textView2.getText().toString();
		String string3 = textView3.getText().toString();
		String string4 = textView4.getText().toString();

		double value1 = 0;
		double value2 = 0;
		double value3 = 0;
		double value4 = 0;

		boolean b1 = SchoberNumber.isDouble(string1);
		boolean b2 = SchoberNumber.isDouble(string2);
		boolean b3 = SchoberNumber.isDouble(string3);
		boolean b4 = SchoberNumber.isDouble(string4);

		if (b1 && b2 && b3 && b4)
		{
			value1 = schoberNumber.formatDouble(string1);
			value2 = schoberNumber.formatDouble(string2);
			value3 = schoberNumber.formatDouble(string3);
			value4 = schoberNumber.formatDouble(string4);

			if (value1 != value2 * value3 * value4)
			{
				value1 = value2 * value3 * value4;
			}
			else
			{
				alreadyCalculated(V);
			}
		}
		else if (b1 && b3 && b4)
		{
			value1 = schoberNumber.formatDouble(string1);
			value3 = schoberNumber.formatDouble(string3);
			value4 = schoberNumber.formatDouble(string4);

			value2 = value1 / (value3 * value4);
		}
		else if (b1 && b2 && b4)
		{
			value1 = schoberNumber.formatDouble(string1);
			value2 = schoberNumber.formatDouble(string2);
			value4 = schoberNumber.formatDouble(string4);

			value3 = value1 / (value2 * value4);
		}
		else if (b1 && b2 && SchoberNumber.isDouble(string3))
		{
			value1 = schoberNumber.formatDouble(string1);
			value2 = schoberNumber.formatDouble(string2);
			value3 = schoberNumber.formatDouble(string3);

			value4 = value1 / (value2 * value3);
		}
		else if (b2 && b3 && b4)
		{
			value2 = schoberNumber.formatDouble(string2);
			value3 = schoberNumber.formatDouble(string3);
			value4 = schoberNumber.formatDouble(string4);

			value1 = value2 * value3 * value4;
		}
		else
		{
			funkt = false;
		}

		if (funkt)
		{
			textView1.setText(Vars.decimalFormat.format(value1));
			textView2.setText(Vars.decimalFormat.format(value2));
			textView3.setText(Vars.decimalFormat.format(value3));
			textView4.setText(Vars.decimalFormat.format(value4));
		}
		else
		{
			notEnoughInformation(V);
		}
	}

	public void calculateVelocity(View V)
	{
		calc3(V, R.id.input_speed, R.id.input_distance, R.id.input_time);
	}

	public void calculateLiftingWork(View V)
	{
		calc4(V);
	}

	public void calculateDensity(View V)
	{
		calc3(V, R.id.input_density, R.id.input_mass, R.id.input_volume);
	}

	private void alreadyCalculated(View V)
	{
		Toast toast = Toast.makeText(V.getContext(),
		                             V.getContext().getString(R.string.already_finish),
		                             Toast.LENGTH_LONG);
		toast.show();
	}

	private void notEnoughInformation(View V)
	{
		Toast toast = Toast.makeText(V.getContext(), V.getContext().getString(R.string.not_enough_information),
									 Toast.LENGTH_LONG);
		toast.show();
	}
}