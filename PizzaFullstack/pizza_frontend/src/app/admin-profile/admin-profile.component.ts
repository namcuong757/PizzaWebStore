import { Component } from '@angular/core';
import { Admin } from '../admin';
import { AuthenticationService } from '../authentication.service';
import { PizzaService } from '../pizza.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent {
  admin : Admin = new Admin();
  constructor(private authenticationService : AuthenticationService, private pizzaService : PizzaService, private router: Router){}
  ngOnInit()
  {
    const currentAdmin = this.authenticationService.getCurrentAdmin();
    this.pizzaService.getAdminByAdminId(currentAdmin).subscribe(data=>{
      this.admin = data;
    });
  }
  updateAdmin()
  {
    console.log('updateAdmin called');
    this.router.navigate(['update-profile']);
  }
  viewOrderHistory()
  {
    this.router.navigate(['admin-orders']);
  }
}
