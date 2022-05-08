package com.example.budgetmanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonthlySummary#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonthlySummary extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MonthlySummary() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PieChart.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthlySummary newInstance(String param1, String param2) {
        MonthlySummary fragment = new MonthlySummary();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_monthly_summary, container, false);

        // Allow the main activity to find the pie chart and progress bar IDs to render
        AnyChartView chart = viewFragment.findViewById(R.id.pie_chart);
        chart.setProgressBar(viewFragment.findViewById(R.id.pie_chart_loading_status));

        // Instance of a pie chart
        Pie pie = AnyChart.pie();

        // Pie chart list data
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Groceries", 200));
        data.add(new ValueDataEntry("Shopping", 100));
        data.add(new ValueDataEntry("Entertainment", 50));
        data.add(new ValueDataEntry("Gas", 75));

        // Add the data to the pie chart
        pie.data(data);

        // Set pie chart title
        pie.title("Pie Chart Visual Representation");

        // Set the pie chart labels outside the chart
        pie.labels().position("outside");

        // Set pie chart legend title
        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Budget Categories")
                .padding(0d, 0d, 10d, 0d);

        // Set pie chart legend item alignment
        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        // Set the chart to display as a pie chart
        chart.setChart(pie);

        return viewFragment;
    }
}