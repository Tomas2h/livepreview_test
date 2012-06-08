package test_util;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class JavaScript {
  /**
   * Immediate function start.
   */
  public static CharSequence start() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(function() {");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Immediate function end.
   */
  public static CharSequence end() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("})();");
    _builder.newLine();
    return _builder;
  }
  
  public static CharSequence setupGlobals() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("window.f = document.getElementById(\'contentframe\');");
    _builder.newLine();
    return _builder;
  }
  
  public static CharSequence childrenLength() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _start = JavaScript.start();
    _builder.append(_start, "");
    _builder.newLineIfNotEmpty();
    _builder.append("if ( f.children.length !== 2 ) { return false; };");
    _builder.newLine();
    CharSequence _end = JavaScript.end();
    _builder.append(_end, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public static CharSequence firstChildHTML() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _start = JavaScript.start();
    _builder.append(_start, "");
    _builder.newLineIfNotEmpty();
    _builder.append("var c = f.firstChild;");
    _builder.newLine();
    _builder.append("if ( c.innerHTML !== \'Ruby\' ) { return false; };");
    _builder.newLine();
    CharSequence _end = JavaScript.end();
    _builder.append(_end, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public static CharSequence firstChildTagName() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _start = JavaScript.start();
    _builder.append(_start, "");
    _builder.newLineIfNotEmpty();
    _builder.append("var c = f.firstChild;");
    _builder.newLine();
    _builder.append("if ( c.tagName.toLowerCase() !== \'h1\' ) { return false; };");
    _builder.newLine();
    CharSequence _end = JavaScript.end();
    _builder.append(_end, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public static CharSequence checkCodeStyle0() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _start = JavaScript.start();
    _builder.append(_start, "");
    _builder.newLineIfNotEmpty();
    _builder.append("var div = f.children[1].firstChild;");
    _builder.newLine();
    _builder.append("if ( div.tagName.toLowerCase() !== \'div\' ) { return false; };");
    _builder.newLine();
    _builder.append("if ( div.className !== \'ace-github\' ) { return false; };");
    _builder.newLine();
    CharSequence _end = JavaScript.end();
    _builder.append(_end, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public static CharSequence checkCodeStyle1() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _start = JavaScript.start();
    _builder.append(_start, "");
    _builder.newLineIfNotEmpty();
    _builder.append("var div = f.children[1].firstChild;");
    _builder.newLine();
    _builder.append("var c00 = div.children[0].children[0];");
    _builder.newLine();
    _builder.append("var puts = c00.children[0];");
    _builder.newLine();
    _builder.append("if ( puts.tagName.toLowerCase() !== \'span\' ) { return false; };");
    _builder.newLine();
    _builder.append("if ( puts.className !== \'ace_support ace_function\' ) { return false; };");
    _builder.newLine();
    _builder.append("if ( puts.textContent !== \'puts\' ) { return false; };");
    _builder.newLine();
    CharSequence _end = JavaScript.end();
    _builder.append(_end, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public static CharSequence checkCodeStyle2() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _start = JavaScript.start();
    _builder.append(_start, "");
    _builder.newLineIfNotEmpty();
    _builder.append("var div = f.children[1].firstChild;");
    _builder.newLine();
    _builder.append("var c00 = div.children[0].children[0];");
    _builder.newLine();
    _builder.newLine();
    _builder.append("var ruby = c00.children[1];");
    _builder.newLine();
    _builder.append("if ( ruby.tagName.toLowerCase() !== \'span\' ) { return false; };");
    _builder.newLine();
    _builder.append("if ( ruby.className !== \'ace_string\' ) { return false; };");
    _builder.newLine();
    CharSequence _end = JavaScript.end();
    _builder.append(_end, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public static CharSequence someText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'# Ruby\\n\' +");
    _builder.newLine();
    _builder.append("\'\\n\' +");
    _builder.newLine();
    _builder.append("\'```ruby\\n\' +");
    _builder.newLine();
    _builder.append("\'puts \"ruby\"\\n\' +");
    _builder.newLine();
    _builder.append("\'```\'");
    _builder.newLine();
    return _builder;
  }
}
