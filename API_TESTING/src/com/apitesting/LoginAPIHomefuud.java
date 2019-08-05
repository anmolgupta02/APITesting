package com.apitesting;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginAPIHomefuud extends Application{
	
	public  LoginAPIHomefuud() {
		// TODO Auto-generated constructor stub
		
	}
	
	static long[] timeArray;
	static long time;
	
	
	@Test
	public static long LoginTest() {
		
		
		//RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();
		//request.header("Content-Type","application/x-www-form-urlencoded");
		request.header("Content-Type","application/json");
		request.headers("Accept","text/html");
		
		timeArray = new long[10]; 
		
		for(int i=0;i<10;i++) {
		JSONObject requestParams = new JSONObject();			

		requestParams.put("email", "steveh@yopmail.com"); // Cast
		requestParams.put("password","test@123");
		requestParams.put("user_type", "host");
		requestParams.put("devicetype","android");
		requestParams.put("devicetoken", "1");
		
		System.out.println(requestParams.toJSONString());
		
		request.body(requestParams.toJSONString());
		
		Response res = request.post("http://18.191.175.18/homefuud/api/userLogin");
		
		time = res.getTime();
		
		timeArray[i] = time;
		
		int statusCode = res.getStatusCode();
		
		ResponseBody resp = res.getBody();

		
		System.out.println("ResponseBody:" +resp.asString());
		
		System.out.println("Time Taken: " +time +"ms");
		
		System.out.println("HTTP CODE: "+statusCode);
		
		System.out.println("length of array:" +timeArray.length);
		}
		
		for(int i=0;i<10;i++) {
			System.out.println("Stored time:" +timeArray[i]);
		}
			return time;
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
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
		
			
		data.getData().add(new XYChart.Data<Number, Number>(LoginTest(), 560));
		
		lineChart.getData().add(data);
		root.getChildren().add(lineChart);
		
		
		primStage.setTitle("Load Test Report");
		primStage.setScene(scene);
		primStage.show();
		
		System.out.println("time fetched:" +time);
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
		
		
//		timeArray = new long[10];
//		
//		for(int i=0;i<2;i++) {
//		timeArray[i] = LoginTest();
//		}		
//				
//		for(int i=0;i<2;i++) {
//		System.out.println("Time array:"+timeArray[i]);
//		}
		launch(args);
	}
		
}
	

