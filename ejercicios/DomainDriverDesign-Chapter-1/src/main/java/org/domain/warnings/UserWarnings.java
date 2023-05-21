package org.domain.warnings;

public class UserWarnings {
    private AgeWarning ageWarning;
    private EmailWarning emailWarning;
    private NameWarning nameWarning;
    public UserWarnings() {
    }
    public AgeWarning getAgeWarning() {
        return ageWarning;
    }
    public void setAgeWarning(AgeWarning ageWarning) {
        this.ageWarning = ageWarning;
    }
    public EmailWarning getEmailWarning() {
        return emailWarning;
    }
    public void setEmailWarning(EmailWarning emailWarning) {
        this.emailWarning = emailWarning;
    }
    public NameWarning getNameWarning() {
        return nameWarning;
    }
    public void setNameWarning(NameWarning nameWarning) {
        this.nameWarning = nameWarning;
    }

    public Boolean warningExist() {
        return nameWarning != null || emailWarning != null || ageWarning != null;
    }
}
