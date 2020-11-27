<?php

namespace Activity\Composite;

/**
 * An ActivityComposite provides a composition of activities.
 */
class ActivityComposite extends Activity
{
  protected $activities = [];

  public function __construct(Activity $activity)
  {
    $this->add($activity);
  }

  public function add(Activity $activity)
  {
    $hash = spl_object_hash($activity);
    $this->activities[$hash] = $activity;
  }

  public function remove(Activity $activity)
  {
    $hash = spl_object_hash($activity);
    unset($this->activities[$hash]);
  }

  public function show()
  {
    $composites = [];

    foreach ($this->activities as $activity) {
      $composites[] = $activity->show();
    }

    return $composites;
  }
}
