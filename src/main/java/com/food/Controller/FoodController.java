package com.food.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.Service.ServiceImpl;
import com.food.entity.Customer;
import com.food.entity.Food;
import com.food.exception.AmtException;
import com.food.repo.FoodRepo;
import com.food.utility.OrderConformation;

import jakarta.websocket.server.PathParam;

@RestController
public class FoodController {
	@Autowired
	OrderConformation orderconformation;
	
	public OrderConformation getOrderconformation() {
		return orderconformation;
	}
	public void setOrderconformation(OrderConformation orderconformation) {
		this.orderconformation = orderconformation;
	}
	
	
	
	@Autowired
	   ServiceImpl serviceimpl;
	@Autowired
		FoodRepo foodrepo;	
		public FoodRepo getFoodrepo() {
			return foodrepo;
		}
		public void setFoodrepo(FoodRepo foodrepo) {
			this.foodrepo = foodrepo;
		}	
		
	
	public FoodController(FoodRepo foodrepo) {
			super();
			this.foodrepo = foodrepo;
		}
	
	
	@GetMapping("/getFood")
		public ResponseEntity<List<Food>> getf(){
			List<Food> food=foodrepo.findAll();
			return new ResponseEntity<>(food,HttpStatus.OK);
		}
	
	
	@GetMapping("/getname/{fid}")
	public ResponseEntity<Optional<Food>> infood(@PathVariable("fid") Integer fid){
	Optional<Food> f=foodrepo.findById(fid);
	//OrderConformation order =new OrderConformation();
	//String s = order.payment(f.getAmt());
	return new ResponseEntity<>(f,HttpStatus.OK);
	}
	
	@GetMapping("/Food/{fname}")
	public ResponseEntity<Food> infood(@PathVariable("fname")String fname){
	Food f=foodrepo.findByFname(fname);
	return new ResponseEntity<>(f,HttpStatus.OK);
	}	
	public ServiceImpl getServiceimpl() {
		return serviceimpl;
	}

	public void setServiceimpl(ServiceImpl serviceimpl) {
		this.serviceimpl = serviceimpl;
	}
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getc(){
		List<Customer> food=serviceimpl.getFood();
		return new ResponseEntity<>(food,HttpStatus.OK);
	}
	
	@PostMapping("/cus")
	public ResponseEntity<String> incus(@RequestBody Customer c ){
		String s=serviceimpl.insertCus(c);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	
	@PutMapping("/cusupdate")
	public ResponseEntity<String> upcus(@RequestBody Customer c ){
		String s=serviceimpl.updateCus(c);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	@DeleteMapping("/Cusdelete/{cid}")
	public ResponseEntity<String> incus(@PathParam("cid") Integer cid ){
		String s=serviceimpl.deleteCus(cid);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@GetMapping("orderconfim/foodname/{fname}/amt/{amt}/option/{option}")
	public ResponseEntity<String> amt(@PathVariable("fname")String fname,@PathVariable("amt")Integer amt,@PathVariable("option")Integer option) throws AmtException{
		Food f=foodrepo.findByFname(fname);
		 int actualamt=f.getAmt();
		String s=orderconformation.payment(amt, option, actualamt);
		return new ResponseEntity<>(s,HttpStatus.OK);
	
	}
}