package org.layers.domain.warnings;

public class UserWarnings {
    private AgeWarning ageWarning;
    private EmailWarning emailWarning;
    private NameWarning nameWarning;
    private PasswordWarning passwordWarning;
    public UserWarnings() { }
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
    public PasswordWarning getPasswordWarning() { return passwordWarning; }
    public void setPasswordWarning(PasswordWarning passwordWarning) {
        this.passwordWarning = passwordWarning;
    }

    public Boolean warningExist() {
        return nameWarning != null || emailWarning != null || ageWarning != null;
    }

    public String getWarnings() {
        return getAgeWarning().toString() + " " + getEmailWarning().toString() + " " + getNameWarning().toString();
    }
}
