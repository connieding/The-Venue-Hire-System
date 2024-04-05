package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  
  private List<Venue> listOfVenues = new ArrayList<Venue>();
  private String[] numbers = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};
  private String systemDate;
  private boolean codeExists = false;
  private String nameOfVenue;

  public VenueHireSystem() {}

  public void printVenues() {
    if (listOfVenues.size() > 0) {
      if (listOfVenues.size() == 1) {
        MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
        MessageCli.VENUE_ENTRY.printMessage(listOfVenues.get(0).getVenueName(), listOfVenues.get(0).getVenueCode(), Integer.toString(listOfVenues.get(0).getCapacity()), Integer.toString(listOfVenues.get(0).getHireFee()), "TODO");
      
      } else if (listOfVenues.size() > 1 && listOfVenues.size() < 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", numbers[listOfVenues.size() - 2], "s");
        for (int i = 0; i < listOfVenues.size(); i++) {
          MessageCli.VENUE_ENTRY.printMessage(listOfVenues.get(i).getVenueName(), listOfVenues.get(i).getVenueCode(), Integer.toString(listOfVenues.get(i).getCapacity()), Integer.toString(listOfVenues.get(i).getHireFee()), "TODO");
        }

      } else if (listOfVenues.size() == 10){
        MessageCli.NUMBER_VENUES.printMessage("are", "10", "s");
        for (int i = 0; i < listOfVenues.size(); i++) {
          MessageCli.VENUE_ENTRY.printMessage(listOfVenues.get(i).getVenueName(), listOfVenues.get(i).getVenueCode(), Integer.toString(listOfVenues.get(i).getCapacity()), Integer.toString(listOfVenues.get(i).getHireFee()), "TODO");
        }

      } else {
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(listOfVenues.size()), "s");
        for (int i = 0; i < listOfVenues.size(); i++) {
          MessageCli.VENUE_ENTRY.printMessage(listOfVenues.get(i).getVenueName(), listOfVenues.get(i).getVenueCode(), Integer.toString(listOfVenues.get(i).getCapacity()), Integer.toString(listOfVenues.get(i).getHireFee()), "TODO");
        }
      } 
    } else {
      MessageCli.NO_VENUES.printMessage();
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    
    try { // check capacity is a numeric value
      Integer.parseInt(capacityInput);
    } catch(Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    try{ // check hire fee is a numeric value
      Integer.parseInt(hireFeeInput);
    } catch(Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }
    
    if (venueName.trim().length() == 0) { // check if venue name is empty
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    
    } else if (Integer.parseInt(capacityInput) <= 0 ) {  // check if capacity is a positive number
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");

    } else if (Integer.parseInt(hireFeeInput) <= 0) {  // check if hire fee is a positive number
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");

    } else if (listOfVenues.size() > 0) { // check if venue code already exists
      for (int i = 0; i < listOfVenues.size(); i++) {
        if (listOfVenues.get(i).getVenueCode().equals(venueCode)) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, listOfVenues.get(i).getVenueName());
          return;
        }
      }
      listOfVenues.add(new Venue(venueName, venueCode, Integer.parseInt(capacityInput), Integer.parseInt(hireFeeInput)));
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
      
    } else { // Add venue to list
      listOfVenues.add(new Venue(venueName, venueCode, Integer.parseInt(capacityInput), Integer.parseInt(hireFeeInput)));
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    }
  }

  public void setSystemDate(String dateInput) {
    systemDate = dateInput;
    MessageCli.DATE_SET.printMessage(dateInput);
  }

  public void printSystemDate() {

    if (systemDate != null) {
      MessageCli.CURRENT_DATE.printMessage(systemDate);
    } else{
      MessageCli.CURRENT_DATE.printMessage("not set");
    }
  }

  public void makeBooking(String[] options) {
    if (systemDate == null) { // check if system date is set
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    } else if (listOfVenues.size() == 0) { // check if there are venues in the system
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }

    // check if venue code exists
    for (int i = 0; i < listOfVenues.size(); i++) {
      if (listOfVenues.get(i).getVenueCode().equals(options[0])) {
        nameOfVenue = listOfVenues.get(i).getVenueName();
        codeExists = true;
      }
    }
    if (!codeExists) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      return;
    }

    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(BookingReferenceGenerator.generateBookingReference(), nameOfVenue, options[1], options[3]);


  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
