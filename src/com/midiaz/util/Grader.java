package com.midiaz.util;

import java.util.Scanner;
import java.util.ArrayList;
import com.midiaz.menu.Menu;

// defines base class for Math, English, and Spanish Graders
public class Grader
{
  protected Scanner scan = null;
  protected ArrayList<Double> grades = null;
  protected Menu menu = null;

  Grader (Scanner scan, ArrayList<Double> grades)
  {
    this.scan = scan;
    this.grades = grades;
  }

  public void bind (Menu menu)
  {
    this.menu = menu;
  }

  public void prompt ()
  {
	return;
  }

  public void scanGrades ()
  {
    int grades = 0;
    double grade = Double.NEGATIVE_INFINITY;
    while (grade < 0 || this.grades.size() != this.menu.getNumStudents()) {
      if (0 == grades) {
	System.out.printf("Please input the first grade:");
      } else {
	System.out.printf("Please input the next grade:");
      }
      grade = scan.nextDouble();
      if (grade < 0) {
	System.out.println("Please input a valid positive grade");
      } else {
	this.grades.add(grade);
	++grades;
      }
    }
  }

  public double grade ()
  {
    if (null == this.grades) {
      System.out.println("grade: InitializationError");
      return Double.NEGATIVE_INFINITY;
    }

    if (this.grades.size() == 0) {
      System.out.println("grade: NoGradesError");
      return Double.NEGATIVE_INFINITY;
    }

    double grades = 0;
    for (final double grade : this.grades) {
      grades += grade;
    }

    grades /= ((double) this.grades.size());
    final double mean = grades;
    return mean;
  }
}

/*

JGradeApp					April 24, 2024

source: Grader.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/

