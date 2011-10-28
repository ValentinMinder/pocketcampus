package org.pocketcampus.tool.build.template

class AndroidDotClasspathTemplate {
	static def getText(String classpathEntries) {
		return  """\
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="src" path="gen"/>
	<classpathentry kind="con" path="com.android.ide.eclipse.adt.ANDROID_FRAMEWORK"/>
""" + classpathEntries + """
	<classpathentry kind="output" path="bin/classes"/>
</classpath>
		"""
	}
}
