package nz.ac.auckland.se281;

import java.util.List;

public class Music extends Services {
  private String bookingReference;
  private String serviceType;

  public Music(List<Booking> listOfBookings, String bookingReference, String serviceType) {
    super(listOfBookings, bookingReference, serviceType);

    this.bookingReference = bookingReference;
    this.serviceType = serviceType;
  }
}
