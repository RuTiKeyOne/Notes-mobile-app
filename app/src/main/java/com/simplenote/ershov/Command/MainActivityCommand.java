package com.simplenote.ershov.Command;

import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.ActivityMainBinding;

public class MainActivityCommand {

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
