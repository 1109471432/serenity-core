package net.thucydides.model.issues;


import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.thucydides.model.ThucydidesSystemProperty;
import net.thucydides.model.util.EnvironmentVariables;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Determine the issue tracking URL formats for a project.
 */
public class SystemPropertiesIssueTracking implements IssueTracking {

    private EnvironmentVariables environmentVariables;
    
    public SystemPropertiesIssueTracking() {
        this(ConfiguredEnvironment.getEnvironmentVariables());
    }

    
    public SystemPropertiesIssueTracking(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public String getIssueTrackerUrl() {
        if (jiraUrlDefined()) {
            return ThucydidesSystemProperty.JIRA_URL.from(environmentVariables)
                                         + "/browse/" + "{0}";
        } else {
            return ThucydidesSystemProperty.SERENITY_ISSUE_TRACKER_URL.from(environmentVariables);
        }
    }

    public String getShortenedIssueTrackerUrl() {
        if (jiraUrlDefined()) {
            return ThucydidesSystemProperty.JIRA_URL.from(environmentVariables)
                    + "/browse/" + getJiraProjectSuffix() + "{0}";
        } else {
            return ThucydidesSystemProperty.SERENITY_ISSUE_TRACKER_URL.from(environmentVariables);
        }
    }

    private String getJiraProjectSuffix() {
        if (jiraProjectDefined()) {
            return ThucydidesSystemProperty.JIRA_PROJECT.from(environmentVariables) + "-";
        } else {
            return "";
        }
    }

    private boolean jiraUrlDefined() {
       return !isEmpty(ThucydidesSystemProperty.JIRA_URL.from(environmentVariables));
    }

    private boolean jiraProjectDefined() {
       return !isEmpty(ThucydidesSystemProperty.JIRA_PROJECT.from(environmentVariables));
    }
}
