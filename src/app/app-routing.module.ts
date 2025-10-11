import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ListaDocumentosComponent } from './lista-documentos/lista-documentos.component';
import { ListaExpedientesComponent } from './lista-expedientes/lista-expedientes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { AuthGuard } from './guards/auth.guard';
import { AuthorizationGuard } from './guards/authorization.guard';

const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "login", component: LoginComponent },
  {
    path: "admin", component: AdminTemplateComponent,
    canActivate: [AuthGuard],
    children: [
      { path: "home", component: HomeComponent },
      { path: "profile", component: ProfileComponent }, 
      {
        path: "admin/ListaDocumentos", component: ListaDocumentosComponent,
        canActivate: [AuthorizationGuard], data: { roles: ['ADMIN'] }
      },
      {
        path: "admin/ListaExpedientes", component: ListaExpedientesComponent,
        canActivate: [AuthorizationGuard], data: { roles: ['ADMIN'] }
      },
      { path: "dashboard", component: DashboardComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
