package notes.Command;

import androidx.databinding.ViewDataBinding;
import com.notes.R;
import com.notes.databinding.ActivityMainBinding;

public class MainCommand {

    private ActivityMainBinding mainBinding;

    public void onChangeFilter(ViewDataBinding dataBinding){
        if(setMainBinding(dataBinding)){
            onNoFilterClickListener();
            onHighToLowClickListener();
            onLowToHighClickListener();
        }
    }

    private boolean setMainBinding(ViewDataBinding dataBinding){
        if(dataBinding instanceof ActivityMainBinding){
            this.mainBinding = (ActivityMainBinding) dataBinding;
            return true;
        }
        return false;
    }

    private void onNoFilterClickListener(){
        mainBinding.noFilter.setOnClickListener(v -> {
            mainBinding.noFilter.setBackgroundResource(R.drawable.filter_selected_un_shape);
            mainBinding.highToLow.setBackgroundResource(R.drawable.filter_un_shape);
            mainBinding.lowToHigh.setBackgroundResource(R.drawable.filter_un_shape);
        });

    }

    private void onHighToLowClickListener(){
        mainBinding.highToLow.setOnClickListener(v -> {
            mainBinding.noFilter.setBackgroundResource(R.drawable.filter_un_shape);
            mainBinding.highToLow.setBackgroundResource(R.drawable.filter_selected_un_shape);
            mainBinding.lowToHigh.setBackgroundResource(R.drawable.filter_un_shape);
        });
    }

    private void onLowToHighClickListener(){
        mainBinding.lowToHigh.setOnClickListener(v -> {
            mainBinding.noFilter.setBackgroundResource(R.drawable.filter_un_shape);
            mainBinding.highToLow.setBackgroundResource(R.drawable.filter_un_shape);
            mainBinding.lowToHigh.setBackgroundResource(R.drawable.filter_selected_un_shape);
        });
    }


}
