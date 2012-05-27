package test_util;

public abstract class JavaScript {
	/** Based on generated code from RenderCheck.xtend **/
	public static String someText() {
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
		return _builder.toString();
	}

	/** Based on generated code from RenderCheck.xtend **/
	public static String verifyRender() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("(function() {");
		_builder.newLine();
		_builder.append("  ");
		_builder.append("var f = document.getElementById(\'contentframe\');");
		_builder.newLine();
		_builder.append("  ");
		_builder.append("if ( f.children.length !== 2 ) { return false; }");
		_builder.newLine();
		_builder.newLine();
		_builder.append("  ");
		_builder.append("var c = f.firstChild;");
		_builder.newLine();
		_builder.append("  ");
		_builder.append("if ( c.innerHTML !== \'Ruby\' ) { return false; }");
		_builder.newLine();
		_builder.newLine();
		_builder.append("  ");
		_builder.append("if ( c.tagName.toLowerCase() !== \'h1\' ) { return false; }");
		_builder.newLine();
		_builder.newLine();
		_builder.append("  ");
		_builder.append("var c2 = f.children[1];");
		_builder.newLine();
		_builder.append("  ");
		_builder.append("if ( c2.tagName.toLowerCase() !== \'pre\' ) { return false; }");
		_builder.newLine();
		_builder.newLine();
		_builder.append("  ");
		_builder.append("if ( c2.className !== \'ruby highlight\' ) { return false; }");
		_builder.newLine();
		_builder.newLine();
		_builder.append("  ");
		_builder.append("return true;");
		_builder.newLine();
		_builder.append("})();");
		_builder.newLine();
		return _builder.toString();
	}
}
