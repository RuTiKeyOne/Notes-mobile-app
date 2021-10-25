package notes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.notes.R;
import com.notes.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding searchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponents();
        initializationComponentsView();
        onBackClick();
    }


    private void initializationComponents(){

    }

    private void initializationComponentsView(){
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
    }

    private void onBackClick(){
        searchBinding.imageBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}