import { Component } from '@angular/core';
import { Admin } from '../admin';
import { PizzaService } from '../pizza.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-create-admin',
  templateUrl: './create-admin.component.html',
  styleUrls: ['./create-admin.component.css']
})
export class CreateAdminComponent {
  admin : Admin;
  constructor( private pizzaService : PizzaService,  private route : ActivatedRoute, private router:Router, private authenService : AuthenticationService){}
  ngOnInit()
  {
    this.admin = new Admin();
    this.authenService.logging();
  }
  private goToHomePage()
  {
    this.authenService.logout();
  }
  private createAdmin()
  {
    this.pizzaService.createAdmin(this.admin).subscribe({
      next: (response) => {
        alert("Successfully Created");
        this.goToHomePage();
      },
      error: (err) => {
        console.error('Error creating admin!', err);
      }
    });
  }
  onSubmit()
  {
    this.createAdmin();
  }
}
