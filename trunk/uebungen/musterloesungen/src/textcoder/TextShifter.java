package textcoder;


public class TextShifter
{
	private int count;

	public TextShifter(int count)
	{
		if (count > 0)
			this.count = count;
		else
			count = -count;
	}
	
	public String encode(String text)
	{
		
		int l = text.length();
		int n = count % l;
		
		String neu = text.substring(n);
		neu += text.substring(0, n);
		
		return neu;
	}

	public String decode(String text)
	{
		return new TextShifter(text.length()-count % text.length()).encode(text);

	}
}
