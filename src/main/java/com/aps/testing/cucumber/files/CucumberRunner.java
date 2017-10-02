package com.aps.testing.cucumber.files;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "json:target/" }, features = { "src/main/java/com/aps/testing/cucumber/features" })
public class CucumberRunner {

}

