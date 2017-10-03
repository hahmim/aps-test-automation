package com.aps.testing.cucumber.stepDefinitions;




import java.util.List;

import org.junit.Assert;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.aps.testing.cucumber.entity.CurrentIdentity;
import com.aps.testing.dao.CurrentIdentityDAO;

import com.aps.testing.util.DbConfig;

import cucumber.api.DataTable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class XMLToDbVerification {
	

	CurrentIdentity currentIdentity = null;


	
	@Given("^I upload xml file using a shell script using a <user> and a <host> and <privateKey> and <file>$")
	public void i_upload_xml_file_using_a_shell_script_using_a_user_and_a_host_and_privateKey_and_file(DataTable arg1) throws Throwable {
       

		List <List<String>> data = arg1.raw();
    	XMLToDbVerificationHelper xmlToDbVerificationHelper = new XMLToDbVerificationHelper();
    	String outcome = xmlToDbVerificationHelper.runShell(data.get(0).get(0),data.get(1).get(0),data.get(2).get(0),data.get(3).get(0));
    	Assert.assertEquals("File Transfered", outcome);
	}
	
	
	@When("^I run sql query to get the current identity attributes for <currId>$")
	public void i_run_sql_query_to_get_the_current_identity_attributes_for_currId(DataTable arg1) throws Throwable {

		 AbstractApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
		List <List<String>> data = arg1.raw();
		CurrentIdentityDAO CurrentIdentityDAOImpl = (CurrentIdentityDAO) context.getBean("currentIdentity");
		currentIdentity = CurrentIdentityDAOImpl.findIndividualCurrentIdentityAttrById(Integer.parseInt(data.get(0).get(0)));
		System.out.println(currentIdentity.getFirstName());
	}
	@Then("^the <firstName>,  <lastName>, <SSN> and <DOB> from the XML should match with the output of the DB$")
	public void the_firstName_lastName_SSN_and_DOB_from_the_XML_should_match_with_the_output_of_the_DB() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
