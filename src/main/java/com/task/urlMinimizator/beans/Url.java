package com.task.urlMinimizator.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "urls")
public class Url {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long urlId;

    @Column(name = "FULL_REFERENCE")
    private String fullReference;

    @Column(name = "SHORT_REFERENCE")
    private String shortReference;

    @Column(name = "DATE_OF_CREATION_URL")
    private Date dateOfCreationUrl;

    @Column(name = "DATE_OF_ENDING_URL")
    private Date dateOfEndingUrl;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "BROWSER")
    private String browser;

    public long getUrlId() {
        return urlId;
    }

    public void setUrlId(long urlId) {
        this.urlId = urlId;
    }

    public String getFullReference() {
        return fullReference;
    }

    public void setFullReference(String fullReference) {
        this.fullReference = fullReference;
    }

    public String getShortReference() {
        return shortReference;
    }

    public void setShortReference(String shortReference) {
        this.shortReference = shortReference;
    }

    public Date getDateOfCreationUrl() {
        return dateOfCreationUrl;
    }

    public void setDateOfCreationUrl(Date dateOfCreationUrl) {
        this.dateOfCreationUrl = dateOfCreationUrl;
    }

    public Date getDateOfEndingUrl() {
        return dateOfEndingUrl;
    }

    public void setDateOfEndingUrl(Date dateOfEndingUrl) {
        this.dateOfEndingUrl = dateOfEndingUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Url() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return urlId == url.urlId &&
                isActive == url.isActive &&
                Objects.equals(fullReference, url.fullReference) &&
                Objects.equals(dateOfCreationUrl, url.dateOfCreationUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlId, fullReference, dateOfCreationUrl, isActive);
    }

    @Override
    public String toString() {
        return "Url{" +
                "urlId=" + urlId +
                ", fullReference='" + fullReference + '\'' +
                ", shortReference='" + shortReference + '\'' +
                ", dateOfCreationUrl=" + dateOfCreationUrl +
                ", dateOfEndingUrl=" + dateOfEndingUrl +
                ", isActive=" + isActive +
                ", ipAddress='" + ipAddress + '\'' +
                ", Browser='" + browser + '\'' +
                '}';
    }

    public static class Builder {
        private final Url url;

        public Builder() {
            this.url = new Url();
        }

        public Builder setUrlId(long urlId) {
            url.setUrlId(urlId);
            return this;
        }

        public Builder setFullReference(String fullReference) {
            url.setFullReference(fullReference);
            return this;
        }

        public Builder setShortReference(String shortReference) {
            url.setShortReference(shortReference);
            return this;
        }

        public Builder setDateOfCreationUrl(Date dateOfCreationUrl) {
            url.setDateOfCreationUrl(dateOfCreationUrl);
            return this;
        }

        public Builder setDateOfEndingUrl(Date dateOfEndingUrl) {
            url.setDateOfEndingUrl(dateOfEndingUrl);
            return this;
        }

        public Builder setIsActive(boolean isActive) {
            url.setActive(isActive);
            return this;
        }

        public Builder setIpAddress(String ipAddress) {
            url.setIpAddress(ipAddress);
            return this;
        }

        public Builder setBrowser(String browser) {
            url.setBrowser(browser);
            return this;
        }

        public Url getInstance() {
            return url;
        }
    }
}
