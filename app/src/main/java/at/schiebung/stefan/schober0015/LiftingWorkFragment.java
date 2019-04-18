package at.schiebung.stefan.schober0015;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LiftingWorkFragment extends Fragment
{
	private Calculate calcu = new Calculate();

	public LiftingWorkFragment()
	{
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View   view   = inflater.inflate(R.layout.fragment_lifting_work, container, false);
		Button button = (Button) view.findViewById(R.id.btn_LiftingWork);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				calcu.calculateLiftingWork(view);
			}
		});

		// Inflate the layout for this fragment
		return view;
	}
}
