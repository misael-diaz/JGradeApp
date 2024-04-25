package com.midiaz.util;

import java.util.Scanner;
import java.util.ArrayList;

public class SpanishGrader extends Grader
{
  public SpanishGrader (Scanner scan, ArrayList<Double> grades)
  {
    super(scan, grades);
  }

  @Override
  public double grade ()
  {
    int i = 0;
    double sum = 0;
    while (i != this.grades.size()) {
      sum += this.grades.get(i);
      ++i;
    }
    final double mean = sum / ((double) this.grades.size());
    return mean;
  }
}

/*

JGradeApp					April 24, 2024

source: SpanishGrader.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/

