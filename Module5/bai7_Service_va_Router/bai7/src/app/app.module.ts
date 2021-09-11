import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimelinesComponent } from './PracticeUngDungTinhThoiGianSong/timelines/timelines.component';
import { YoutubePlaylistComponent } from './PracticeUngDungNgheNhac/youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './PracticeUngDungNgheNhac/youtube-player/youtube-player.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelinesComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
