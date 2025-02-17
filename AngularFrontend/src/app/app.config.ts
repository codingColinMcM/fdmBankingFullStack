import { provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { ApplicationConfig } from '@angular/core';

import { routes } from './app-routing.module';

export const appConfig: ApplicationConfig = {
  providers: [
  provideZoneChangeDetection({ eventCoalescing: true }), 
  provideRouter(routes),
  provideHttpClient(),
  ]
};
