package nz.ac.auckland.se281;

import java.util.List;

public class Floral extends Services {

  public Floral(
      List<Booking> listOfBookings,
      String bookingReference,
      String serviceType,
      String name,
      int cost) {
    super(listOfBookings, bookingReference, serviceType);
  }
}
