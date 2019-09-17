package at.schiebung.stefan.schober0015;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class LiftingWorkFragment extends Fragment
{
	private final Calculate calculate = new Calculate();

	public LiftingWorkFragment()
	{
		// Required empty public constructor
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View view   = inflater.inflate(R.layout.fragment_lifting_work, container, false);
		Button     button = view.findViewById(R.id.btn_LiftingWork);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				calculate.calculateLiftingWork(view);
			}
		});

		// Inflate the layout for this fragment
		return view;
	}
}
