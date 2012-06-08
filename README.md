livepreview_test
================

[![Build Status](https://secure.travis-ci.org/bootstraponline/livepreview_test.png?branch=master)](http://travis-ci.org/bootstraponline/livepreview_test)

Tests [livepreview](https://github.com/bootstraponline/livepreview) hosted on GitHub Pages.

pom.xml
 - selenium-chrome-driver 2.22.0
 - selenium-support 2.22.0
 - junit 4.10

---

- chromedriver_linux32_20.0.1133.0 ([ChromeDriver](https://code.google.com/p/chromedriver/downloads/detail?name=chromedriver_linux32_20.0.1133.0.zip))
- chromedriver_linux64_20.0.1133.0 ([ChromeDriver](https://code.google.com/p/chromedriver/downloads/detail?name=chromedriver_linux64_20.0.1133.0.zip))
- xdisplaycheck ([Chromium trunk](https://src.chromium.org/viewvc/chrome/trunk/src/tools/xdisplaycheck/) - compiled for x64)
- Xvfb.32bit ([Chromium trunk](https://src.chromium.org/viewvc/chrome/trunk/tools/xvfb/))
- Xvfb.64bit ([Chromium trunk](https://src.chromium.org/viewvc/chrome/trunk/tools/xvfb/))

Run [cmd using Chromium trunk args](https://src.chromium.org/viewvc/chrome/trunk/tools/build/scripts/slave/xvfb.py?view=markup).

`Xvfb :9 -screen 0 1024x768x24 -ac`

Set env var.

`export DISPLAY=:9`

Run xdisplaycheck (not required when using travis.yml in this repository).

`xdisplaycheck`

Chrome build bots run Ubuntu Lucid x64 (10.04).

Errors that are safe to ignore:

0. https://code.google.com/p/chromium/issues/detail?id=120775
0. https://code.google.com/p/chromium/issues/detail?id=121655 (Active)
0. https://code.google.com/p/chromium/issues/detail?id=123413


`xdg-desktop-menu: No writable system menu directory found.` does not prevent chrome from installing.
https://code.google.com/p/chromium/issues/detail?id=73008

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running test.ChromeTest
Started ChromeDriver
port=2683
version=19.0.1068.0
log=/home/vagrant/builds/bootstraponline/livepreview_test/chromedriver.log
Xlib:  extension "RANDR" missing on display ":9".
Xlib:  extension "RANDR" missing on display ":9".
[6126:6126:207427758:ERROR:gl_surface_glx.cc(60)] glxQueryVersion failed
[6126:6126:207428747:ERROR:gl_surface_linux.cc(64)] GLSurfaceGLX::InitializeOneOff failed.
Xlib:  extension "RANDR" missing on display ":9".
5 XSELINUXs still allocated at reset
```

Use `"latest ChromeDriver with a current version of Google Chrome"` as stated on [the chromedriver wiki](https://code.google.com/p/chromedriver/wiki/ReleaseNotes).

# Resources

WebDriver
- http://rostislav-matl.blogspot.com/2011/05/moving-to-selenium-2-on-webdriver-part.html

Install deb from URL
- http://askubuntu.com/questions/51854/is-it-possible-to-install-a-deb-from-a-url

Remove line numbers from travis using `$x("//*/div/pre/p/a").forEach(function(e){ e.parentNode.removeChild(e) });` in Chrome.

Full log of failing test (without quiet, test does execute properly even if it fails due to page title):

```bash
Using worker: jvm-otp1.worker.travis-ci.org:travis-jvm-5
$ cd ~/builds
$ git clone --depth=100 --quiet git://github.com/bootstraponline/livepreview_test.git bootstraponline/livepreview_test
$ cd bootstraponline/livepreview_test
$ git checkout -qf 4ce865b24651ff366a9a2398c8cce26db54603da
$ sudo chmod 777 /dev/shm
$ wget https://raw.github.com/bootstraponline/livepreview_test/master/from_chrome/xvfb/Xvfb.32bit -O /tmp/Xvfb
--2012-05-25 16:27:41--  https://raw.github.com/bootstraponline/livepreview_test/master/from_chrome/xvfb/Xvfb.32bit
Resolving raw.github.com... 207.97.227.243
Connecting to raw.github.com|207.97.227.243|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 7924711 (7.6M) [text/plain]
Saving to: `/tmp/Xvfb'
100%[======================================>] 7,924,711   1.29M/s   in 6.0s    
2012-05-25 16:27:50 (1.26 MB/s) - `/tmp/Xvfb' saved [7924711/7924711]
$ chmod +x /tmp/Xvfb
$ sudo /tmp/Xvfb :9 -screen 0 1024x768x24 -ac &
[1] 1821
$ export DISPLAY=:9
[dix] Could not init font path element /usr/share/fonts/X11/TTF/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/OTF/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/Type1/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/100dpi/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/75dpi/, removing from list!
$ sleep 30
$ sudo apt-get install -y --force-yes libxss1 libnss3-1d xdg-utils
Reading package lists... Done
Building dependency tree       
Reading state information... Done
libnss3-1d is already the newest version.
libnss3-1d set to manually installed.
The following extra packages will be installed:
  libfile-basedir-perl libfile-desktopentry-perl libfile-mimeinfo-perl
  libxcb-shape0 libxv1 libxxf86dga1 x11-utils x11-xserver-utils
Suggested packages:
  mesa-utils nickle cairo-5c xorg-docs-core gvfs-bin
The following NEW packages will be installed:
  libfile-basedir-perl libfile-desktopentry-perl libfile-mimeinfo-perl
  libxcb-shape0 libxss1 libxv1 libxxf86dga1 x11-utils x11-xserver-utils
  xdg-utils
0 upgraded, 10 newly installed, 0 to remove and 22 not upgraded.
Need to get 577 kB of archives.
After this operation, 2,208 kB of additional disk space will be used.
Get:1 http://de.archive.ubuntu.com/ubuntu/ oneiric/main libxcb-shape0 i386 1.7-3 [6,286 B]
Get:2 http://de.archive.ubuntu.com/ubuntu/ oneiric/main libxss1 i386 1:1.2.1-2 [8,604 B]
Get:3 http://de.archive.ubuntu.com/ubuntu/ oneiric/main libxv1 i386 2:1.0.6-2 [12.0 kB]
Get:4 http://de.archive.ubuntu.com/ubuntu/ oneiric/main libfile-basedir-perl all 0.03-1fakesync1 [10.5 kB]
Get:5 http://de.archive.ubuntu.com/ubuntu/ oneiric/main libfile-desktopentry-perl all 0.04-2 [18.8 kB]
Get:6 http://de.archive.ubuntu.com/ubuntu/ oneiric/main libfile-mimeinfo-perl all 0.15-1 [52.3 kB]
Get:7 http://de.archive.ubuntu.com/ubuntu/ oneiric/main libxxf86dga1 i386 2:1.1.2-1 [11.8 kB]
Get:8 http://de.archive.ubuntu.com/ubuntu/ oneiric/main x11-utils i386 7.6+3 [217 kB]
Get:9 http://de.archive.ubuntu.com/ubuntu/ oneiric/main x11-xserver-utils i386 7.6+3 [173 kB]
Get:10 http://de.archive.ubuntu.com/ubuntu/ oneiric/main xdg-utils all 1.1.0~rc1-2ubuntu6 [66.6 kB]
Fetched 577 kB in 0s (1,620 kB/s)
Selecting previously deselected package libxcb-shape0.
(Reading database ... 75064 files and directories currently installed.)
Unpacking libxcb-shape0 (from .../libxcb-shape0_1.7-3_i386.deb) ...
Selecting previously deselected package libxss1.
Unpacking libxss1 (from .../libxss1_1%3a1.2.1-2_i386.deb) ...
Selecting previously deselected package libxv1.
Unpacking libxv1 (from .../libxv1_2%3a1.0.6-2_i386.deb) ...
Selecting previously deselected package libfile-basedir-perl.
Unpacking libfile-basedir-perl (from .../libfile-basedir-perl_0.03-1fakesync1_all.deb) ...
Selecting previously deselected package libfile-desktopentry-perl.
Unpacking libfile-desktopentry-perl (from .../libfile-desktopentry-perl_0.04-2_all.deb) ...
Selecting previously deselected package libfile-mimeinfo-perl.
Unpacking libfile-mimeinfo-perl (from .../libfile-mimeinfo-perl_0.15-1_all.deb) ...
Selecting previously deselected package libxxf86dga1.
Unpacking libxxf86dga1 (from .../libxxf86dga1_2%3a1.1.2-1_i386.deb) ...
Selecting previously deselected package x11-utils.
Unpacking x11-utils (from .../x11-utils_7.6+3_i386.deb) ...
Selecting previously deselected package x11-xserver-utils.
Unpacking x11-xserver-utils (from .../x11-xserver-utils_7.6+3_i386.deb) ...
Selecting previously deselected package xdg-utils.
Unpacking xdg-utils (from .../xdg-utils_1.1.0~rc1-2ubuntu6_all.deb) ...
Processing triggers for man-db ...
Setting up libxcb-shape0 (1.7-3) ...
Setting up libxss1 (1:1.2.1-2) ...
Setting up libxv1 (2:1.0.6-2) ...
Setting up libfile-basedir-perl (0.03-1fakesync1) ...
Setting up libfile-desktopentry-perl (0.04-2) ...
Setting up libfile-mimeinfo-perl (0.15-1) ...
Setting up libxxf86dga1 (2:1.1.2-1) ...
Setting up x11-utils (7.6+3) ...
Setting up x11-xserver-utils (7.6+3) ...
Setting up xdg-utils (1.1.0~rc1-2ubuntu6) ...
Processing triggers for libc-bin ...
ldconfig deferred processing now taking place
$ URL='https://dl.google.com/linux/direct/google-chrome-stable_current_i386.deb'; FILE=`mktemp`; wget "$URL" -qO $FILE && sudo dpkg -i $FILE; rm $FILE
Selecting previously deselected package google-chrome-stable.
(Reading database ... 75227 files and directories currently installed.)
Unpacking google-chrome-stable (from /tmp/tmp.GiOVai3NIh) ...
Setting up google-chrome-stable (19.0.1084.52-r138391) ...
xdg-desktop-menu: No writable system menu directory found.
update-alternatives: using /usr/bin/google-chrome to provide /usr/bin/x-www-browser (x-www-browser) in auto mode.
update-alternatives: using /usr/bin/google-chrome to provide /usr/bin/gnome-www-browser (gnome-www-browser) in auto mode.
Processing triggers for man-db ...
$ mvn install --quiet -DskipTests=true
$ mvn test
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building web_driver 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.4.3:resources (default-resources) @ web_driver ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/vagrant/builds/bootstraponline/livepreview_test/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ web_driver ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-resources-plugin:2.4.3:testResources (default-testResources) @ web_driver ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/vagrant/builds/bootstraponline/livepreview_test/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ web_driver ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.7.2:test (default-test) @ web_driver ---
[INFO] Surefire report directory: /home/vagrant/builds/bootstraponline/livepreview_test/target/surefire-reports
Downloading: http://repo1.maven.org/maven2/org/apache/maven/surefire/surefire-junit4/2.7.2/surefire-junit4-2.7.2.pom
Downloaded: http://repo1.maven.org/maven2/org/apache/maven/surefire/surefire-junit4/2.7.2/surefire-junit4-2.7.2.pom (3 KB at 6.9 KB/sec)
Downloading: http://repo1.maven.org/maven2/org/apache/maven/surefire/surefire-providers/2.7.2/surefire-providers-2.7.2.pom
Downloaded: http://repo1.maven.org/maven2/org/apache/maven/surefire/surefire-providers/2.7.2/surefire-providers-2.7.2.pom (2 KB at 3.7 KB/sec)
Downloading: http://repo1.maven.org/maven2/org/apache/maven/surefire/surefire-junit4/2.7.2/surefire-junit4-2.7.2.jar
Downloaded: http://repo1.maven.org/maven2/org/apache/maven/surefire/surefire-junit4/2.7.2/surefire-junit4-2.7.2.jar (25 KB at 51.2 KB/sec)
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running test.ChromeTest
Started ChromeDriver
port=26948
version=20.0.1133.0
log=/home/vagrant/builds/bootstraponline/livepreview_test/chromedriver.log
Xlib:  extension "RANDR" missing on display ":9".
[6129:6129:295261316:ERROR:renderer_main.cc(224)] Running without renderer sandbox
[6135:6135:295576642:ERROR:renderer_main.cc(224)] Running without renderer sandbox
Xlib:  extension "RANDR" missing on display ":9".
[6145:6145:300314642:ERROR:gl_surface_glx.cc(60)] glxQueryVersion failed
[6145:6145:300315579:ERROR:gl_surface_linux.cc(64)] GLSurfaceGLX::InitializeOneOff failed.
Xlib:  extension "RANDR" missing on display ":9".
5 XSELINUXs still allocated at reset
SCREEN: 0 objects of 64 bytes = 0 total bytes 0 private allocs
DEVICE: 4 objects of 16 bytes = 64 total bytes 0 private allocs
CLIENT: 0 objects of 56 bytes = 0 total bytes 0 private allocs
WINDOW: 0 objects of 24 bytes = 0 total bytes 0 private allocs
PIXMAP: 1 objects of 8 bytes = 8 total bytes 0 private allocs
GC: 0 objects of 44 bytes = 0 total bytes 0 private allocs
CURSOR: 0 objects of 4 bytes = 0 total bytes 0 private allocs
CURSOR_BITS: 0 objects of 4 bytes = 0 total bytes 0 private allocs
DBE_WINDOW: 0 objects of 12 bytes = 0 total bytes 0 private allocs
TOTAL: 5 objects, 72 bytes, 0 allocs
4 DEVICEs still allocated at reset
DEVICE: 4 objects of 16 bytes = 64 total bytes 0 private allocs
CLIENT: 0 objects of 56 bytes = 0 total bytes 0 private allocs
WINDOW: 0 objects of 24 bytes = 0 total bytes 0 private allocs
PIXMAP: 1 objects of 8 bytes = 8 total bytes 0 private allocs
GC: 0 objects of 44 bytes = 0 total bytes 0 private allocs
CURSOR: 0 objects of 4 bytes = 0 total bytes 0 private allocs
CURSOR_BITS: 0 objects of 4 bytes = 0 total bytes 0 private allocs
DBE_WINDOW: 0 objects of 12 bytes = 0 total bytes 0 private allocs
TOTAL: 5 objects, 72 bytes, 0 allocs
1 PIXMAPs still allocated at reset
PIXMAP: 1 objects of 8 bytes = 8 total bytes 0 private allocs
GC: 0 objects of 44 bytes = 0 total bytes 0 private allocs
CURSOR: 0 objects of 4 bytes = 0 total bytes 0 private allocs
CURSOR_BITS: 0 objects of 4 bytes = 0 total bytes 0 private allocs
DBE_WINDOW: 0 objects of 12 bytes = 0 total bytes 0 private allocs
TOTAL: 1 objects, 8 bytes, 0 allocs
[dix] Could not init font path element /usr/share/fonts/X11/TTF/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/OTF/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/Type1/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/100dpi/, removing from list!
[dix] Could not init font path element /usr/share/fonts/X11/75dpi/, removing from list!
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 504.391 sec <<< FAILURE!
Results :
Failed tests: 
  testGoogleSearch(test.ChromeTest): Title did not change to webdriver - Google Search within 500 seconds.
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8:26.581s
[INFO] Finished at: Fri May 25 16:40:15 UTC 2012
[INFO] Final Memory: 4M/15M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.7.2:test (default-test) on project web_driver: There are test failures.
[ERROR] 
[ERROR] Please refer to /home/vagrant/builds/bootstraponline/livepreview_test/target/surefire-reports for the individual test results.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Done. Build script exited with: 1
```
