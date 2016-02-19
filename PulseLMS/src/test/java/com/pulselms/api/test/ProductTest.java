package com.pulselms.api.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.pulselms.app.framework.DataProviderArguments;
import com.pulselms.app.framework.DataProviderClass;
import com.pulselms.base.test.APIBaseTest;

public class ProductTest extends APIBaseTest {

	private static String EpubTitle = "Sample Epub";
	private static String Description = "Sample Desc";
	private static String CoverImageURL = "http://cdn.gloss.pearson-intl.com/resources/products/epubs/protected/SA/cti/pdf/ced673d0-5366-4723-98fa-0ddf2641cc4d-9780409119923.png";
	private static String EpubURL = "http://cdn.gloss.pearson-intl.com/resources/products/epubs/protected/SA/cti/pdf/ced673d0-5366-4723-98fa-0ddf2641cc4d-9780409119923.pdf";
	private static String Navigation = "vertical";

	 @Test
	public void ProductUploadTest() {

		generateAppId();
		authenticate(PearsonAdminUser, PearsonAdminPassword);
		String[] Layout = { "portrait_single_page", "landscape_single_page" };
		Response response = uploadProduct(EpubTitle, Description, CoverImageURL, EpubURL, Navigation, Layout);
		System.out.println(response.asString());
		Assert.assertEquals(response.statusCode(), 201);
	}

	@Test(dataProvider = "DP_POI", dataProviderClass = DataProviderClass.class)
	@DataProviderArguments(data_Folder = "bulkupload", data_File_Name = "product.xlsx", sheetname = "Sheet1")
	public void ProductBulkUploadTest(Map<String, String> testdata) {

		generateAppId();
		authenticate(PearsonAdminUser, PearsonAdminPassword);
		String[] layout = testdata.get("Layout").split(",");
		Response response = uploadProduct(testdata.get("Title"), testdata.get("Description"),
				testdata.get("CoverImageURL"), testdata.get("EpubURL"), testdata.get("Navigation"), layout);
		Assert.assertEquals(response.statusCode(), 201);
	}

}
