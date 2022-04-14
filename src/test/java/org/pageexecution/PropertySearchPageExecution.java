package org.pageexecution;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.baseclass.BaseClass;
import org.pagerepo.PropertySearchPageRepo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PropertySearchPageExecution extends BaseClass {

	@Parameters({ "data" })
	@BeforeMethod
	public void beforeMethod(String data) {
		System.out.println("launching the URL");
		driver.get(data);
	}

	@Test(dataProvider = "nbdata")
	public void test1(String PageSearchLocality, int scrollDownFirst, int scrollDownSecond,
			int scrollDownApartmentThird, int scrollDownApartmentFourth) throws AWTException, InterruptedException {

		PropertySearchPageRepo ps = new PropertySearchPageRepo();
		ps.getBuy().click();
		ps.getCitydropdown().click();
		ps.getMumbai().click();
		type(ps.getListPageSearchLocality(), PageSearchLocality);
		
		Thread.sleep(2000);
		Robot r = new Robot();
		for (int i = 0; i < scrollDownFirst; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		type(ps.getListPageSearchLocality(), PageSearchLocality);
		
		Thread.sleep(2000);
		for (int i = 0; i < scrollDownSecond; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		ps.getApartmentType().click();
		Thread.sleep(2000);
		for (int i = 0; i < scrollDownApartmentThird; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		ps.getSearchbutton().click();
		Thread.sleep(5000);
		
		System.out.println(ps.getSelectProperty().getText());

		ps.getSelectProperty().click();
		Thread.sleep(5000);

		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();

		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(ps.getDescription().getText());
				
				String actual = ps.getDescription().getText();
				String expected = "Description";
				Assert.assertTrue(actual.contains(expected));
			}
		}
	}

	@DataProvider(name = "nbdata")
	public Object[][] getData() {
		return new Object[][] { { "malad", 3, 4, 2, 3 } };
	}
}
