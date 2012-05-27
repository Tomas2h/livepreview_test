package test_util;

public final class StringConcatenation {

	final StringBuilder s = new StringBuilder();

	public void append(String string) {
		s.append(string);
	}

	public void newLine() {
		s.append("\n");
	}

	@Override
	public String toString() {
		return s.toString();
	}
}
