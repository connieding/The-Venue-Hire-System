package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private List<Venue> listOfVenues = new ArrayList<Venue>();
  private List<Booking> listOfBookings = new ArrayList<Booking>();
  private String[] numbers = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};
  private String systemDate;
  private boolean codeExists = false;
  private boolean bookingReferenceExists = false;
  private String nameOfVenue;
  private String bookingReference;
  private String numberOfAttendees;
  private String tempDate;

  public VenueHireSystem() {}

  public void printVenues() {

    if (listOfVenues.size() > 0) {
      if (listOfVenues.size() == 1) { // one booking

        MessageCli.NUMBER_VENUES.printMessage("is", "one", "");

        tempDate = systemDate;
        for (Booking booking : listOfBookings) {
          if (booking.getBookingDate().equals(tempDate)
              && listOfVenues.get(0).getVenueCode().equals(booking.getVenueCode())) {
            tempDate = booking.getNextAvaliableDate();
          }
        }

        MessageCli.VENUE_ENTRY.printMessage(
            listOfVenues.get(0).getVenueName(),
            listOfVenues.get(0).getVenueCode(),
            Integer.toString(listOfVenues.get(0).getCapacity()),
            Integer.toString(listOfVenues.get(0).getHireFee()),
            tempDate);

      } else if (listOfVenues.size() > 1 && listOfVenues.size() < 10) { // 2-9 bookings

        MessageCli.NUMBER_VENUES.printMessage("are", numbers[listOfVenues.size() - 2], "s");

        for (int i = 0; i < listOfVenues.size(); i++) {

          tempDate = systemDate;
          for (Booking booking : listOfBookings) {
            if (booking.getBookingDate().equals(tempDate)
                && listOfVenues.get(i).getVenueCode().equals(booking.getVenueCode())) {
              tempDate = booking.getNextAvaliableDate();
            }
          }
          MessageCli.VENUE_ENTRY.printMessage(
              listOfVenues.get(i).getVenueName(),
              listOfVenues.get(i).getVenueCode(),
              Integer.toString(listOfVenues.get(i).getCapacity()),
              Integer.toString(listOfVenues.get(i).getHireFee()),
              tempDate);
        }

      } else if (listOfVenues.size() == 10) { // 10 bookings

        MessageCli.NUMBER_VENUES.printMessage("are", "10", "s");

        for (int i = 0; i < listOfVenues.size(); i++) {

          tempDate = systemDate;
          for (Booking booking : listOfBookings) {
            if (booking.getBookingDate().equals(tempDate)
                && listOfVenues.get(i).getVenueCode().equals(booking.getVenueCode())) {
              tempDate = booking.getNextAvaliableDate();
            }
          }

          MessageCli.VENUE_ENTRY.printMessage(
              listOfVenues.get(i).getVenueName(),
              listOfVenues.get(i).getVenueCode(),
              Integer.toString(listOfVenues.get(i).getCapacity()),
              Integer.toString(listOfVenues.get(i).getHireFee()),
              tempDate);
        }

      } else { // more than 10 bookings
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(listOfVenues.size()), "s");
        for (int i = 0; i < listOfVenues.size(); i++) {

          tempDate = systemDate;
          for (Booking booking : listOfBookings) {
            if (booking.getBookingDate().equals(tempDate)
                && listOfVenues.get(i).getVenueCode().equals(booking.getVenueCode())) {
              tempDate = booking.getNextAvaliableDate();
            }
          }

          MessageCli.VENUE_ENTRY.printMessage(
              listOfVenues.get(i).getVenueName(),
              listOfVenues.get(i).getVenueCode(),
              Integer.toString(listOfVenues.get(i).getCapacity()),
              Integer.toString(listOfVenues.get(i).getHireFee()),
              tempDate);
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
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    try { // check hire fee is a numeric value
      Integer.parseInt(hireFeeInput);
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    if (venueName.trim().length() == 0) { // check if venue name is empty
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();

    } else if (Integer.parseInt(capacityInput) <= 0) { // check if capacity is a positive number
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");

    } else if (Integer.parseInt(hireFeeInput) <= 0) { // check if hire fee is a positive number
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");

    } else if (listOfVenues.size() > 0) { // check if venue code already exists
      for (int i = 0; i < listOfVenues.size(); i++) {
        if (listOfVenues.get(i).getVenueCode().equals(venueCode)) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
              venueCode, listOfVenues.get(i).getVenueName());
          return;
        }
      }
      listOfVenues.add(
          new Venue(
              venueName,
              venueCode,
              Integer.parseInt(capacityInput),
              Integer.parseInt(hireFeeInput)));
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);

    } else { // Add venue to list
      listOfVenues.add(
          new Venue(
              venueName,
              venueCode,
              Integer.parseInt(capacityInput),
              Integer.parseInt(hireFeeInput)));
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
    } else {
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

    // check if venue is already booked
    for (int i = 0; i < listOfBookings.size(); i++) {
      if (listOfBookings.get(i).getVenueCode().equals(options[0])
          && listOfBookings.get(i).getBookingDate().equals(options[1])) {
        MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(
            listOfBookings.get(i).getVenueName(), options[1]);
        return;
      }
    }

    // check the date is not in the past
    String date = options[1];
    String[] dateParts = date.split("/");
    String venueDay = dateParts[0];
    String venueMonth = dateParts[1];
    String venueYear = dateParts[2];

    String[] systemDateParts = systemDate.split("/");
    String systemDay = systemDateParts[0];
    String systemMonth = systemDateParts[1];
    String systemYear = systemDateParts[2];

    if (Integer.parseInt(venueYear) < Integer.parseInt(systemYear)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
      return;
    } else if (Integer.parseInt(venueMonth) < Integer.parseInt(systemMonth)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
      return;
    } else if (Integer.parseInt(venueDay) < Integer.parseInt(systemDay)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
      return;
    }

    // check if number of attendees is greater than venue capacity
    numberOfAttendees = options[3];
    for (int i = 0; i < listOfVenues.size(); i++) {
      if (listOfVenues.get(i).getVenueCode().equals(options[0])) {
        if (Integer.parseInt(options[3]) > listOfVenues.get(i).getCapacity()) {
          MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
              options[3],
              String.valueOf(listOfVenues.get(i).getCapacity()),
              String.valueOf(listOfVenues.get(i).getCapacity()));
          numberOfAttendees = String.valueOf(listOfVenues.get(i).getCapacity());

        } else if (Integer.parseInt(options[3]) < ((listOfVenues.get(i).getCapacity()) / 4)) {
          MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
              options[3],
              String.valueOf((listOfVenues.get(i).getCapacity()) / 4),
              String.valueOf(listOfVenues.get(i).getCapacity()));
          numberOfAttendees = String.valueOf((listOfVenues.get(i).getCapacity()) / 4);
        }
      }
    }
    // Successfully create booking
    bookingReference = BookingReferenceGenerator.generateBookingReference();
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
        bookingReference, nameOfVenue, options[1], numberOfAttendees);
    listOfBookings.add(
        new Booking(
            options[0], bookingReference, nameOfVenue, options[1], options[2], numberOfAttendees));
  }

  public void printBookings(String venueCode) {
    Integer count = 0;
    for (Venue venue : listOfVenues) {
      if (venue.getVenueCode().equals(venueCode)) {
        MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venue.getVenueName());

        for (Booking booking : listOfBookings) {
          if (booking.getVenueCode().equals(venueCode)) {
            MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(
                booking.getBookingReference(), booking.getBookingDate());
            count++;
          }
        }
        if (count == 0) {
          MessageCli.PRINT_BOOKINGS_NONE.printMessage(venue.getVenueName());
        }
        return;
      }
    }
    MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    for (Booking booking : listOfBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        bookingReferenceExists = true;
      }
    }
    if (!bookingReferenceExists) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
      return;
    }
  }

  public void addServiceMusic(String bookingReference) {
    for (Booking booking : listOfBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        bookingReferenceExists = true;
      }
    }
    if (!bookingReferenceExists) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
      return;
    }
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    for (Booking booking : listOfBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        bookingReferenceExists = true;
      }
    }
    if (!bookingReferenceExists) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
      return;
    }
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
