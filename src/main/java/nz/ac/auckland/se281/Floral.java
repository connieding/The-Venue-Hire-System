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
    super(listOfBookings, bookingReference, serviceType, serviceName);
    this.bookingReference = bookingReference;
    this.serviceType = serviceType;
    this.serviceName = serviceName;
    this.serviceCost = serviceCost;
  }

  public Object getBookingReference() {
    return this.bookingReference;
  }

  public int getFloralCost() {
    return this.serviceCost;
  }

  public String getFloralName() {
    return this.serviceName;
  }
}
