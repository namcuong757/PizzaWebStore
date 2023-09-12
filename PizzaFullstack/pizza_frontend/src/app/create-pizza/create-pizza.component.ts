import { Component } from '@angular/core';
import { Pizza } from '../pizza';
import { PizzaService } from '../pizza.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { Admin } from '../admin';

@Component({
  selector: 'app-create-pizza',
  templateUrl: './create-pizza.component.html',
  styleUrls: ['./create-pizza.component.css']
})
export class CreatePizzaComponent {
  pizza : Pizza;
  admin : Admin;
  constructor(private pizzaService : PizzaService,  private route : ActivatedRoute, private router:Router, private authenticationService : AuthenticationService){}
  ngOnInit(){
    this.pizza = new Pizza;
  }
  goToPizzaList()
  {
    this.router.navigate(['/pizzas']);
  }
  private createPizza(pizza : Pizza)
  {
    const currentAdmin = this.authenticationService.getCurrentAdmin();
    this.pizzaService.getAdminByAdminId(currentAdmin).subscribe( data=>{
      this.admin = data;
      if(currentAdmin != null)
      {
        this.pizza.admin_id = currentAdmin;
        this.pizza.server = this.admin.name;
        this.pizzaService.createPizza(pizza).subscribe(
          {
            next: (response) => {
              console.log('Pizza created!', response);
              this.goToPizzaList();
            },
            error: (err) => {
              console.error('Error creating pizza!', err);
            }
          });
      }
    });
  }
  
  onSubmit()
  {
    this.createPizza(this.pizza);

  }
}
