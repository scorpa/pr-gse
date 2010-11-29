package textcoder;


public class TextCoder
{
	private TextShifter shifter;
	private CharacterCoder coder;
	
	public TextCoder()
	{
		
	}

	public void setCoder(CharacterCoder coder)
	{
		this.coder = coder;
	}

	public void setShifter(TextShifter shifter)
	{
		this.shifter = shifter;
	}
	
	public String encode(String text)
	{
		if (shifter != null)
			text = shifter.encode(text);
		if (coder != null)
		{
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < text.length(); i++)
				str.append(coder.encode(text.charAt(i)));
//			System.out.println(str);
			return str.toString();
		}
		else
			return text;
	}
	
	public String decode(String text)
	{
		if (shifter != null)
			text = shifter.decode(text);
		if (coder != null)
		{
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < text.length(); i++)
				str.append(coder.decode(text.charAt(i)));
			return str.toString();
		}
		else
			return text;
	}
	
}
