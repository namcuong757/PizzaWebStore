import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePizzaComponent } from './create-pizza.component';

describe('CreatePizzaComponent', () => {
  let component: CreatePizzaComponent;
  let fixture: ComponentFixture<CreatePizzaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatePizzaComponent]
    });
    fixture = TestBed.createComponent(CreatePizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
