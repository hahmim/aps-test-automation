package com.aps.testing.cucumber.stepDefinitions;

import org.junit.Assert;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.aps.testing.cucumber.entity.CurrentIdentity;
import com.aps.testing.dao.CurrentIdentityDAO;
import com.aps.testing.util.DbConfig;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrganizationXmlDbVerification {
CurrentIdentity currentIdentity = null;
	
	@Given("^I upload the organization xml file using a shell script using a \"([^\"]*)\" and a \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")

	public void i_upload_the_organization_xml_file_using_a_shell_script_using_a_and_a_and_and(String user, String host, String privateKey, String fileName) throws Throwable {
	    XMLToDbVerificationHelper xmlToDbVerificationHelper = new XMLToDbVerificationHelper();
	    String result = xmlToDbVerificationHelper.runShell(user, host, privateKey, fileName);
	    Assert.assertEquals("File Transfered", result);
	   
	}

	@When("^I run sql query to get the current identity organization attributes for \"([^\"]*)\"$")
	public void i_run_sql_query_to_get_the_current_identity_organization_attributes_for(String currId) throws Throwable {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
		CurrentIdentityDAO CurrentIdentityDAOImpl = (CurrentIdentityDAO) context.getBean("currentIdentity");
		currentIdentity = CurrentIdentityDAOImpl.findOrganizationCurrentIdentityAttrById(Integer.parseInt(currId));
		System.out.println(currentIdentity.getBusinessName());
	}

	@Then("^The \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" from the XML should match with the output of the DB$")
	public void the_and_from_the_XML_should_match_with_the_output_of_the_DB(String businessName, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11) throws Throwable {
	    Assert.assertEquals(currentIdentity.getBusinessName(),businessName);
	    Assert.assertEquals(currentIdentity.getBusinessName(),businessName);
	    
	}

}
