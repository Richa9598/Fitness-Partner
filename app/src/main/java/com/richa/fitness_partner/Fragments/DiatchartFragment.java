package com.richa.fitness_partner.Fragments;

import static com.richa.fitness_partner.Fragments.Diat_selection_fragment.type_diat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.richa.fitness_partner.R;

import java.util.ArrayList;

public class DiatchartFragment extends Fragment {
    private LinearLayout llVeg;
    private LinearLayout llNonveg;
    PieChart pieChart;
    PieChart pieChart2;
    ArrayList<PieEntry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;
    int LightDimmerLevel = 2;
    int NumberofLights = 2;
    int result;
    ArrayList<Integer> lightResult;

    public DiatchartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.diatchart_fragment, container, false);
        llVeg = (LinearLayout) rootView.findViewById(R.id.llVeg);
        llNonveg = (LinearLayout) rootView.findViewById(R.id.llNonveg);
        pieChart = rootView.findViewById(R.id.pieChart);
        pieChart2 = rootView.findViewById(R.id.pieChart2);
        // array of images
        ArrayList<Drawable> array_image = new ArrayList<Drawable>();
        if (type_diat == 1) {
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.oats));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.veggies));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.meal));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.fruits));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.soup));
        } else if (type_diat == 2) {
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.egg));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.milk_egg));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.chicken));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.fruits));
            array_image.add(ContextCompat.getDrawable(getActivity(), R.drawable.non_soup));
        }

        // array of graph percentage value
        ArrayList<String> array_time = new ArrayList<String>();
        array_time.add("9 am ");
        array_time.add("11 am");
        array_time.add("1 pm");
        array_time.add("4 pm");
        array_time.add("8 pm");


        // array of graph drawing size according to design
        ArrayList<Float> array_drawGraph = new ArrayList<Float>();
        array_drawGraph.add((float) 20);
        array_drawGraph.add((float) 20);
        array_drawGraph.add((float) 20);
        array_drawGraph.add((float) 20);
        array_drawGraph.add((float) 20);

        // array of graph different colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(ContextCompat.getColor(getActivity(), R.color.pinkdark));
        colors.add(ContextCompat.getColor(getActivity(), R.color.greendark));
        colors.add(ContextCompat.getColor(getActivity(), R.color.bluedark));
        colors.add(ContextCompat.getColor(getActivity(), R.color.orangdark));
        colors.add(ContextCompat.getColor(getActivity(), R.color.violatedark));

        // Now adding array of data to the entery set
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        // count is the number of values you need to display into graph
        for (int i = 0; i < 5; i++) {
            // entries.add(new PieEntry(array_drawGraph.get(i), array_percent.get(i)));
            entries.add(new PieEntry(array_drawGraph.get(i), array_time.get(i), array_image.get(i)));
        }
        // initializing pie data set
        PieDataSet dataset = new PieDataSet(entries, "");
        // set the data
        PieData data = new PieData(dataset);        // initialize Piedata
        pieChart.setData(data);
        // colors according to the dataset
        dataset.setColors(colors);
        // adding legends to the desigred positions
        Legend l = pieChart.getLegend();
        l.setTextSize(14f);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setTextColor(Color.WHITE);
        l.setEnabled(true);
        // calling method to set center text
        // if no need to add description
        pieChart.setCenterText(generateCenterSpannableText2());
        pieChart.getDescription().setEnabled(false);
        // animation and the center text color
        pieChart.animateY(5000);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setEntryLabelTextSize(4f);


        ArrayList<Drawable> array_image2 = new ArrayList<Drawable>();
        array_image2.add(ContextCompat.getDrawable(getActivity(), R.drawable.dummy));
        array_image2.add(ContextCompat.getDrawable(getActivity(), R.drawable.dummy));
        array_image2.add(ContextCompat.getDrawable(getActivity(), R.drawable.dummy));
        array_image2.add(ContextCompat.getDrawable(getActivity(), R.drawable.dummy));
        array_image2.add(ContextCompat.getDrawable(getActivity(), R.drawable.dummy));
        // array of graph percentage value
        ArrayList<String> array_time2 = new ArrayList<String>();
        array_time2.add("4.6 \n Fat");
        array_time2.add("40 Cal ");
        array_time2.add("40 Sod");
        array_time2.add("11 Car");
        array_time2.add("4.4 Pro");


        // array of graph drawing size according to design
        ArrayList<Float> array_drawGraph2 = new ArrayList<Float>();
        array_drawGraph2.add((float) 4.6);
        array_drawGraph2.add((float) 40);
        array_drawGraph2.add((float) 30);
        array_drawGraph2.add((float) 11);
        array_drawGraph2.add((float) 14.4);

        // array of graph different colors
        ArrayList<Integer> colors2 = new ArrayList<Integer>();
        colors2.add(ContextCompat.getColor(getActivity(), R.color.pink));
        colors2.add(ContextCompat.getColor(getActivity(), R.color.blue));
        colors2.add(ContextCompat.getColor(getActivity(), R.color.orang));
        colors2.add(ContextCompat.getColor(getActivity(), R.color.green));
        colors2.add(ContextCompat.getColor(getActivity(), R.color.violate));

        // Now adding array of data to the entery set
        ArrayList<PieEntry> entries2 = new ArrayList<PieEntry>();
        // count is the number of values you need to display into graph
        for (int i = 0; i < 5; i++) {
            // entries.add(new PieEntry(array_drawGraph.get(i), array_percent.get(i)));
            entries2.add(new PieEntry(array_drawGraph2.get(i), array_time2.get(i)));
        }
        // initializing pie data set
        PieDataSet dataset2 = new PieDataSet(entries2, "");
        // set the data
        PieData data2 = new PieData(dataset2);        // initialize Piedata
        pieChart2.setData(data2);
        // colors according to the dataset
        dataset2.setColors(colors2);
        // adding legends to the desigred positions
        Legend l2 = pieChart2.getLegend();
        l2.setTextSize(14f);
        l2.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l2.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l2.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l2.setDrawInside(false);
        l2.setTextColor(Color.WHITE);
        l2.setEnabled(true);
        // calling method to set center text
        pieChart2.setCenterText(generateCenterSpannableText());

        // if no need to add description
        pieChart2.getDescription().setEnabled(false);
        // animation and the center text color
        pieChart2.animateY(5000);
        pieChart2.setEntryLabelColor(Color.WHITE);
        pieChart2.setEntryLabelTextSize(19f);
        return rootView;
    }


    // If we need to display center text with textStyle
    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("(kcals/day)\n2500");
        s.setSpan(new RelativeSizeSpan(2f), 11, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.BOLD), 11, s.length(), 0);
        return s;
    }

    private SpannableString generateCenterSpannableText2() {
        SpannableString s = new SpannableString(" ");
        if (type_diat == 1) {
            s = new SpannableString("vegetarian\ndiet");
            s.setSpan(new RelativeSizeSpan(2f), 11, s.length(), 0);
            s.setSpan(new StyleSpan(Typeface.BOLD), 11, s.length(), 0);
        } else if (type_diat == 2) {
            s = new SpannableString("Non-veg\ndiet");
            s.setSpan(new RelativeSizeSpan(2f), 11, s.length(), 0);
            s.setSpan(new StyleSpan(Typeface.BOLD), 11, s.length(), 0);
        }

        return s;
    }

}