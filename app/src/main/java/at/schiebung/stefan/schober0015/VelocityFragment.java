package at.schiebung.stefan.schober0015;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class VelocityFragment extends Fragment
{
	private Calculate calcu = new Calculate();

	public VelocityFragment()
	{
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View view   = inflater.inflate(R.layout.fragment_velocity, container, false);
		Button     button = (Button) view.findViewById(R.id.btn_Velocity);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				calcu.calculateVelocity(view);
			}
		});

		// Inflate the layout for this fragment
		return view;
	}
}
