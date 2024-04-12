package nz.ac.auckland.se281;

import java.util.List;

public abstract class Services {
  private String bookingReference;
  private String serviceType;
  protected boolean bookingReferenceExists = false;

  public Services(List<Booking> listOfBookings, String bookingReference, String serviceType) {
    this.bookingReference = bookingReference;
    this.serviceType = serviceType;

    for (Booking booking : listOfBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        this.bookingReferenceExists = true;
      }
    }
  }

  public void checkBookingExists() {
    if (!bookingReferenceExists) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage(
          this.serviceType, this.bookingReference);
    }
  }

  public abstract void addService();
}
