# fantasy-football
Fantasy football project made in two separate parts, one group took care of all backend functionality in the game and we took care of the user interface (UI). The other group's repository is [here](https://github.com/nori/hbv401g-2015v-f1a).

## Setting up Eclipse (Ubuntu)
Create a new Java project (e.g. called fantasy-football) and save to a directory of your choice. These instructions will asume you chose your home directory. Open up a shell and change to the directory you chose.

	$ cd ~/fantasy-football

Clone this repository into a src folder and also clone the other group's repository into a directory of your choice. I'll assume it's called F1a.

	$ git clone git@github.com:birkz/fantasy-football.git src
	$ git clone git@github.com:nori/hbv401g-2015v-f1a.git F1a

Change the Eclipse .classpath file to (Assuming you're using Java 8 and JUnit 4)

	<?xml version="1.0" encoding="UTF-8"?>
	<classpath>
		<classpathentry kind="src" path="src"/>
		<classpathentry kind="src" path="F1a/src"/>
		<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8"/>
		<classpathentry kind="con" path="org.eclipse.jdt.junit.JUNIT_CONTAINER/4"/>
		<classpathentry kind="lib" path="src/libs/gson-1.7.2.jar"/>
		<classpathentry kind="lib" path="src/libs/hamcrest-core-1.3.jar"/>
		<classpathentry kind="output" path="bin"/>
	</classpath>

Refresh the prject in Eclipse (select the project, then press F5) and then run the application!