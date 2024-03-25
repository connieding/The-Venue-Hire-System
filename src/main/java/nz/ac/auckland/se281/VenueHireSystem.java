package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  
  private List<Venue> listOfVenues = new ArrayList<Venue>();
  private String[] numbers = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};

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
    //venue name cannot be empty '' or ' '
    if (venueName == ""){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      
      // capacityInput must be a whole integer, positive, over zero and numberic/digits
    } else if (Integer.parseInt(capacityInput) < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");

      //Hire_Fee must be a whole integer, positive, over zero, numeric/digits
    } else if (hireFeeInput.matches("[0-9]+") == false){
      System.out.println("Venue not created: hire fee must be a number.");

      //venue code must be unique across all other veune codes in the system.
    } else if (listOfVenues.size() > 0) {
      for (int i = 0; i < listOfVenues.size(); i++) {
        if (listOfVenues.get(i).getVenueCode().equals(venueCode)) {
          // VENUE_NOT_CREATED_CODE_EXISTS("Venue not created: code '%s' is already used for '%s'.")
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, listOfVenues.get(i).getVenueName());
          MessageCli.VENUE_ENTRY.printMessage(listOfVenues.get(i).getVenueName(), listOfVenues.get(i).getVenueCode(), Integer.toString(listOfVenues.get(i).getCapacity()), Integer.toString(listOfVenues.get(i).getHireFee()), "TODO");
          break;
        } else {
          listOfVenues.add(new Venue(venueName, venueCode, Integer.parseInt(capacityInput), Integer.parseInt(hireFeeInput)));
          MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
          break;
        }
      }
      
    } else {
      listOfVenues.add(new Venue(venueName, venueCode, Integer.parseInt(capacityInput), Integer.parseInt(hireFeeInput)));
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    }
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
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
