package notes.Command;

import androidx.databinding.ViewDataBinding;

import com.notes.R;
import com.notes.databinding.ActivityMainBinding;

public class MainCommand {

    public void setDefaultFilter(ActivityMainBinding mainBinding) {
        onSetDefaultNoFilterView(mainBinding);
    }

    public void onSetDefaultNoFilterView(ActivityMainBinding mainBinding) {
        mainBinding.noFilter.setBackgroundResource(R.drawable.filter_selected_un_shape);
        mainBinding.highToLow.setBackgroundResource(R.drawable.filter_un_shape);
        mainBinding.lowToHigh.setBackgroundResource(R.drawable.filter_un_shape);
    }

    public void onSetHighToLowFilterView(ActivityMainBinding mainBinding) {
        mainBinding.noFilter.setBackgroundResource(R.drawable.filter_un_shape);
        mainBinding.highToLow.setBackgroundResource(R.drawable.filter_selected_un_shape);
        mainBinding.lowToHigh.setBackgroundResource(R.drawable.filter_un_shape);
    }

    public void onSetLowToHighFilterView(ActivityMainBinding mainBinding) {
        mainBinding.noFilter.setBackgroundResource(R.drawable.filter_un_shape);
        mainBinding.highToLow.setBackgroundResource(R.drawable.filter_un_shape);
        mainBinding.lowToHigh.setBackgroundResource(R.drawable.filter_selected_un_shape);
    }

}
