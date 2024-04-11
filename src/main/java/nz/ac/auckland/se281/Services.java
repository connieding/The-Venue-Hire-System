package nz.ac.auckland.se281;

import java.util.List;

public class Services {
  private String bookingReference;
  private String serviceType;
  private String serviceName;
  protected boolean bookingReferenceExists = false;

  public Services(
      List<Booking> listOfBookings,
      String bookingReference,
      String serviceType,
      String serviceName) {
    this.bookingReference = bookingReference;
    this.serviceType = serviceType;
    this.serviceName = serviceName;

    for (Booking booking : listOfBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        this.bookingReferenceExists = true;
      }
    }
  }

  public void addService() {
    if (!bookingReferenceExists) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage(
          this.serviceType, this.bookingReference);
    } else if (this.serviceName != "") {
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(
          this.serviceType + " (" + this.serviceName + ")", this.bookingReference);
    } else {
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(this.serviceType, this.bookingReference);
    }
  }
}
