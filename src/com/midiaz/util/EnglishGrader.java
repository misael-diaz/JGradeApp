package com.midiaz.util;

import java.util.Scanner;
import java.util.ArrayList;

public class EnglishGrader extends Grader
{
  public EnglishGrader (Scanner scan, ArrayList<Double> grades)
  {
    super(scan, grades);
  }

  @Override
  public double grade ()
  {
    double sum = 0;
    do {
      sum += this.grades.get(this.grades.size() - 1);
      this.grades.remove(this.grades.size() - 1);
    } while (this.grades.size() != 0);
    final double mean = sum / ((double) this.menu.getNumStudents());
    return mean;
  }
}

/*

JGradeApp					April 24, 2024

source: EnglishGrader.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/

