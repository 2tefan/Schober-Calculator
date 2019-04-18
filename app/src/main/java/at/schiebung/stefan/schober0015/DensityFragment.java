package at.schiebung.stefan.schober0015;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DensityFragment extends Fragment
{
	private Calculate calcu = new Calculate();

	public DensityFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View view   = inflater.inflate(R.layout.fragment_density, container, false);
		Button     button = (Button) view.findViewById(R.id.btn_Density);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				calcu.calculateDensity(view);
			}
		});
		// Inflate the layout for this fragment
		return view;
	}
}
