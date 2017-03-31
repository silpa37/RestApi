package com.pack.common.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;

import com.pack.common.pageobjects.BasePage;

@Test
public class SignInPageTest<SignInPage> extends TestBaseSetup{
private WebDriver driver;
private SignInPageTest signInPage;
private BasePage basePage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
		
	public void verifySignInFunction() {
		System.out.println("Sign In functionality details...");
		basePage = new BasePage(driver);
		signInPage = basePage.clickSignInBtn();
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
		Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");

	}

	private boolean verifySignIn() {
		
		return false;
	}

	private boolean verifySignInPageText() {
		
		return false;
	}

	private boolean verifySignInPageTitle() {
		
		return false;
	}

}