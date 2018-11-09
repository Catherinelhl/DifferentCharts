/**
 * Disclaimer: IMPORTANT:  This Nulana software is supplied to you by Nulana
 * LTD ("Nulana") in consideration of your agreement to the following
 * terms, and your use, installation, modification or redistribution of
 * this Nulana software constitutes acceptance of these terms.  If you do
 * not agree with these terms, please do not use, install, modify or
 * redistribute this Nulana software.
 * <p>
 * In consideration of your agreement to abide by the following terms, and
 * subject to these terms, Nulana grants you a personal, non-exclusive
 * license, under Nulana's copyrights in this original Nulana software (the
 * "Nulana Software"), to use, reproduce, modify and redistribute the Nulana
 * Software, with or without modifications, in source and/or binary forms;
 * provided that if you redistribute the Nulana Software in its entirety and
 * without modifications, you must retain this notice and the following
 * text and disclaimers in all such redistributions of the Nulana Software.
 * Except as expressly stated in this notice, no other rights or licenses,
 * express or implied, are granted by Nulana herein, including but not limited
 * to any patent rights that may be infringed by your derivative works or by other
 * works in which the Nulana Software may be incorporated.
 * <p>
 * The Nulana Software is provided by Nulana on an "AS IS" basis.  NULANA
 * MAKES NO WARRANTIES, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION
 * THE IMPLIED WARRANTIES OF NON-INFRINGEMENT, MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE, REGARDING THE NULANA SOFTWARE OR ITS USE AND
 * OPERATION ALONE OR IN COMBINATION WITH YOUR PRODUCTS.
 * <p>
 * IN NO EVENT SHALL NULANA BE LIABLE FOR ANY SPECIAL, INDIRECT, INCIDENTAL
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) ARISING IN ANY WAY OUT OF THE USE, REPRODUCTION,
 * MODIFICATION AND/OR DISTRIBUTION OF THE NULANA SOFTWARE, HOWEVER CAUSED
 * AND WHETHER UNDER THEORY OF CONTRACT, TORT (INCLUDING NEGLIGENCE),
 * STRICT LIABILITY OR OTHERWISE, EVEN IF NULANA HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * <p>
 * Copyright (C) 2018 Nulana LTD. All Rights Reserved.
 */

package com.nulana.nchart3d.example.differentCharts;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.nulana.NChart.NChartCandlestickSeries;
import com.nulana.NChart.NChartCandlestickSeriesSettings;
import com.nulana.NChart.NChartMargin;
import com.nulana.NChart.NChartPoint;
import com.nulana.NChart.NChartPointState;
import com.nulana.NChart.NChartSeries;
import com.nulana.NChart.NChartSeriesDataSource;
import com.nulana.NChart.NChartView;

import java.util.ArrayList;
import java.util.Random;

/**
 * 2D k线图
 */
public class Candlestick2DChartController implements NChartSeriesDataSource {
    NChartView mNChartView;

    Random random = new Random();

    public Candlestick2DChartController(NChartView view) {
        mNChartView = view;
    }

    public void updateData() {
        // Switch on antialiasing.
        mNChartView.getChart().setShouldAntialias(true);

        mNChartView.getChart().getCartesianSystem().setMargin(new NChartMargin(0.0f, 0.0f, 0.0f, 0.0f));
        mNChartView.getChart().getPolarSystem().setMargin(new NChartMargin(0.0f, 0.0f, 0.0f, 0.0f));

        // Create series that will be displayed on the chart.
        createSeries();

        // Update data in the chart.
        mNChartView.getChart().updateData();
    }

    void createSeries() {
        NChartCandlestickSeries series = new NChartCandlestickSeries();
        series.setDataSource(this);
        series.tag = 0;
        series.setPositiveColor(Color.RED);
        series.setPositiveBorderColor(Color.RED);
        series.setNegativeColor(Color.GREEN);
        series.setNegativeBorderColor(Color.GREEN);
        series.setBorderThickness(1.0f);
        mNChartView.getChart().addSeries(series);

        NChartCandlestickSeriesSettings settings = new NChartCandlestickSeriesSettings();
//        settings.setCylindersResolution(10);
        mNChartView.getChart().addSeriesSettings(settings);

        mNChartView.getChart().getCartesianSystem().getXAxis().setHasOffset(true);
        mNChartView.getChart().getCartesianSystem().getYAxis().setHasOffset(false);
        mNChartView.getChart().getCartesianSystem().getZAxis().setHasOffset(true);
    }

    public NChartPoint[] points(NChartSeries series) {
        // Create points with some data for the series.
        ArrayList<NChartPoint> result = new ArrayList<NChartPoint>();

        for (int i = 0; i < 30; ++i) {
            double open = 5.0f * Math.sin((float) i * Math.PI / 10.0);
            double close = 5.0f * Math.cos((float) i * Math.PI / 10.0);
            double low = Math.min(open, close) - random.nextInt(3);
            double high = Math.max(open, close) + random.nextInt(3);

            result.add(new NChartPoint(NChartPointState.PointStateAlignedToXZWithXZLowOpenCloseHigh(i, series.tag, low, open, close, high), series));
        }

        return result.size() > 0 ? result.toArray(new NChartPoint[result.size()]) : null;
    }

    public NChartPoint[] extraPoints(NChartSeries series) {
        return null;
    }

    public String name(NChartSeries series) {
        return String.format("My series #%d", series.tag + 1);
    }

    public Bitmap image(NChartSeries series) {
        return null;
    }
}
