import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SpeedcheckerComponent } from './speedchecker/speedchecker.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SpeedcheckerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'internet-speed-angular-ui';
}
