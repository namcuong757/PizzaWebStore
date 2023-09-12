import { Component, OnInit } from '@angular/core';
import { Pizza } from '../pizza';
import { PizzaService } from '../pizza.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pizza-list',
  templateUrl: './pizza-list.component.html',
  styleUrls: ['./pizza-list.component.css']
})
export class PizzaListComponent implements OnInit{
  pizzas : Pizza[];
  constructor(private pizzaService : PizzaService, private router:Router){}
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
    this.pizzaService.getPizzaList().subscribe(data =>{
      this.pizzas = data;
    });
  }
}
