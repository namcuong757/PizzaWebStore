import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PizzaListComponent } from './pizza-list/pizza-list.component';
import { CreatePizzaComponent } from './create-pizza/create-pizza.component';
import { UpdatePizzaComponent } from './update-pizza/update-pizza.component';
import { AuthenticationComponent } from './authentication/authentication.component';
import { AppComponent } from './app.component';
import { CreateAdminComponent } from './create-admin/create-admin.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { UpdateAdminComponent } from './update-admin/update-admin.component';
import { AdminOrdersComponent } from './admin-orders/admin-orders.component';

const routes: Routes = [
  {path: "homepage" , redirectTo: '/', pathMatch: 'full'},
  {path: "pizzas", component : PizzaListComponent},
  {path: "create-pizza", component : CreatePizzaComponent},
  {path: "update-pizza/:id", component : UpdatePizzaComponent},
  {path: "authentication", component : AuthenticationComponent},
  {path: "create-admin", component : CreateAdminComponent},
  {path: "view-profile", component : AdminProfileComponent},
  {path: "update-profile", component: UpdateAdminComponent},
  {path: "admin-orders", component: AdminOrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
