package nz.ac.auckland.se281;

import java.util.List;

public class Floral extends Services {
  private String bookingReference;
  private String serviceType;
  private String serviceName;
  private int serviceCost;

  public Floral(
      List<Booking> listOfBookings,
      String bookingReference,
      String serviceType,
      String serviceName,
      int serviceCost) {
    super(listOfBookings, bookingReference, serviceType);
    this.bookingReference = bookingReference;
    this.serviceType = serviceType;
    this.serviceName = serviceName;
    this.serviceCost = serviceCost;
  }
}
