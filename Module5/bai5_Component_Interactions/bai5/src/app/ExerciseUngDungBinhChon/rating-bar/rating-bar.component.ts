import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  @Input('maxRating') maxRating : number = 0;
  @Input('previousRating') previousRating : number = 0;
  @Input('showRating') showRating : boolean = false;

  ratingUnits : IRatingUnit[] = [];

  constructor() { }

  ngOnInit(): void {
    this.init();
  }

  init() {
    this.ratingUnits = Array.from({length: this.maxRating}, (_, index) =>
      ({value: index + 1,
      active: index < this.previousRating}));
  }

  select(index: number){
    this.previousRating = index + 1;
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.previousRating);
  }

  enter(index: number){
    this.ratingUnits.forEach((item, idx) => item.active = idx <= index);
  }

  reset(){
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.previousRating);
  }
}

interface IRatingUnit{
  value: number;
  active: boolean;
}
