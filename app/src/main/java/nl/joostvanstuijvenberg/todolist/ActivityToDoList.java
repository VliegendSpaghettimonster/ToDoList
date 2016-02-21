package nl.joostvanstuijvenberg.todolist;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityToDoList extends AppCompatActivity implements FragmentNewItem.ItemListener {

    private ArrayList<String> items = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        FragmentManager m = getFragmentManager();
        FragmentItemList l = (FragmentItemList) m.findFragmentById(R.id.FragmentItemList);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        l.setListAdapter(adapter);
    }

    @Override
    public void NewItemAdded(String item) {
        items.add(item);
        Log.i("ToDoList", "Item " + item + " toegevoegd.");
        adapter.notifyDataSetChanged();
    }

}
