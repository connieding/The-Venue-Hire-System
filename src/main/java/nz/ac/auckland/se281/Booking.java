package nz.ac.auckland.se281;

public class Booking {

  private String venueCode;
  private String bookingReference;
  private String venueName;
  private String dateOfBooking;
  private String avaliableDate;
  private String dateBooked;
  private String customerEmail;
  private String numberOfAttendees;
  private int nextDay;
  private int nextMonth;
  private int nextYear;

  public Booking(
      String venueCode,
      String bookingReference,
      String venueName,
      String venueDate,
      String clientEmail,
      String venueAttendees,
      String dateBooked) {
    this.venueCode = venueCode;
    this.bookingReference = bookingReference;
    this.venueName = venueName;
    this.dateOfBooking = venueDate;
    this.avaliableDate = venueDate;
    this.customerEmail = clientEmail;
    this.numberOfAttendees = venueAttendees;
    this.dateBooked = dateBooked;

    String[] dateParts = venueDate.split("/");
    this.nextDay = Integer.parseInt(dateParts[0]);
    this.nextMonth = Integer.parseInt(dateParts[1]);
    this.nextYear = Integer.parseInt(dateParts[2]);
  }

  public String getBookingDate() {
    return this.dateOfBooking;
  }

  public String getVenueName() {
    return this.venueName;
  }

  public String getVenueCode() {
    return this.venueCode;
  }

  public String getBookingReference() {
    return this.bookingReference;
  }

  public String getNextAvaliableDate() {
    String avaliableDay = "";
    String avaliableMonth = "";

    // Increment the date by one day
    nextDay++;
    // Check if the day is greater than 31, if so move to next month
    if (nextDay > 31) {
      nextDay = 1;
      nextMonth++;
      // Check if the month is greater than 12, if so move to next year
      if (nextMonth > 12) {
        nextMonth = 1;
        nextYear++;
      }
    }

    // Format the date to be in the correct format
    if (nextDay < 10) {
      avaliableDay = "0" + nextDay;
    }
    if (nextMonth < 10) {
      avaliableMonth = "0" + nextMonth;
    }
    if (nextDay >= 10 && nextMonth >= 10) {
      avaliableDay = Integer.toString(nextDay);
      avaliableMonth = Integer.toString(nextMonth);
    }

    avaliableDate = avaliableDay + "/" + avaliableMonth + "/" + nextYear;
    return avaliableDate;
  }

  public String getClientEmail() {
    return this.customerEmail;
  }

  public String getDateBooked() {
    return this.dateBooked;
  }

  public String getNumberOfAttendees() {
    return this.numberOfAttendees;
  }
}
