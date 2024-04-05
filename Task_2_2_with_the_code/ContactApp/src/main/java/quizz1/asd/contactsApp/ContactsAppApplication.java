package quizz1.asd.contactsApp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import quizz1.asd.contactsApp.data.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactsAppApplication {

	public static void main(String[] args) {

		List<Contact> contacts = new ArrayList<>();
		Contact contact1 = new Contact("David", "Sanger", "Argos LLC", "Sales Manager");
		contact1.addPhoneNumber("240-133-0011", "Home");
		contact1.addPhoneNumber("240-112-0123", "Mobile");
		contact1.addEmailAddress("dave.sang@gmail.com", "Home");

		Contact contact2 = new Contact("Carlos", "Jimenez", "Zappos", "Director");

		Contact contact3 = new Contact("Ali", "Gafar", "BMI Services", "HR Manager");
		contact3.addPhoneNumber("412-116-9988", "Work");
		contact3.addEmailAddress("ali@bmi.com", "Work");

		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);

		// Sort contacts by last name in ascending order
		Collections.sort(contacts, Comparator.comparing(Contact::getLastName));

//		// Convert contacts to JSON format using Contact class method toJson
//		List<String> contactsJson = new ArrayList<>();
//		for (Contact contact : contacts) {
//			contactsJson.add(contact.toJson());
//		}
//
//		// Print JSON strings to console
//		for (String json : contactsJson) {
//			System.out.println(json);
//		}

		// Convert contacts to JSON format and print to console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(contacts);
		System.out.println(json);
	}
}
