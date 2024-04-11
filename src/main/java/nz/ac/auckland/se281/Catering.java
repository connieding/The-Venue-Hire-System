package nz.ac.auckland.se281;

import java.util.List;

public class Catering extends Services {

  private String bookingReference;
  private String serviceType;
  private String serviceName;
  private String numberOfAttendees;
  private int costPerPerson;

  public Catering(
      List<Booking> listOfBookings,
      String bookingReference,
      String serviceType,
      String serviceName,
      int costPerPerson,
      String numberOfAttendees) {
    super(listOfBookings, bookingReference, serviceType);

    this.bookingReference = bookingReference;
    this.serviceType = serviceType;
    this.serviceName = serviceName;
    this.costPerPerson = costPerPerson;
    this.numberOfAttendees = numberOfAttendees;
  }
}
