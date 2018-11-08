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

package com.nulana.nchart3d.example.activity;

import android.os.Bundle;

import com.nulana.NChart.*;
import com.nulana.nchart3d.example.constant.Constants;
import com.nulana.nchart3d.example.differentCharts.AreaChartController;
import com.nulana.nchart3d.example.differentCharts.BandChartController;
import com.nulana.nchart3d.example.differentCharts.BarChartController;
import com.nulana.nchart3d.example.differentCharts.BubbleChartController;
import com.nulana.nchart3d.example.differentCharts.CandlestickChartController;
import com.nulana.nchart3d.example.differentCharts.ColumnChartController;
import com.nulana.nchart3d.example.differentCharts.FunnelChartController;
import com.nulana.nchart3d.example.differentCharts.HeatmapChartController;
import com.nulana.nchart3d.example.differentCharts.LineChartController;
import com.nulana.nchart3d.example.differentCharts.OHLCChartController;
import com.nulana.nchart3d.example.differentCharts.PieChartController;
import com.nulana.nchart3d.example.differentCharts.R;
import com.nulana.nchart3d.example.differentCharts.RadarChartController;
import com.nulana.nchart3d.example.differentCharts.RibbonChartController;
import com.nulana.nchart3d.example.differentCharts.SequenceChartController;
import com.nulana.nchart3d.example.differentCharts.SurfaceChartController;

import java.util.Random;

public class ChartingActivity extends BaseActivity {
    NChartView mNChartView;

//    enum SeriesType {
//        // 2D types.
//        Column2D,
//        Bar2D,
//        Area2D,
//        Pie2D,
//        Doughnut2D,
//        Line2D,
//        Step2D,
//        Bubble2D,
//        Candlestick2D,
//        OHLC2D,
//        Band,               // Only in 2D
//        Sequence,           // Only in 2D
//        Radar,              // Only in 2D
//        Heatmap,            // Only in 2D
//        Funnel2D,
//        // 3D types.
//        Column3D,
//        Bar3D,
//        Area3D,
//        Pie3D,
//        Doughnut3D,
//        Line3D,
//        Ribbon,             // Only in 3D
//        Step3D,
//        Bubble3D,
//        Surface,            // Only in 3D
//        Candlestick3D,
//        OHLC3D,
//        Funnel3D
//    }
//
//    SeriesType type;

    private String type;

    @Override
    protected void getArgs(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        type = bundle.getString("type");

    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_chart;
    }

    @Override
    protected void initViews() {
        mNChartView = (NChartView) findViewById(R.id.surface);
        loadView();

    }


    @Override
    protected void initListener() {

    }

    private void loadView() {
        // Paste your license key here.
        mNChartView.getChart().setLicenseKey(Constants.licenseKey);

        // Switch this field to view all types of series.
//        type = SeriesType.Column2D;
//        boolean is3D = type.ordinal() >= SeriesType.Column3D.ordinal();
        boolean is3D = false;

        switch (type) {
            case "Area2D":
            case "Area3D": {
                AreaChartController ctr = new AreaChartController(is3D, mNChartView);
                ctr.updateData();
            }
            break;

            case "Band": {
                BandChartController ctr = new BandChartController(mNChartView);
                ctr.updateData();
            }
            break;

            case "Bar2D":
            case "Bar3D": {
                BarChartController ctr = new BarChartController(is3D, mNChartView);
                ctr.updateData();
            }
            break;

            case "Bubble2D":
            case "Bubble3D": {
                BubbleChartController ctr = new BubbleChartController(is3D, mNChartView);
                ctr.updateData();
            }
            break;

            case "Candlestick2D":
            case "Candlestick3D": {
                CandlestickChartController ctr = new CandlestickChartController(is3D, mNChartView);
                ctr.updateData();
            }
            break;

            case "Column2D":
            case "Column3D": {
                ColumnChartController ctr = new ColumnChartController(is3D, mNChartView);
                ctr.updateData();
            }
            break;

            case "Funnel2D":
            case "Funnel3D": {
                FunnelChartController ctr = new FunnelChartController(is3D, mNChartView);
                ctr.updateData();
            }
            break;

            case "Heatmap": {
                HeatmapChartController ctr = new HeatmapChartController(mNChartView);
                ctr.updateData();
            }
            break;

            case "Line2D":
            case "Line3D": {
                LineChartController ctr = new LineChartController(is3D, false, mNChartView);
                ctr.updateData();
            }
            break;

            case "Step2D":
            case "Step3D": {
                LineChartController ctr = new LineChartController(is3D, true, mNChartView);
                ctr.updateData();
            }
            break;

            case "OHLC2D":
            case "OHLC3D": {
                OHLCChartController ctr = new OHLCChartController(is3D, mNChartView);
                ctr.updateData();
            }
            break;

            case "Pie2D":
            case "Pie3D": {
                PieChartController ctr = new PieChartController(is3D, 0.0f, mNChartView);
                ctr.updateData();
            }
            break;

            case "Doughnut2D":
            case "Doughnut3D": {
                PieChartController ctr = new PieChartController(is3D, 0.1f, mNChartView);
                ctr.updateData();
            }
            break;

            case "Radar": {
                RadarChartController ctr = new RadarChartController(mNChartView);
                ctr.updateData();
            }
            break;

            case "Ribbon": {
                RibbonChartController ctr = new RibbonChartController(mNChartView);
                ctr.updateData();
            }
            break;

            case "Sequence": {
                SequenceChartController ctr = new SequenceChartController(mNChartView);
                ctr.updateData();
            }
            break;

            case "Surface": {
                SurfaceChartController ctr = new SurfaceChartController(mNChartView);
                ctr.updateData();
            }
            break;
        }
    }
}
