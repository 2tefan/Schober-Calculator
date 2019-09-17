package at.schiebung.stefan.schober0015;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DensityFragment extends Fragment
{
	private final Calculate calculate = new Calculate();

	public DensityFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View view   = inflater.inflate(R.layout.fragment_density, container, false);
		Button     button = view.findViewById(R.id.btn_Density);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				calculate.calculateDensity(view);
			}
		});
		// Inflate the layout for this fragment
		return view;
	}
}
