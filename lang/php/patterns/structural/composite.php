<?php

interface Music
{
  public function play();
}

class Song implements Music
{
  public function play()
  {
    print('playing...');
  }
}

class Playlist implements Music
{
  protected $songs = [];

  public function addSong(Song $song)
  {
    $hash = spl_object_hash($song);

    if (!array_key_exists($hash, $this->songs)) {
      $this->songs[$hash] = $song;
    }
  }

  public function removeSong(Song $song)
  {
    $hash = spl_object_hash($song);

    if (array_key_exists($hash, $this->songs)) {
      unset($this->songs[$hash]);
    }
  }

  public function play()
  {
    foreach ($this->songs as $song) {
      $song->play();
    }
  }
}
