package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  protected List<Venue> listOfVenues = new ArrayList<Venue>();
  protected List<Booking> listOfBookings = new ArrayList<Booking>();
  protected List<Catering> listOfCatering = new ArrayList<Catering>();
  protected List<Music> listOfMusic = new ArrayList<Music>();
  private List<Floral> listOfFloral = new ArrayList<Floral>();
  private String[] numbers = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};
  private String systemDate;
  private boolean codeExists = false;
  // private boolean bookingReferenceExists = false;
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
            options[0],
            bookingReference,
            nameOfVenue,
            options[1],
            options[2],
            numberOfAttendees,
            systemDate));
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
    Catering catering =
        new Catering(
            listOfBookings,
            bookingReference,
            "Catering",
            cateringType.getName(),
            cateringType.getCostPerPerson(),
            numberOfAttendees);
    catering.addService();

    listOfCatering.add(catering);
  }

  public void addServiceMusic(String bookingReference) {

    Music music = new Music(listOfBookings, bookingReference, "Music");
    music.addService();

    listOfMusic.add(music);
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    Floral floral =
        new Floral(
            listOfBookings, bookingReference, "Floral", floralType.getName(), floralType.getCost());
    floral.addService();

    listOfFloral.add(floral);
  }

  public void viewInvoice(String bookingReference) {

    boolean bookingReferenceExists = false;
    for (Booking booking : listOfBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        bookingReferenceExists = true;
      }
    }
    if (!bookingReferenceExists) {
      MessageCli.VIEW_INVOICE_BOOKING_NOT_FOUND.printMessage(bookingReference);
      return;
    }

    for (Booking booking : listOfBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage("");
      }
    }

    int bookingCateringCost = 0;
    for (int i = 0; i < listOfCatering.size(); i++) {
      if (listOfCatering.get(i).getBookingReference().equals(bookingReference)) {
        bookingCateringCost += listOfCatering.get(i).cateringCost();
        MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(
            listOfCatering.get(i).getCateringName(), Integer.toString(bookingCateringCost));
      }
    }
    int bookingMusicCost = 0;
    for (int i = 0; i < listOfMusic.size(); i++) {
      if (listOfMusic.get(i).getBookingReference().equals(bookingReference)) {
        bookingMusicCost += 500;
        MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(Integer.toString(bookingMusicCost));
      }
    }

    int bookingFloralCost = 0;
    for (int i = 0; i < listOfFloral.size(); i++) {
      if (listOfFloral.get(i).getBookingReference().equals(bookingReference)) {
        bookingFloralCost += listOfFloral.get(i).getFloralCost();
        MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(
            listOfFloral.get(i).getFloralName(), Integer.toString(bookingFloralCost));
      }
    }

    // Find the venue code related to the booking reference
    String bookingVenueCode = "";
    for (int i = 0; i < listOfBookings.size(); i++) {
      if (listOfBookings.get(i).getBookingReference().equals(bookingReference)) {
        bookingVenueCode = listOfBookings.get(i).getVenueCode();
      }
    }

    // INVOICE_CONTENT_VENUE_FEE("  * Venue hire - $%s"),
    int bookingHireFee = 0;
    for (int i = 0; i < listOfVenues.size(); i++) {
      if (listOfVenues.get(i).getVenueCode().equals(bookingVenueCode)) {
        bookingHireFee = listOfVenues.get(i).getHireFee();
        MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(Integer.toString(bookingHireFee));
      }
    }

    MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(
        Integer.toString(
            bookingHireFee + bookingCateringCost + bookingMusicCost + bookingFloralCost));
  }
}
