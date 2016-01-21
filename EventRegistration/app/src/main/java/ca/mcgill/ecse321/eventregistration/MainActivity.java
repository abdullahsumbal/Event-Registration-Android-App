package ca.mcgill.ecse321.eventregistration;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.InvalidPropertiesFormatException;

import ca.mcgill.ecse321.eventregistrationcontroller.EventRegistrationController;
import ca.mcgill.ecse321.eventregistrationcontroller.InvalidInputException;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // spinner = (Spinner)findViewById(R.id.participantspinner);
        //adapter = ArrayAdapter.createFromResource(this,R.array.Paraticipants,android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        refreshData();
    }

    private void refreshData(){
        TextView tv = (TextView) findViewById(R.id.newparticpant_name);
        TextView tv2 = (TextView) findViewById(R.id.newevent_name);
        tv.setText("");
        tv2.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   // Method for adding participant
    public void addParticipant(View v){
        TextView tv = (TextView) findViewById(R.id.newparticpant_name);
        EventRegistrationController pc = new EventRegistrationController();
        try{
            pc.CreateParticipant(tv.getText().toString());
        }catch(InvalidInputException e ){
            //TODO handle error
        }
        refreshData();
    }

    // Method for adding events
     public void addEvent(View v){
         TextView tv = (TextView) findViewById(R.id.newevent_name);
         TextView Date = (TextView)findViewById(R.id.newevent_date);
         TextView ST = (TextView)findViewById(R.id.starttime);
         TextView ET = (TextView)findViewById(R.id.endtime);
         EventRegistrationController pc = new EventRegistrationController();
        
         refreshData();
     }


}
