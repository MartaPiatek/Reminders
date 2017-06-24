package pl.martapiatek.reminders;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RemindersActivity extends AppCompatActivity {

    private ListView mListView;
    private RemindersDbAdapter mDbAdapter;
    private RemindersSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        mListView = (ListView) findViewById(R.id.reminders_list_view);
        mListView.setDivider(null);
        mDbAdapter = new RemindersDbAdapter(this);
        mDbAdapter.open();
        if(savedInstanceState == null){
            //wyczyść wszystkie dane
            mDbAdapter.deleteAllReminders();
            //dodaj przykładowe dane
            insertSomeReminders();


        }

        Cursor cursor = mDbAdapter.fetchAllReminders();
        // z kolumn zdefiniowanych w bazie danych
        String[] from  =  new String[]{
                RemindersDbAdapter.COL_CONTENT
        };

        // do identyfikatorów widoków w układzie graficznym
        int[] to = new int[]{
                R.id.row_text
        };

        mCursorAdapter = new RemindersSimpleCursorAdapter(
                //kontekst
                RemindersActivity.this,
                //układ graficzny wiersza
                R.layout.reminders_row,
                //kursor
                cursor,
                // z kolumn zdefiniowanych w bazie danych
                from,
                // do identyfikatorów widoków w układzie graficznym
                to,
                //znacznik - nieużywany
                0);
        // cursorAdapter(kontroler) aktualizuje ListView(widok) danymi z bazy (model)
        mListView.setAdapter(mCursorAdapter);

        // Obiekt arratAdapter jest w tym systemie MVC kontrolerem

    /*    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
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
*/
    }

    private void insertSomeReminders(String name, boolean important) {
        mDbAdapter.createReminder(name, important);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reminders, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_new:
                //utworzenie nowego przypomninia
                Log.d(getLocalClassName(), "utworzenie nowego przypomnienia");
                return true;
            case R.id.action_exit:
                finish();
                return false;
            default:
                return false;
        }
    }
    private void insertSomeReminders() {
        mDbAdapter.createReminder("Zakup książki", true);
        mDbAdapter.createReminder("Wysłanie prezentu ojcu", false);
        mDbAdapter.createReminder("Piątkowy obiad ze znajomymi", false);
        mDbAdapter.createReminder("Gra w squasha", false);
        mDbAdapter.createReminder("Odgarnąć i posolić podjazd", false);
        mDbAdapter.createReminder("Przygotować program zajęć z Androida", true);
        mDbAdapter.createReminder("Kupić nowe krzesło do biura", false);
        mDbAdapter.createReminder("Zadzwonić do mechanika", false);
        mDbAdapter.createReminder("Odnowić członkostwo w klubie", false);
        mDbAdapter.createReminder("Kupić nowy telefon Android Galaxy", true);
        mDbAdapter.createReminder("Sprzedać stary telefon android - aukcja", false);
        mDbAdapter.createReminder("Kupić nowe wiosła do kajaka", false);
        mDbAdapter.createReminder("Zadzwonić do księgowego", false);
        mDbAdapter.createReminder("Kupić 300 000 akcji Google", false);
        mDbAdapter.createReminder("Oddzwonić do Dalai Lamy", true);
    }
}
