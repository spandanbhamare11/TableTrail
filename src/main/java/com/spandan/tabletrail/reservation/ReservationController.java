package com.spandan.tabletrail.reservation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
@RestController @RequestMapping("/api/reservations")
public class ReservationController {
 private final ReservationRepository repository;
 public ReservationController(ReservationRepository repository){this.repository=repository;}
 @GetMapping public List<RestaurantReservation> all(){return repository.findAll();}
 @GetMapping("/{id}") public RestaurantReservation one(@PathVariable Long id){return repository.findById(id).orElseThrow(()->new NoSuchElementException("Reservation not found: "+id));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public RestaurantReservation create(@Valid @RequestBody RestaurantReservation reservation){reservation.setId(null);return repository.save(reservation);}
 @PutMapping("/{id}") public RestaurantReservation update(@PathVariable Long id,@Valid @RequestBody RestaurantReservation input){RestaurantReservation r=one(id);r.setCustomerName(input.getCustomerName());r.setEmail(input.getEmail());r.setReservationTime(input.getReservationTime());r.setPartySize(input.getPartySize());r.setSpecialRequest(input.getSpecialRequest());return repository.save(r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){repository.delete(one(id));}
}
