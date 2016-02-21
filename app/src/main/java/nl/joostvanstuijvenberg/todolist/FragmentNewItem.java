package nl.joostvanstuijvenberg.todolist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentNewItem extends Fragment {

    public interface ItemListener {
        public void NewItemAdded(String item);
    }

    private ItemListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemListener)
            listener = (ItemListener)context;
        else
            throw new ClassCastException("Context moet ItemListener implementeren.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_item, container, false);
        final EditText e = (EditText)v.findViewById(R.id.newItemEditText);
        e.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        String i = e.getText().toString();
                        listener.NewItemAdded(i);
                        e.setText("");
                        return true;
                    }
                return false;
            }
        });
        return v;
    }

}
