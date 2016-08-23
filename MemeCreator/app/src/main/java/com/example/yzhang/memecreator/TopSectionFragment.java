package com.example.yzhang.memecreator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yzhang on 8/23/2016.
 */
public class TopSectionFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopSectionListener activityCommander;

    public interface TopSectionListener
    {
        void  submitText(String top,String bottom);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            try
            {
                activityCommander = (TopSectionListener) context;
            }
            catch (ClassCastException e)
            {
                throw new ClassCastException(context.toString());
            }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            try
            {
                activityCommander = (TopSectionListener) activity;
            }
            catch (ClassCastException e)
            {
                throw new ClassCastException(e.getMessage());
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment,container,false);
        topTextInput = (EditText)view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });
        return view;
    }

    public void buttonClicked(View view)
    {
        activityCommander.submitText(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }
}
