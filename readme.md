# livepreview_test

[![Build Status](https://secure.travis-ci.org/bootstraponline/livepreview_test.png?branch=master)](http://travis-ci.org/bootstraponline/livepreview_test)

Tests [livepreview](https://github.com/bootstraponline/livepreview) hosted on GitHub Pages.

Depends on [livepreview_test_gen](https://github.com/bootstraponline/livepreview_test_gen).

To run the tests on Sauce use [livepreview_test_sauce](https://github.com/bootstraponline/livepreview_test_sauce).

Supported browsers:

- Chrome >= 7.0
- Firefox >= 4.0


Live preview requires [Typed Arrays](http://caniuse.com/typedarrays).

Remove [old binaries](https://help.github.com/articles/remove-sensitive-data):

> git filter-branch --index-filter 'git rm --cached --ignore-unmatch driver/chromedriver_linux32_20.0.1133.0 driver/chromedriver_linux64_20.0.1133.0' --prune-empty --tag-name-filter cat -- --all
