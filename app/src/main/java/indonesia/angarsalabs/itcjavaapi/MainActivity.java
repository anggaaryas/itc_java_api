package indonesia.angarsalabs.itcjavaapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import indonesia.angarsalabs.itcjavaapi.model.EventsItem;
import indonesia.angarsalabs.itcjavaapi.service.SportService;

public class MainActivity extends AppCompatActivity implements JadwalListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SportService().getJadwal(this);
    }

    @Override
    public void onSuccess(List<EventsItem> items) {
        for(int i = 0;i < items.size(); i++){
            Log.i("ISI DATA", items.get(i).getStrEvent());
        }
    }

    @Override
    public void onFailed(String msg) {
        Log.i("ISI ERROR", msg);
    }
}
