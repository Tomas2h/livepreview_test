livepreview_test
================

- chromedriver_linux32_20.0.1133.0 ([ChromeDriver](https://code.google.com/p/chromedriver/downloads/detail?name=chromedriver_linux32_20.0.1133.0.zip))
- chromedriver_linux64_20.0.1133.0 ([ChromeDriver](https://code.google.com/p/chromedriver/downloads/detail?name=chromedriver_linux64_20.0.1133.0.zip))
- xdisplaycheck ([Chromium trunk](https://src.chromium.org/viewvc/chrome/trunk/src/tools/xdisplaycheck/) - compiled for x64)
- Xvfb.32bit ([Chromium trunk](https://src.chromium.org/viewvc/chrome/trunk/tools/xvfb/))
- Xvfb.64bit ([Chromium trunk](https://src.chromium.org/viewvc/chrome/trunk/tools/xvfb/))

Run [cmd ushing Chromium trunk args](https://src.chromium.org/viewvc/chrome/trunk/tools/build/scripts/slave/xvfb.py?view=markup).

`Xvfb :9 -screen 0 1024x768x24 -ac`

Set env var.

`export DISPLAY=:9`

Run xdisplaycheck.

`xdisplaycheck`

Current Issues

0. https://code.google.com/p/chromium/issues/detail?id=120775
0. https://code.google.com/p/chromium/issues/detail?id=121655 (Active)
0. https://code.google.com/p/chromium/issues/detail?id=123413

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

Use "`latest ChromeDriver with a current version of Google Chrome`" as stated on [the chromedriver wiki](https://code.google.com/p/chromedriver/wiki/ReleaseNotes).

# Resources

WebDriver Resources
- http://rostislav-matl.blogspot.com/2011/05/moving-to-selenium-2-on-webdriver-part.html

Install deb from URL
- http://askubuntu.com/questions/51854/is-it-possible-to-install-a-deb-from-a-url
