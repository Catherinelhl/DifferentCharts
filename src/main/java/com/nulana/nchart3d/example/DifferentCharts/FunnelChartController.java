/**
 * Disclaimer: IMPORTANT:  This Nulana software is supplied to you by Nulana
 * LTD ("Nulana") in consideration of your agreement to the following
 * terms, and your use, installation, modification or redistribution of
 * this Nulana software constitutes acceptance of these terms.  If you do
 * not agree with these terms, please do not use, install, modify or
 * redistribute this Nulana software.
 *
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
 *
 * The Nulana Software is provided by Nulana on an "AS IS" basis.  NULANA
 * MAKES NO WARRANTIES, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION
 * THE IMPLIED WARRANTIES OF NON-INFRINGEMENT, MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE, REGARDING THE NULANA SOFTWARE OR ITS USE AND
 * OPERATION ALONE OR IN COMBINATION WITH YOUR PRODUCTS.
 *
 * IN NO EVENT SHALL NULANA BE LIABLE FOR ANY SPECIAL, INDIRECT, INCIDENTAL
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) ARISING IN ANY WAY OUT OF THE USE, REPRODUCTION,
 * MODIFICATION AND/OR DISTRIBUTION OF THE NULANA SOFTWARE, HOWEVER CAUSED
 * AND WHETHER UNDER THEORY OF CONTRACT, TORT (INCLUDING NEGLIGENCE),
 * STRICT LIABILITY OR OTHERWISE, EVEN IF NULANA HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright (C) 2018 Nulana LTD. All Rights Reserved.
 */
 
package com.nulana.nchart3d.example.DifferentCharts;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.nulana.NChart.*;

import java.util.ArrayList;
import java.util.Random;

public class FunnelChartController implements NChartSeriesDataSource {
    NChartView mNChartView;
    boolean drawIn3D;
    NChartBrush[] brushes;

    Random random = new Random();

    public FunnelChartController(boolean is3D, NChartView view) {
        mNChartView = view;
        drawIn3D = is3D;
        // Create brushes.
        brushes = new NChartBrush[3];
        brushes[0] = new NChartSolidColorBrush(Color.argb(255, (int) (0.38 * 255), (int) (0.8 * 255), (int) (0.91 * 255)));
        brushes[1] = new NChartSolidColorBrush(Color.argb(255, (int) (0.8 * 255), (int) (0.86 * 255), (int) (0.22 * 255)));
        brushes[2] = new NChartSolidColorBrush(Color.argb(255, (int) (0.9 * 255), (int) (0.29 * 255), (int) (0.51 * 255)));
    }

    public void updateData() {
        // Switch on antialiasing.
        mNChartView.getChart().setShouldAntialias(true);

        if (drawIn3D) {
            // Switch 3D on.
            mNChartView.getChart().setDrawIn3D(true);
            mNChartView.getChart().getCartesianSystem().setMargin(new NChartMargin(50.0f, 50.0f, 10.0f, 20.0f));
            mNChartView.getChart().getPolarSystem().setMargin(new NChartMargin(50.0f, 50.0f, 10.0f, 20.0f));
        } else {
            mNChartView.getChart().getCartesianSystem().setMargin(new NChartMargin(10.0f, 10.0f, 10.0f, 20.0f));
            mNChartView.getChart().getPolarSystem().setMargin(new NChartMargin(10.0f, 10.0f, 10.0f, 20.0f));
        }

        // Create series that will be displayed on the chart.
        createSeries();

        // Update data in the chart.
        mNChartView.getChart().updateData();
    }

    void createSeries() {
        for (int i = 0; i < 3; ++i) {
            NChartFunnelSeries series = new NChartFunnelSeries();
            series.setDataSource(this);
            series.tag = i;
            series.setBottomRadius((float) (i + 1) / 5.0f);
            series.setTopRadius((float) (i + 2) / 5.0f);
            NChartBrush brush = brushes[i % brushes.length];
            brush.setOpacity(0.8f);
            series.setBrush(brush);
            mNChartView.getChart().addSeries(series);
        }
    }

    public NChartPoint[] points(NChartSeries series) {
        // Create points with some data for the series.
        ArrayList<NChartPoint> result = new ArrayList<NChartPoint>();

        result.add(new NChartPoint(NChartPointState.PointStateWithXYZ(0, random.nextInt(30), 0), series));

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
