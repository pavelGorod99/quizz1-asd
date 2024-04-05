package quizz1.asd.contactsApp.data;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private List<PhoneNumber> phoneNumbers;
    private List<EmailAddress> emailAddresses;

    public Contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.phoneNumbers = new ArrayList<>();
        this.emailAddresses = new ArrayList<>();
    }

    // Getters and setters for all attributes

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumber(String number, String label) {
        phoneNumbers.add(new PhoneNumber(number, label));
    }

    public void removePhoneNumber(PhoneNumber phoneNumber) {
        phoneNumbers.remove(phoneNumber);
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void addEmailAddress(String address, String label) {
        emailAddresses.add(new EmailAddress(address, label));
    }

    public void removeEmailAddress(EmailAddress emailAddress) {
        emailAddresses.remove(emailAddress);
    }

    public void deleteContact() {
        // You can implement deletion logic here, such as removing the contact from a list or marking it as deleted.
        // For demonstration purposes, let's just clear the phone numbers and email addresses lists.
        phoneNumbers.clear();
        emailAddresses.clear();
    }

    public List<Contact> searchContact(String query) {
        List<Contact> searchResults = new ArrayList<>();
        // Implement search logic here based on the query parameter
        // For demonstration purposes, let's just return an empty list.
        return searchResults;
    }

    public void mergeDuplicateContacts(Contact contact) {
        // Implement merge logic here to merge details of duplicate contacts
        // For demonstration purposes, let's just add the phone numbers and email addresses of the other contact.
        this.phoneNumbers.addAll(contact.getPhoneNumbers());
        this.emailAddresses.addAll(contact.getEmailAddresses());
    }

    public String toJson() {
        // Convert contact details to JSON format
        return "{\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\",\"company\":\"" + company + "\",\"jobTitle\":\"" + jobTitle + "\",\"phoneNumbers\":" + phoneNumbersToJson() + ",\"emailAddresses\":" + emailAddressesToJson() + "}";
    }

    private String phoneNumbersToJson() {
        StringBuilder sb = new StringBuilder("[");
        for (PhoneNumber phoneNumber : phoneNumbers) {
            sb.append("{\"number\":\"").append(phoneNumber.getNumber()).append("\",\"label\":\"").append(phoneNumber.getLabel()).append("\"},");
        }
        if (!phoneNumbers.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1); // Remove the last comma
        }
        sb.append("]");
        return sb.toString();
    }

    private String emailAddressesToJson() {
        StringBuilder sb = new StringBuilder("[");
        for (EmailAddress emailAddress : emailAddresses) {
            sb.append("{\"address\":\"").append(emailAddress.getAddress()).append("\",\"label\":\"").append(emailAddress.getLabel()).append("\"},");
        }
        if (!emailAddresses.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1); // Remove the last comma
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emailAddresses=" + emailAddresses +
                '}';
    }
}
