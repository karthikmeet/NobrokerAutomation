package org.pagerepo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertySearchPageRepo extends BaseClass {

	public PropertySearchPageRepo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Buy' and @class = 'nb__17yFj']")
	private WebElement Buy;
	@FindBy(xpath = "//*[@class='css-1hwfws3 nb-select__value-container nb-select__value-container--has-value']")
	private WebElement citydropdown;
	@FindBy(xpath = "//*[@id=\"searchCity\"]/div/div[1]/div")
	private WebElement Mumbai;
	@FindBy(id = "listPageSearchLocality")
	private WebElement listPageSearchLocality;
	@FindBy(xpath = "//button[@class='prop-search-button btn btn-primary btn-lg']")
	private WebElement Searchbutton;
	@FindBy(xpath = "(//span[contains(text(),'2 BHK Flat  For Sale  In Royal Crystal  In Malad East')])[1]")
	private WebElement ChooseProperty;
	@FindBy(xpath = "//*[text()='Apartment Type']")
	private WebElement ApartmentType;
	
	public WebElement getApartmentType() {
		return ApartmentType;
	}

	public WebElement getChooseProperty() {
		return ChooseProperty;
	}

	public WebElement getMumbai() {
		return Mumbai;
	}

	public WebElement getSearchbutton() {
		return Searchbutton;
	}

	public WebElement getBuy() {
		return Buy;
	}

	public WebElement getListPageSearchLocality() {
		return listPageSearchLocality;
	}

	public WebElement getCitydropdown() {
		return citydropdown;
	}
}
