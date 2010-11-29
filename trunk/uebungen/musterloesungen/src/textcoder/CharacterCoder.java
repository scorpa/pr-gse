package textcoder;


public class CharacterCoder
{
	private String src;
	private String dest;
	
	
	public CharacterCoder(String src, String dest)
	{
		if (check(src, dest))
		{
			this.src = src;
			this.dest = dest;
		}
		else
		{
			System.out.println("ung�ltige Schl�ssel");
			this.src = "abcdefg";
			this.dest = "bcagfed";
		}
		
	}
	
	public char encode(char c)
	{
		int inx = src.indexOf(c);
		if (inx >= 0)
			return dest.charAt(inx);
		else
			return c;
	}
	
	
	public char decode(char c)
	{
		int inx = dest.indexOf(c);
		if (inx >= 0)
			return src.charAt(inx);
		else
			return c;
	}
	
	

	
	
	private boolean check(String s, String d)
	{
		if (s == null || d == null || s.length() != d.length())
			return false;
		String charset = new String();
		for (int i = 0; i < s.length(); i++)
		{
			if(charset.contains(String.valueOf(s.charAt(i))))
				return false;
			else
				charset = charset + s.charAt(i);
			if (!d.contains(String.valueOf(s.charAt(i))))
				return false;
		}
		
		return true;
	}

}
