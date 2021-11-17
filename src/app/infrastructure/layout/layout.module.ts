import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from 'src/app/material/material.module';
import { PublicLayoutComponent } from './public-layout/public-layout.component';
import { RouterModule } from '@angular/router';
import { PrivateLayoutComponent } from './private-layout/private-layout.component';



@NgModule({
  declarations: [PublicLayoutComponent, PrivateLayoutComponent],
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule
  ],
  exports: [PublicLayoutComponent, PrivateLayoutComponent]
})
export class LayoutModule { }
