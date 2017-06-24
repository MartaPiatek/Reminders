package pl.martapiatek.reminders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RemindersActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        mListView = (ListView) findViewById(R.id.reminders_list_view);
        // Obiekt arratAdapter jest w tym systemie MVC kontrolerem

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                //kontekst
                this,
                //układ graficzny (widok)
                R.layout.reminders_row,
                //wiersz (widok)
                R.id.row_text,
                //dane (model) z testowymi danymi przekazywanymi do listView
                new String[]{"pierwszy wiersz", "drugi wiersz", "trzeci wiersz"}
        );
        mListView.setAdapter(arrayAdapter);

    }
}
