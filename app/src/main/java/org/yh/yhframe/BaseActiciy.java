package org.yh.yhframe;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.yh.library.YHActivity;

/**
 * Created by yhlyl on 2017/4/25.
 */

public abstract class BaseActiciy extends YHActivity
{
    public TextView mTvTitle;//标题
    public Toolbar toolbar;//标题栏
    public ImageView toolbar_right;//标题右边
    public ImageView toolbar_logo;//标题logo

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initWidget()
    {
        super.initWidget();
        try
        {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            mTvTitle = (TextView) findViewById(R.id.toolbar_title);
            toolbar_right = (ImageView) findViewById(R.id.toolbar_right);
            toolbar_logo = (ImageView) findViewById(R.id.toolbar_logo);
            toolbar_right.setOnClickListener(this);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }
        catch (NullPointerException e)
        {
            throw new NullPointerException(
                    "TitleBar Notfound from Activity layout");
        }
    }

    @Override
    public void widgetClick(View v)
    {
        super.widgetClick(v);
        switch (v.getId())
        {
            case R.id.toolbar_right:
                onMenuClick();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onBackClick()
    {
    }

    protected void onMenuClick()
    {
    }
}