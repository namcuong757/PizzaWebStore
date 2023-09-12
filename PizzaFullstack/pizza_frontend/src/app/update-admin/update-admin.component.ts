import { Component } from '@angular/core';
import { Admin } from '../admin';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { PizzaService } from '../pizza.service';

@Component({
  selector: 'app-update-admin',
  templateUrl: './update-admin.component.html',
  styleUrls: ['./update-admin.component.css']
})
export class UpdateAdminComponent {
  admin : Admin = new Admin();
  constructor(private authenticationService : AuthenticationService, private pizzaService : PizzaService, private router : Router){}
  onSubmit()
  {
    this.pizzaService.updateAdmin(this.admin.adminID, this.admin).subscribe(data=>{
      this.router.navigate(['view-profile']);
    });
  }
  ngOnInit()
  {
    const currentAdmin = this.authenticationService.getCurrentAdmin();
    this.pizzaService.getAdminByAdminId(currentAdmin).subscribe(data=>{
      this.admin = data;
    });
  }
}
