import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpresaCreate } from './empresa-create';

describe('EmpresaCreate', () => {
  let component: EmpresaCreate;
  let fixture: ComponentFixture<EmpresaCreate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmpresaCreate],
    }).compileComponents();

    fixture = TestBed.createComponent(EmpresaCreate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
