package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.binding.PassengerInfo;
import com.rest.binding.TicketInfo;

@RestController
public class TicketRestController {
	
	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<TicketInfo> getTicket(@PathVariable("ticketId") Integer ticketId){
		
		TicketInfo tinfo=new TicketInfo();
		tinfo.setTicketId(1234);
		tinfo.setPnr("JLJL6868");
		tinfo.setTicketStatus("CONFIRMED");
		return new ResponseEntity<>(tinfo,HttpStatus.OK);
	}

	@PostMapping(value="/ticket",
		produces= {"application/json"},
		consumes= {"application/json"})
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo request){
		System.out.println(request);
		//logic to book ticket
		TicketInfo tinfo=new TicketInfo();
		tinfo.setTicketId(1234);
		tinfo.setPnr("JLJL6868");
		tinfo.setTicketStatus("CONFIRMED");
		
		return new ResponseEntity<>(tinfo,HttpStatus.CREATED);
	}
	
	@PutMapping("/ticket")
	public ResponseEntity<String> updateTicket(@RequestBody PassengerInfo request){
		System.out.println(request);
		
		return new ResponseEntity<>("Ticket Update",HttpStatus.OK);
	}
	
	@DeleteMapping("/ticket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId){
		//@PathVariable -specific record I am deleting
		return new ResponseEntity<>("Ticket Deleted",HttpStatus.OK);
	}
	@DeleteMapping("/ticket")
	public ResponseEntity<String> deleteTicketBody(@RequestBody PassengerInfo requests){
		//@PathVariable -specific record I am deleting
		return new ResponseEntity<>("Ticket Deleted Successfully by body",HttpStatus.OK);
	}
}
