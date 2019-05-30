package at.schiebung.stefan.schober0015;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class VelocityFragment extends Fragment
{
	private final Calculate calculate = new Calculate();

	public VelocityFragment()
	{
		// Required empty public constructor
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View view   = inflater.inflate(R.layout.fragment_velocity, container, false);
		Button     button = view.findViewById(R.id.btn_Velocity);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				calculate.calculateVelocity(view);
			}
		});

		// Inflate the layout for this fragment
		return view;
	}
}
