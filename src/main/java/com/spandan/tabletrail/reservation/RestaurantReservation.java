package com.spandan.tabletrail.reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
@Entity @Table(name="restaurant_reservations")
public class RestaurantReservation {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank private String customerName;
    @Email @NotBlank private String email;
    @NotNull @FutureOrPresent private LocalDateTime reservationTime;
    @Positive private int partySize;
    private String specialRequest;
    public RestaurantReservation(){}
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public LocalDateTime getReservationTime(){return reservationTime;} public void setReservationTime(LocalDateTime v){reservationTime=v;}
    public int getPartySize(){return partySize;} public void setPartySize(int v){partySize=v;}
    public String getSpecialRequest(){return specialRequest;} public void setSpecialRequest(String v){specialRequest=v;}
}
