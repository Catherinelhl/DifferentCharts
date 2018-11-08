package com.nulana.nchart3d.example.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nulana.nchart3d.example.differentCharts.R;

import java.util.List;

/**
 * @author catherine.brainwilliam
 * @since 2018/11/8
 */
public class ChartTypeAdapter extends RecyclerView.Adapter<ChartTypeAdapter.viewHolder> {
    private Context context;
    private List<String> list;

    private ItemSelectListener itemSelectListener;


    public ChartTypeAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        System.out.println(list.size());
    }

    public void setItemSelectListener(ItemSelectListener itemSelectListener) {
        this.itemSelectListener = itemSelectListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chart_list, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, final int i) {
        if (list == null) {
            return;
        }
        String chartType = list.get(i);
        viewHolder.tvChartList.setText(chartType);
        viewHolder.tvChartList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelectListener.onItemSelect(i);
            }
        });
        viewHolder.llChartList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelectListener.onItemSelect(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        private TextView tvChartList;
        private LinearLayout llChartList;

        public viewHolder(View view) {
            super(view);
            tvChartList = view.findViewById(R.id.tv_chart_list);
            llChartList = view.findViewById(R.id.ll_chart_list);
        }
    }

    public interface ItemSelectListener {
        void onItemSelect(int position);
    }
}