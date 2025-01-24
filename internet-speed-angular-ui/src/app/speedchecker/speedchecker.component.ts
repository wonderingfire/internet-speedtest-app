import { Component } from '@angular/core';
import { SpeedcheckerService } from '../services/speedchecker.service';

interface InternetSpeed {
  id: string;
  download_speed: number;
  upload_speed: number;
  init_datetime: string;
  end_datetime: string;
  isp_name: string;
}

@Component({
  standalone: true,
  selector: 'app-speedchecker',
  imports: [],
  templateUrl: './speedchecker.component.html',
  styleUrl: './speedchecker.component.scss',
})
export class SpeedcheckerComponent {
  loading: boolean = false;

  internetSpeed: InternetSpeed = {
    id: '',
    download_speed: 0.0,
    upload_speed: 0.0,
    init_datetime: '',
    end_datetime: '',
    isp_name: '',
  };
  constructor(private speedCheckerService: SpeedcheckerService) {}

  ngOnInit() {
    this.fetchInternetSpeed();
  }

  fetchInternetSpeed(): void {
    this.speedCheckerService.fetchInternetSpeed().subscribe({
      next: (response) => {
        this.internetSpeed = response;
        console.log(
          'Internet Speed Test Data: ' + JSON.stringify(this.internetSpeed)
        );
      },
      complete: () => {
        console.log('Done calling the test endpoint');
      },
      error: (err) => {
        console.error('An error occured: ' + err);
      },
    });
  }
}
