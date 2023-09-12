import { Component } from '@angular/core';
import { Pizza } from '../pizza';
import { PizzaService } from '../pizza.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-pizza',
  templateUrl: './update-pizza.component.html',
  styleUrls: ['./update-pizza.component.css']
})
export class UpdatePizzaComponent {
  id : number;
  pizza : Pizza = new Pizza();
  constructor(private pizzaService : PizzaService, private route:ActivatedRoute, private router : Router){}
  onSubmit()
  {
    this.pizzaService.updatePizza(this.id, this.pizza).subscribe( data=>{
      this.goToPizzaList();
    })
  }
  goToPizzaList()
  {
    this.router.navigate(['/pizzas']);
  }
  ngOnInit() : void
  {
    // get id from route
    this.id = this.route.snapshot.params['id'];
    this.pizzaService.getPizzaById(this.id).subscribe(data=>{
      this.pizza = data;
    }), (error: any) => console.log(error);

  }
}
