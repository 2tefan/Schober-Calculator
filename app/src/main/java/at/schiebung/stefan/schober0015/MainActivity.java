package at.schiebung.stefan.schober0015;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
	private final Methods               methods = new Methods();
	private       DrawerLayout          mDrawer;
	private       Toolbar               toolbar;
	private       ActionBarDrawerToggle drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setupNavbar();
		methods.dfSetup();
	}
	private void setupNavbar()
	{
		// Set a Toolbar to replace the ActionBar.
		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		// Find our drawer view
		NavigationView nvDrawer = findViewById(R.id.nvView);

		// Setup drawer view
		setupDrawerContent(nvDrawer);

		// Find our drawer view
		mDrawer = findViewById(R.id.drawer_layout);
		drawerToggle = setupDrawerToggle();

		// Tie DrawerLayout events to the ActionBarToggle
		mDrawer.addDrawerListener(drawerToggle);

		//Open Main on start
		selectDrawerItem(nvDrawer.getMenu().findItem(R.id.nav_main));
	}


	private ActionBarDrawerToggle setupDrawerToggle()
	{
		// NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
		// and will not render the hamburger icon without it.
		return new ActionBarDrawerToggle(this,
		                                 mDrawer,
		                                 toolbar,
		                                 R.string.drawer_open,
		                                 R.string.drawer_close);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(@NonNull Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onBackPressed()
	{
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START))
		{
			drawer.closeDrawer(GravityCompat.START);
		}
		else
		{
			super.onBackPressed();
		}
	}

	private void setupDrawerContent(NavigationView navigationView)
	{
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
		{
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
			{
				selectDrawerItem(menuItem);
				return true;
			}
		});
	}

	private void selectDrawerItem(MenuItem menuItem)
	{
		// Create a new fragment and specify the fragment to show based on nav item clicked
		Class fragmentClass;
		switch (menuItem.getItemId())
		{
			case R.id.nav_main:
				fragmentClass = MainFragment.class;
				break;
			case R.id.nav_velocity:
				fragmentClass = VelocityFragment.class;
				break;
			case R.id.nav_liftingwork:
				fragmentClass = LiftingWorkFragment.class;
				break;
			case R.id.nav_density:
				fragmentClass = DensityFragment.class;
				break;
			default:
				fragmentClass = MainFragment.class;
		}

		Fragment fragment = null;
		try
		{
			fragment = (Fragment) fragmentClass.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		// Insert the fragment by replacing any existing fragment
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.flContent, Objects.requireNonNull(fragment)).commit();

		// Highlight the selected item has been done by NavigationView
		menuItem.setChecked(true);
		// Set action bar title
		setTitle(menuItem.getTitle());
		// Close the navigation drawer
		mDrawer.closeDrawers();
	}
}
