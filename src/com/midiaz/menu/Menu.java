package com.midiaz.menu;

import java.util.Scanner;
import java.util.ArrayList;
import com.midiaz.util.MathGrader;
import com.midiaz.util.SpanishGrader;
import com.midiaz.util.EnglishGrader;

public class Menu
{
  private int tag = 0;				// for refering to a course with a tag
  private int numStudents = 0;			// student count enrolled in the course
  private double avgMathGrade = 0;		// the course average grade
  private double avgSpanishGrade = 0;		// the course average grade
  private double avgEnglishGrade = 0;		// the course average grade
  private boolean hasGottenAllGrades = false;	// for sane check
  private boolean hasFinishedGrading = false;	// for sane check
  private MathGrader mathGrader = null;		// course grader util
  private SpanishGrader spanishGrader = null;	// course grader util
  private EnglishGrader englishGrader = null;	// course grader util
  private Scanner scan = null;			// for capturing user input
  private ArrayList<Integer> tags = null;	// for keeping track of grades courses

  public Menu (Scanner scan,
	       ArrayList<Integer> tags,
	       MathGrader mathGrader,
	       SpanishGrader spanishGrader,
	       EnglishGrader englishGrader)
  {
    this.scan = scan;
    this.tags = tags;
    this.mathGrader = mathGrader;
    this.spanishGrader = spanishGrader;
    this.englishGrader = englishGrader;
    this.mathGrader.bind(this);
    this.spanishGrader.bind(this);
    this.englishGrader.bind(this);
  }

  public int tag ()
  {
    return this.tag;
  }

  public int getNumStudents()
  {
    return this.numStudents;
  }

  public double getAvgMathGrade ()
  {
    return this.avgMathGrade;
  }

  public double getAvgSpanishGrade ()
  {
    return this.avgSpanishGrade;
  }

  public double getAvgEnglishGrade ()
  {
    return this.avgEnglishGrade;
  }

  // uses recursion to prompt the user until all the courses have been graded
  public void prompt ()
  {
    if (this.numStudents == 0) {
      this.scanNumStudents();
    }

    // checks if we are done
    if (this.tags.size() == 3) {
      this.hasGottenAllGrades = true;
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
      System.out.println("We have already scanned the grades of that course");
      System.out.println("Please input a different tag");
      this.prompt();
      return;
    }

    this.tag = tag;
    this.tags.add(this.tag);
    switch (this.tag) {
      case 0:
	System.out.println("Math");
	this.scanMathGrades();
	break;
      case 1:
	System.out.println("Spanish");
	this.scanSpanishGrades();
	break;
      default:
	System.out.println("English");
	this.scanEnglishGrades();
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

  public void grade ()
  {
    if (this.tags.size() == 0 || false == this.hasGottenAllGrades) {
      System.out.println("you must invoke prompt() method first\n");
      return;
    }

    this.avgMathGrade = this.mathGrader.grade();
    this.avgSpanishGrade = this.spanishGrader.grade();
    this.avgEnglishGrade = this.englishGrader.grade();
    this.hasFinishedGrading = true;
  }

  public void report ()
  {
    if (false == this.hasFinishedGrading) {
      System.out.println("you must invoke grade() method before invoking report()\n");
      return;
    }

    System.out.println("Averaged students grades by course:");
    System.out.printf("averaged Math grade: %f\n", this.avgMathGrade);
    System.out.printf("averaged Spanish grade: %f\n", this.avgSpanishGrade);
    System.out.printf("averaged English grade: %f\n", this.avgEnglishGrade);
  }

  private void scanMathGrades ()
  {
    this.mathGrader.scanGrades();
  }

  private void scanSpanishGrades ()
  {
    this.spanishGrader.scanGrades();
  }

  private void scanEnglishGrades ()
  {
    this.englishGrader.scanGrades();
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

