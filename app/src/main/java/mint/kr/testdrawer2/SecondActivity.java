package mint.kr.testdrawer2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends BaseActivity
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_second);
    putContentView(R.layout.activity_second);

    TextView text1 = (TextView) findViewById(R.id.text_hello);
    text1.setText("aaaa");

    Button btn = (Button) findViewById(R.id.button);
    btn.setText("aaa");
    btn.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        Log.i("SecondActivity | onClick", "|" + "==================" + "|");
      }
    });
  }

}
