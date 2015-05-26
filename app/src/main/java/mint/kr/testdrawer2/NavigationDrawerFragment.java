package mint.kr.testdrawer2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavigationDrawerFragment extends Fragment
{
  private NavigationDrawerCallbacks mCallbacks;
  private ActionBarDrawerToggle mActionBarDrawerToggle;

  private DrawerLayout mDrawerLayout;
  private View mFragmentContainerView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
    View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    view.findViewById(R.id.text_home).setOnClickListener(clickListener);
    view.findViewById(R.id.text_message).setOnClickListener(clickListener);
    return view;
  }

  public boolean isDrawerOpen()
  {
    return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
  }

  /**
   * Users of this fragment must call this method to set up the navigation drawer interactions.
   *
   * @param fragmentId   The android:id of this fragment in its activity's layout.
   * @param drawerLayout The DrawerLayout containing this fragment's UI.
   * @param toolbar      The Toolbar of the activity.
   */
  public void setup(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar)
  {
    mFragmentContainerView = (View) getActivity().findViewById(fragmentId).getParent();
    mDrawerLayout = drawerLayout;

    mActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
    mActionBarDrawerToggle.setDrawerIndicatorEnabled(false);
    mDrawerLayout.post(new Runnable()
    {
      @Override
      public void run()
      {
        mActionBarDrawerToggle.syncState();
      }
    });
    mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
  }

  private void selectItem(int position)
  {
    if (mDrawerLayout != null)
    {
      mDrawerLayout.closeDrawer(mFragmentContainerView);
    }

    if (mCallbacks != null)
    {
      mCallbacks.onNavigationDrawerItemSelected(position);
    }
  }

  public void closeDrawer()
  {
    mDrawerLayout.closeDrawer(mFragmentContainerView);
  }

  public void openDrawer()
  {
    mDrawerLayout.openDrawer(mFragmentContainerView);
  }

  public void setNavigationDrawerCallback(NavigationDrawerCallbacks callback)
  {
    mCallbacks = callback;
  }

  ////////////////////////////////////////
  // listener
  ///////////////////////////////////////
  private View.OnClickListener clickListener = new View.OnClickListener()
  {
    @Override
    public void onClick(View view)
    {
      if (view.getId() == R.id.text_home)
      {
        selectItem(0);
      }
      else if (view.getId() == R.id.text_message)
      {
        selectItem(1);
      }
    }
  };

  ////////////////////////////////////////
  // interface
  ///////////////////////////////////////
  public interface NavigationDrawerCallbacks
  {
    void onNavigationDrawerItemSelected(int position);
  }
}
