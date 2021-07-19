import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  slideConfig = { slidesToShow: 4, dots: true, centerMode: true };

  ngOnInit(): void {}
}
