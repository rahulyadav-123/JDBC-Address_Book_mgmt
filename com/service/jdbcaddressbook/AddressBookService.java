package com.service.jdbcaddressbook;

import java.time.LocalDate;
import java.util.List;

import com.model.jdbcaddressbook.PersonInformation;

public class AddressBookService {
	private AddressBookDBService addressBookDBService;
	private List<PersonInformation> contactList;

	public enum IOService {DB_IO}

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
	}

	public List<PersonInformation> readContactData(IOService ioService) {
		if(ioService.equals(IOService.DB_IO))
			this.contactList = addressBookDBService.readData();
		return this.contactList;
	}

	public void updatePersonInfo(String name, String state) {
		int result = addressBookDBService.updateContact(name, state);
		if(result == 0)
			return;
		PersonInformation contactData = this.getContactData(name);
		if( contactData != null )
			contactData.state = state;
	}

	private PersonInformation getContactData(String name) {
		return this.contactList.stream()
				.filter(personInfo -> personInfo.first_name.equals(name))
				.findFirst()
				.orElse(null);
	}

	public boolean checkContactInSyncWithDB(String name) {
		List<PersonInformation> personInfoDataList = addressBookDBService.getContactData(name);
		return personInfoDataList.get(0).equals(getContactData(name));
	}

	public List<PersonInformation> readContactForDateRange(IOService ioService, LocalDate startDate, LocalDate endDate) {
		if( ioService.equals(IOService.DB_IO) )
			return addressBookDBService.getContactData(startDate, endDate);
		return null;
	}

	public List<PersonInformation> readContactForParticularCity(IOService ioService, String city) {
		if( ioService.equals(IOService.DB_IO) )
            return addressBookDBService.getContactForParticularCity(city);
        return null;
	}

	public List<PersonInformation> readContactForParticularState(IOService ioService, String state) {
		if( ioService.equals(IOService.DB_IO) )
            return addressBookDBService.getContactForParticularState(state);
        return null;
	}
}


