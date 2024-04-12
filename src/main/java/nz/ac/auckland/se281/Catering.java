package nz.ac.auckland.se281;

import java.util.List;

public class Catering extends Services {

  private String bookingReference;
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
    this.serviceName = serviceName;
    this.costPerPerson = costPerPerson;
    this.numberOfAttendees = numberOfAttendees;
  }

  public Object getBookingReference() {
    return this.bookingReference;
  }

  public String getCateringName() {
    return this.serviceName;
  }

  public int cateringCost() {
    return this.costPerPerson * Integer.parseInt(this.numberOfAttendees);
  }

  @Override
  public void addService() {
    if (bookingReferenceExists) {
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(
          "Catering (" + this.serviceName + ")", this.bookingReference);
    }
  }
}
