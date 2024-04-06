package nz.ac.auckland.se281;

public class Booking {

  private String venueCode;
  private String bookingReference;
  private String venueName;
  private String dateOfBooking;
  private String customerEmail;
  private String numberOfAttendees;

  public Booking(String venueCode, String bookingReference, String venueName, String venueDate, String clientEmail, String venueAttendees) {
    this.venueCode = venueCode;
    this.bookingReference = bookingReference;
    this.venueName = venueName;
    this.dateOfBooking = venueDate;
    this.customerEmail = clientEmail;
    this.numberOfAttendees = venueAttendees;
  }

  public Object getBookingDate() {
    return this.dateOfBooking;
  }

  public String getVenueName() {
    return this.venueName;
  }

  public Object getvenueCode() {
    return this.venueCode;
  }


}
