package com.midiaz.menu;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu
{
  private int tag = 0;				// for refering to a course with a tag
  private int numStudents = 0;			// student count enrolled in the course
  private Scanner scan = null;			// for capturing user input
  private ArrayList<Integer> tags = null;	// for keeping track of grades courses

  public Menu (Scanner scan, ArrayList<Integer> tags)
  {
    this.scan = scan;
    this.tags = tags;
  }

  public int tag ()
  {
    return this.tag;
  }

  public int getNumStudents()
  {
    return this.numStudents;
  }

  // uses recursion to prompt the user until all the courses have been graded
  public void prompt ()
  {
    if (this.numStudents == 0) {
      this.scanNumStudents();
    }

    // checks if we are done
    if (this.tags.size() == 3) {
      return;
    }

    String request = "Please enter the tag of the course you wish to grade ";
    String legend = "(0: Math 1: Spanish 2: English):";
    String msg = (request + legend);
    System.out.printf(msg);

    final int tag = scan.nextInt();
    if (tag < 0 || tag > 2) {
      System.out.println("Please input a valid tag");
      this.prompt();
      return;
    }

    if (this.tags.contains(tag)) {
      System.out.println("We have already graded that course");
      System.out.println("Please input a different tag");
      this.prompt();
      return;
    }

    this.tag = tag;
    this.tags.add(this.tag);
    switch (this.tag) {
      case 0:
	System.out.println("Math");
	break;
      case 1:
	System.out.println("Spanish");
	break;
      default:
	System.out.println("English");
    }

    this.prompt();
  }

  private void scanNumStudents ()
  {
    int numStudents = 0;
    while (numStudents <= 0) {
      System.out.printf("Please input the number of students:");
      numStudents = this.scan.nextInt();
      if (numStudents <= 0) {
	System.out.printf("Please input a number greater than zero\n");
      }
    }
    this.numStudents = numStudents;
  }
}

/*

   JGradeApp					April 23, 2024

source: Menu.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/

