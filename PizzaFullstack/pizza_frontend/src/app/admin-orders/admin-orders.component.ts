import { Component, OnInit } from '@angular/core';
import { Pizza } from '../pizza';
import { Router } from '@angular/router';
import { PizzaService } from '../pizza.service';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnInit{
  pizzas : Pizza[];
  temp : Pizza[];
  constructor(private pizzaService : PizzaService, private router:Router, private authenticationService : AuthenticationService){}
  ngOnInit(): void {
    this.pizzas = [];
    this.getPizzas();
  }
  updatePizza(id : number)
  {
    this.router.navigate(['update-pizza', id]);
  }
  deletePizza(id : number)
  {
    this.pizzaService.deletePizza(id).subscribe(data=>{
      this.getPizzas();
    });
  }
  private getPizzas()
  {
    const currentAdmin = this.authenticationService.getCurrentAdmin();
    this.pizzaService.getPizzaList().subscribe(data =>{
      
      this.temp = data;
      for(var i of this.temp)
      {
        if(i.admin_id == currentAdmin)
        {
          this.pizzas.push(i);
        }
    }
    });
    
  }
}
