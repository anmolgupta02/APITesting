package com.apitesting;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoadResult extends Application {
	
	static long TimeArray[];
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init(primaryStage);
	}
	
	private void  init(Stage primStage) {
		
		HBox root = new HBox();
		Scene scene = new Scene(root, 450,330);
		
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Response Time in ms");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Time");
		
		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		
		lineChart.setTitle("Load Testing Results");
		
		XYChart.Series<Number, Number> data = new XYChart.Series<Number, Number>();
		
			
		data.getData().add(new XYChart.Data<Number, Number>(90, 10));
		
		lineChart.getData().add(data);
		root.getChildren().add(lineChart);
		
		
		primStage.setTitle("Load Test Report");
		primStage.setScene(scene);
		primStage.show();
		
		
		//Saving Report 
		lineChart.setAnimated(false);
	
		String FilePath = System.getProperty("user.dir") + "/ScreenShots";
	
		 WritableImage snapShot = scene.snapshot(null);
	        try {
				ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File(FilePath+"/test.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static void main(String args[]) {
		launch(args);
		
		LoginAPIHomefuud login = new LoginAPIHomefuud();
		
		TimeArray = new long[10];
		
		for(int i=0;i<2;i++) {
			TimeArray[i] = login.LoginTest();
		}
		
		for(int i=0; i<2; i++) {
		System.out.println("Time:" +TimeArray[i]);
		
		}
	}
}
