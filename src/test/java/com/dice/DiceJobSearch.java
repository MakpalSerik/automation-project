package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//fullscreen
		driver.manage().window().fullscreen();
		
		//set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url ="https://dice.com";
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		String expectedtitle ="Find Jobs in Tech | Dice.com | Find Jobs in Tech";
		
		if(actualTitle.equals(expectedtitle)) {
			System.out.println("step PASSED");
		}else {
			System.out.println("step FAID");
			//throw new RuntimeException("step faid");
		}
		
		String keyword = "java developer";
		String location ="95758";
		
		driver.findElement(By.xpath("//*[@id=\"searchInput-div\"]/form/div/div[1]/div/dhi-new-typeahead-input/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchInput-div\"]/form/div/div[1]/div/dhi-new-typeahead-input/div/input")).sendKeys(keyword);
        
		driver.findElement(By.id("google-location-search")).clear();
        driver.findElement(By.id("google-location-search")).sendKeys(location);
        
        driver.findElement(By.id("submitSearch-button")).click();
        
        String count = driver.findElement(By.xpath("//*[@id=\"search-div\"]/dhi-search-page-results/div/div[1]/div/div/h4/span")).getText();
        System.out.println(count);
        System.out.println("another line");
        
        
       // driver.close();
		
	}
	

}
