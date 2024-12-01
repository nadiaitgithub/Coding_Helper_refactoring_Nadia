package code_clone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public class BoxAndWhiskerChart {
    private static final int CHART_WIDTH=600;
    private static final int CHART_HEIGHT=600;

    private List<Double> convertArrayToList(double [] data) {
        List<Double> list = new ArrayList<>();
        for (double value : data){

            list.add(value);

        }
        return list;
    }

    private DefaultBoxAndWhiskerCategoryDataset prepareDataset() {

        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();

        for (int i = 0; i < CosineSimilarity.similarArray.size(); i++) {
            dataset.add(
                    convertArrayToList(CosineSimilarity.similarArray.get(i)), "Project Comparison", CloneCheck.ProjectFileName1.get(i)
            );
        }
        return dataset;
    }
    public void displayChart(){
        JFrame frame = new JFrame("Clone Check");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Default BoxAndWhiskerCategoryDataset dataset = prepareDataset();
        BoxAnd WhiskerRender renderer = new BoxAndWhiskerRenderer();
        renderer.setFillBox(true);
        renderer.setUseOutlinePaintForWhiskers(true);
        renderer.setMedianVisible(true);
        renderer.setMeanVisible(false);
        CategoryAxis xAxis = new CategoryAxis("Project Files");
        NumberAxis yAxis = new NumberAxis("Values");
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);

        JFreeChart chart = new JFreeChart(
                "Box-and-Whisker Plot",
                new Font("SansSerif", Font.BOLD, 20),
                plot,
                true
        );
        chart.setBackgroundPaint(Color.LIGHT_GRAY);

        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(CHART_WIDTH, CHART_HEIGHT);
            }
        };

        frame.add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void launchChart() {
        EventQueue.invokeLater(new BoxAndWhiskerChart()::displayChart);
    }
}



