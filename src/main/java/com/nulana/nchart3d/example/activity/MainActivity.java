package com.nulana.nchart3d.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nulana.nchart3d.example.adapter.ChartTypeAdapter;
import com.nulana.nchart3d.example.differentCharts.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * @author catherine.brainwilliam
 * @since 2018/11/8
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_chart_type)
    RecyclerView rvChartType;

    private ChartTypeAdapter chartTypeAdapter;
    private List<String> chartTypes;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        chartTypes = new ArrayList<>();
        chartTypes = getAllChartType();
        chartTypeAdapter = new ChartTypeAdapter(this, chartTypes);
        rvChartType.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvChartType.setLayoutManager(linearLayoutManager);
        rvChartType.setAdapter(chartTypeAdapter);
        chartTypeAdapter.setItemSelectListener(new ChartTypeAdapter.ItemSelectListener() {
            @Override
            public void onItemSelect(int position) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ChartingActivity.class);
                intent.putExtra("type", chartTypes.get(position));
                startActivity(intent);
            }
        });

    }

    private List<String> getAllChartType() {
        String[] allType = {
                // 2D types.
                "Column2D",
                "Bar2D",
                "Area2D",
                "Pie2D",
                "Doughnut2D",
                "Line2D",
                "Step2D",
                "Bubble2D",
                "Candlestick2D",
                "OHLC2D",
                "Band",               // Only in 2D
                "Sequence",           // Only in 2D
                "Radar",              // Only in 2D
                "Heatmap",            // Only in 2D
                "Funnel2D",
                // 3D types.
                "Column3D",
                "Bar3D",
                "Area3D",
                "Pie3D",
                "Doughnut3D",
                "Line3D",
                "Ribbon",             // Only in 3D
                "Step3D",
                "Bubble3D",
                "Surface",            // Only in 3D
                "Candlestick3D",
                "OHLC3D",
                "Funnel3D"};
        chartTypes.addAll(Arrays.asList(allType));
        return chartTypes;

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void getArgs(Bundle bundle) {

    }
}
