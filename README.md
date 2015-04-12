# fantasy-football
<<<<<<< HEAD
Fantasy football project made in two separate parts, one group took care of all backend functionality in the game and we took care of the user interface (UI). The other group's repository is [here](https://github.com/nori/hbv401g-2015v-f1a).

## Setting up Eclipse (Ubuntu)
Choose a directory to use for the project. These instructions will asume you chose a directory called 'fantasy-football' in your home directory. Open up a shell and change to the directory you chose.

	$ cd ~
	$ mkdir fantasy-football
	$ cd fantasy-football

Clone this repository into a src folder and also clone the other group's repository into a directory of your choice. I'll assume it's called F1a.

	$ git clone git@github.com:nori/hbv401g-2015v-f1a.git .
	$ git clone git@github.com:birkz/fantasy-football.git src/is/hi/f2a
	
Open up Eclipse and create a project in the directory. Change the Eclipse .classpath file to (Assuming you're using JUnit 4)

	<?xml version="1.0" encoding="UTF-8"?>
	<classpath>
		<classpathentry kind="src" path="src"/>
		<classpathentry kind="src" path="test"/>
		<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
		<classpathentry kind="con" path="org.eclipse.jdt.junit.JUNIT_CONTAINER/4"/>
		<classpathentry kind="lib" path="src/is/hi/f2a/libs/gson-1.7.2.jar"/>
		<classpathentry kind="lib" path="src/is/hi/f2a/libs/hamcrest-core-1.3.jar"/>
		<classpathentry kind="output" path="bin"/>
	</classpath>

<<<<<<< HEAD
Refresh the prject in Eclipse (select the project, then press F5) and then run the application! The first time you 'Start game' it will take a while to get gather all player information, so be patient.
=======
test
Einar að prófa
>>>>>>> parent of 74cfc3e... push to pull
=======
Refresh the prject in Eclipse (select the project, then press F5) and then run the application!
>>>>>>> parent of d4fa8a1... another readme update
