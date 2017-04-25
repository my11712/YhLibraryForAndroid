package org.yh.yhframe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.yh.library.utils.LogUtils;

public class FourFragment extends BaseFragment
{

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
    {
        return inflater.inflate(R.layout.fragment_four, container, false);
    }


    @Override
    protected void setActionBarRes(ActionBarRes actionBarRes)
    {
        actionBarRes.title = TAG;
    }

    @Override
    public void onChange()
    {
        super.onChange();
        LogUtils.e(TAG, "FourFragment onChange()");
    }
}
