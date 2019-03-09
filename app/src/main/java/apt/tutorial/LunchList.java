package apt.tutorial;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class LunchList extends Activity {
    //Restaurant r = new Restaurant();
    ArrayList<Restaurant> model = new ArrayList<>();
    // Khai bao doi tuong ArrayAdapter
    ArrayAdapter<Restaurant> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        RadioGroup types = (RadioGroup) findViewById(R.id.types);
        types.setOnCheckedChangeListener(new TypesListener());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, model);
        ListView list = (ListView) findViewById(R.id.restaurants);
        list.setAdapter(adapter);
/*adapter =  new ArrayAdapter<>(this , android.R.layout.simple_spinner_item,model);
        Spinner spn =(Spinner)findViewById(R.id.restaurants);
        spn.setAdapter(adapter);*/
    }// end of onCreate

    class TypesListener implements
            RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            ImageView ivType = (ImageView) findViewById(R.id.iv_type);
            switch (checkedId) {
                case R.id.sit_down:
                    ivType.setImageResource(R.drawable.sitdown); //hien thi anh theo tung radio button
                    break;
                case R.id.take_out:
                    ivType.setImageResource(R.drawable.takeout);
                    break;
                case R.id.delivery:
                    ivType.setImageResource(R.drawable.delivery);
                    break;
            }
        }
    }

    public void btSaveProcess(View v) {
        Restaurant r = new Restaurant();
        Log.d("myLog", "Button Save Click");
        EditText etName = (EditText) findViewById(R.id.name);
        String strName = etName.getText().toString();
        r.setName(strName);

        EditText etAddress = (EditText) findViewById(R.id.addr);
        String strAddress = etAddress.getText().toString();
        r.setAddress(strAddress);
        RadioGroup types = (RadioGroup) findViewById(R.id.types);
        switch (types.getCheckedRadioButtonId()) {
            case R.id.sit_down:
                r.setType("sit_down");
                break;
            case R.id.take_out:
                r.setType("take_out");
                break;
            case R.id.delivery:
                r.setType("delivery");
                break;
        }


        Toast.makeText(LunchList.this, r.toString(), Toast.LENGTH_SHORT).show();
        adapter.add(r);
    }


}


