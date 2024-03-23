package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  
  private List<Venue> listOfVenues = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
    //check how venues in the listofVenues if there is one venue and if there is 10 venues print something different
    if (listOfVenues.size() > 0) {
      if (listOfVenues.size() == 1) {
        MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
        MessageCli.VENUE_ENTRY.printMessage(listOfVenues.get(0).getVenueName(), listOfVenues.get(0).getVenueName(), Integer.toString(listOfVenues.get(0).getCapacity()), Integer.toString(listOfVenues.get(0).getHireFee()), "TODO");

      } else if (listOfVenues.size() == 10){
        //NUMBER_VENUES("There %s %s venue%s in the system:"),
        MessageCli.NUMBER_VENUES.printMessage("are", "10", "s");
        // print out the venues in the list with MeaageCli VENUE_ENTRY("  * %s (%s) - %s people - $%s base hire fee. Next available on %s")
        for (int i = 0; i < listOfVenues.size(); i++) {
          MessageCli.VENUE_ENTRY.printMessage(listOfVenues.get(i).getVenueName(), listOfVenues.get(i).getVenueCode(), Integer.toString(listOfVenues.get(i).getCapacity()), Integer.toString(listOfVenues.get(i).getHireFee()), "TODO");
        }
      } else{
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(listOfVenues.size()), "s");
      }
    } else {
      MessageCli.NO_VENUES.printMessage();
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    if (venueName == ""){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();

    } else if (Integer.parseInt(capacityInput) < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");

    } else if (hireFeeInput.matches("[0-9]+") == false){
      System.out.println("Venue not created: hire fee must be a number.");

      //create an else statement for when there is a venue with the same code
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
