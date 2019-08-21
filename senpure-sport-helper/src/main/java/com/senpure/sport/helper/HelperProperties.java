package com.senpure.sport.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * HelperProperties
 *
 * @author senpure
 * @time 2019-08-19 15:45:00
 */
@ConfigurationProperties("helper")
public class HelperProperties {
    private boolean genearteBatLink=true;
    private String databaseUrl="localhost:3306";
    private String databaseUsername="root";
    private String databasePassword="123456";
    private String eurekaServiceUrl="localhost:8761";


    public boolean isGenearteBatLink() {
        return genearteBatLink;
    }

    public void setGenearteBatLink(boolean genearteBatLink) {
        this.genearteBatLink = genearteBatLink;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public String getEurekaServiceUrl() {
        return eurekaServiceUrl;
    }

    public void setEurekaServiceUrl(String eurekaServiceUrl) {
        this.eurekaServiceUrl = eurekaServiceUrl;
    }
}
