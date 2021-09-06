import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  intervalId : number | undefined;
  message: string = '';
  // @ts-ignore
  remainingTime: number;

  @Input('myTimer') seconds = 10;

  //constructor() { }

  ngOnInit(): void {
    this.reset();
  }

  clearTimer(){
    clearInterval(this.intervalId);
  }

  start(){
    this.clearTimer();
    this.intervalId = window.setInterval(() =>{
      this.remainingTime--;
      if (this.remainingTime === 0){
        this.message = 'Time\'s up!';
        this.clearTimer();
      }
      else {
        this.message = `${this.remainingTime} seconds left.`
      }
    }, 1000);
    if (this.remainingTime <= 0){
      this.remainingTime = this.seconds;
    }
  }

  stop(){
    this.clearTimer();
    this.message = `Pausing at ${this.remainingTime} seconds.`
  }

  reset(){
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = `Click to start the countdown.`
  }
}
