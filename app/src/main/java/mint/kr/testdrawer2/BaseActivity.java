package mint.kr.testdrawer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class BaseActivity extends AppCompatActivity
{
  protected ImageButton btnActionBarMenu, btnActionbarBack;
  protected TextView textActionBarMessageCount;
  private NavigationDrawerFragment mNavigationDrawerFragment;
  private ViewGroup container;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
    toolbar.setContentInsetsAbsolute(0, 0);
    TextView titleView = (TextView) findViewById(R.id.toolbar_title);
    titleView.setText(getTitle());
    btnActionBarMenu = (ImageButton) findViewById(R.id.btn_actionbar_menu);
    btnActionBarMenu.setVisibility(View.VISIBLE);
    btnActionBarMenu.setOnClickListener(clickListener);
    btnActionbarBack = (ImageButton) findViewById(R.id.btn_actionbar_back);
    btnActionbarBack.setOnClickListener(clickListener);
    textActionBarMessageCount = (TextView) findViewById(R.id.text_actionbar_message_count);
    textActionBarMessageCount.setVisibility(View.VISIBLE);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
    mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), toolbar);
    mNavigationDrawerFragment.setNavigationDrawerCallback(navigationDrawerCallbacks);

    container = (ViewGroup) findViewById(R.id.container);
  }

  protected void putContentView(int resId)
  {
    container.addView(getLayoutInflater().inflate(resId, null));
  }


  @Override
  public void onBackPressed()
  {
    if (mNavigationDrawerFragment.isDrawerOpen())
    {
      mNavigationDrawerFragment.closeDrawer();
    }
    else
    {
      super.onBackPressed();
    }
  }

  ////////////////////////////////////////
  // listener
  ///////////////////////////////////////
  private View.OnClickListener clickListener = new View.OnClickListener()
  {
    @Override
    public void onClick(View view)
    {
      if (view.getId() == btnActionBarMenu.getId())
      {
        mNavigationDrawerFragment.openDrawer();
      }
    }
  };

  private NavigationDrawerFragment.NavigationDrawerCallbacks navigationDrawerCallbacks = new NavigationDrawerFragment.NavigationDrawerCallbacks()
  {
    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
      Toast.makeText(BaseActivity.this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
      if (position == 0)
      {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
      }
      else if (position == 1)
      {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
      }
    }
  };
}
