package com.olive.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olive.model.Order;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	

	@RequestMapping("/msg")
	public ResponseEntity<String> data(){

		return new ResponseEntity<String>("WELCOME Producer App Order :: " , HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveItem(@RequestBody Order order){
                      
		return new ResponseEntity<String>("Order Item save  :: " + order.toString() ,HttpStatus.OK);
	}
	

	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrderItem(){
		 List<Order> asList = Arrays.asList(
				 new Order(10, "PEN", 200.0),
				 new Order(20, "BOOK", 200.0),
				 new Order(30, "PENSIL", 200.0),
				 new Order(40, "INK", 200.0),
				 new Order(50, "BAG", 200.0)
				 );
                      
		return new ResponseEntity<List<Order>>(asList ,HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Order> getOneItem(@PathVariable int id){
		       
		return new ResponseEntity<Order>( new Order(id, "Sample", 300.0),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneItem1(@PathVariable int id){
		       
		return new ResponseEntity<String>( "Item deleted ID : " +id ,HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> deleteOneItem(
			@RequestBody Order order,
			@PathVariable int id){
		       
		return new ResponseEntity<String>( "Order Item Modifies ID  : "+
		new Order(id, "Phone", 10000.0)  ,HttpStatus.OK);
	}
	
}
