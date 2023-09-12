import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PizzaListComponent } from './pizza-list/pizza-list.component';
import { CreatePizzaComponent } from './create-pizza/create-pizza.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdatePizzaComponent } from './update-pizza/update-pizza.component';
import { AuthenticationComponent } from './authentication/authentication.component';
import { CreateAdminComponent } from './create-admin/create-admin.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { UpdateAdminComponent } from './update-admin/update-admin.component';
import { AdminOrdersComponent } from './admin-orders/admin-orders.component';
import { MenuViewComponent } from './menu-view/menu-view.component';
@NgModule({
  declarations: [
    AppComponent,
    PizzaListComponent,
    CreatePizzaComponent,
    UpdatePizzaComponent,
    AuthenticationComponent,
    CreateAdminComponent,
    AdminProfileComponent,
    UpdateAdminComponent,
    AdminOrdersComponent,
    MenuViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
