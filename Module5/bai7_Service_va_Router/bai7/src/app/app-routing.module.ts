import { NgModule } from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {TimelinesComponent} from "./PracticeUngDungTinhThoiGianSong/timelines/timelines.component";
import {YoutubePlaylistComponent} from "./PracticeUngDungNgheNhac/youtube-playlist/youtube-playlist.component";
import {YoutubePlayerComponent} from "./PracticeUngDungNgheNhac/youtube-player/youtube-player.component";

const routes: Routes = [
  {
    path: 'timelines',
    component: TimelinesComponent,
  },
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{
      path: ':id',
      component: YoutubePlayerComponent
    }]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
