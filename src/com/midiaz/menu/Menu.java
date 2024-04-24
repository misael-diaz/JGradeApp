package com.midiaz.menu;

import java.util.Scanner;

public class Menu
{
    private int tag = 0;
    private Scanner scan = null;

    public Menu (Scanner scan)
    {
	this.scan = scan;
    }

    public int tag ()
    {
	return this.tag;
    }

    public void prompt ()
    {
	String request = "Please enter the tag of the course you wish to grade ";
	String legend = "(0: Math 1: Spanish 2: English):";
	String msg = (request + legend);
	System.out.printf(msg);

	this.tag = scan.nextInt();
	if (this.tag < 0 || this.tag > 2) {
	    System.out.println("Please input a valid tag");
	    this.prompt();
	}

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

