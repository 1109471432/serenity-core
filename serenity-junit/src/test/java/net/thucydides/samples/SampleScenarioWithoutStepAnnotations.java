package net.thucydides.samples;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SampleScenarioWithoutStepAnnotations {
    
    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "classpath:static-site/index.html")
    public Pages pages;
    
    public SampleScenarioSteps steps;
        
    @Test
    public void happy_day_scenario() {
        steps.stepThatSucceeds();
        steps.stepThatIsIgnored();
        steps.stepThatIsPending();
        steps.anotherStepThatSucceeds();
        steps.stepThatFails();
        steps.stepThatShouldBeSkipped();
    }
    
    @Test
    public void edge_case_1() {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
        steps.stepThatIsPending();
    }
    
    @Test
    public void edge_case_2() {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
    }
}
