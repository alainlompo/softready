package org.lompo.softwares.softready.applications;

import java.util.Random;

public class Randomizer {
	
	private final String[] FIRST_NAMES = {"John", "Morris", "Kurt", "Donald", "Terrence", "Jane", "Joanna", "Morris","Alan", "Albert", "Frank"};
	private final String[] LAST_NAMES = {"Gates","Gosling", "Jobs", "Allen","Abrash", "Hill","Jordan", "Dos Santos", "Bidden","Roosevelt","Sinatra"};
	private final String[] COMPANY_NAMES = {"MokoSoft","Horach","Sonsoft","Agriware","Hypernovae", "Excelta","NewTime", "Clearly IT", "Just Bit","Octoware"};
	private final String[] PHONE_NUMBERS = {"+1-541-754-3010", "+1-256-895-632", "+1-968-114-8954", "+1-123-495-3817", "+1-965-125-3968"};
	private final String[] EMAIL_ADRESSES = {"alm@hypernovae.com","abc@testers.com", "alfkifirst@ghanka.fr","opelcar@orangika.pl", "crackerstakers@testers.com"};
	
	
	
	private Randomizer() {
		random = new Random();
	}
	
	private static Randomizer instance;
	private Random random;
	
	public static Randomizer getInstance() {
		if (null == instance) {
			instance = new Randomizer();
			
		}
		return instance;
	}
	
	
	public Object oneOf(Object[] objects) {
		if (null== objects) {
			return null;
		}
		return objects[random.nextInt(objects.length)];
		
	}
	
	public String oneStringOf(String...strings) {
		if (null== strings) {
			return null;
		}
		return strings[random.nextInt(strings.length)];
	}
	
	public String oneFirstName() {
		return oneStringOf(FIRST_NAMES);
		
	}
	
	public String oneLastName() {
		return oneStringOf(LAST_NAMES);
	}
	
	public String oneCompanyName() {
		return oneStringOf(COMPANY_NAMES);
		
	}
	
	public String onePhoneNumber() {
		return oneStringOf(PHONE_NUMBERS);
	}
	
	public String oneEmailAdress() {
		return oneStringOf(EMAIL_ADRESSES);
	}

}
