import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NameCardComponent } from './PracticeNameCard/name-card/name-card.component';
import { ProgressBarComponent } from './PracticeProgressBar/progress-bar/progress-bar.component';
import { RatingBarComponent } from './ExerciseUngDungBinhChon/rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './ExerciseUngDungCountDown/countdown-timer/countdown-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    NameCardComponent,
    ProgressBarComponent,
    RatingBarComponent,
    CountdownTimerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
