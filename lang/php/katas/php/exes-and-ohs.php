<?php
// Exes and Ohs

function XO($s) {
  $segments = str_split(strtolower($s));

  $x = array_intersect($segments, ['x']);
  $o = array_intersect($segments, ['o']);
  
  return count($x) === count($o);
}

XO('xo');     // true
XO('XO');     // true
XO('xo0');    // true
XO('xxxoo');  // false
XO('xxxoo');  // true
XO("xxOo");   // true
