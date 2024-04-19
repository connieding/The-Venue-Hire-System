package nz.ac.auckland.se281;

public class Booking {

  private String venueCode;
  private String bookingReference;
  private String venueName;
  private String dateOfBooking;
  private String dateBooked;
  private String customerEmail;
  private String numberOfAttendees;

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
    this.customerEmail = clientEmail;
    this.numberOfAttendees = venueAttendees;
    this.dateBooked = dateBooked;
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

  public String getNextAvaliableDate(String tempDate) {

    String[] dateParts = tempDate.split("/");
    int day = Integer.parseInt(dateParts[0]);
    int month = Integer.parseInt(dateParts[1]);
    int year = Integer.parseInt(dateParts[2]);

    String avaliableDay;
    String avaliableMonth;
    String nextAvaliableDate;

    // Checks if last day of the year
    if (day == 31 && month == 12) {
      return "01/01/" + Integer.toString(year + 1);

      // checks if its a month with 28 days
    } else if (day == 28 && month == 2) {
      return "01/03/" + Integer.toString(year);

      // Check if it is a month with only 30 days
    } else if ((day == 30 & month == 4)
        || (day == 30 & month == 6)
        || (day == 30 & month == 9)
        || (day == 30 & month == 11)) {
      return "01/" + Integer.toString(month + 1) + "/" + Integer.toString(year);

      // Checks if its the last day of the month
    } else if (day == 31) {
      return "01/" + Integer.toString(month + 1) + "/" + Integer.toString(year);

    } else {
      // Make correct format for the date
      avaliableDay = String.format("%02d", day + 1);
      avaliableMonth = String.format("%02d", month);
      nextAvaliableDate = avaliableDay + "/" + avaliableMonth + "/" + year;

      return nextAvaliableDate;
    }
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
