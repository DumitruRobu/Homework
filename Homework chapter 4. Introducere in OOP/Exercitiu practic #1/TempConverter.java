public class TempConverter 
{
	public int celsius;
	public int fahr;
	public static float result;

	public static void convertToCelsius(float fahr)
	{
		result = ( fahr - 32 ) * (float)5/9;
		System.out.println("\n" + fahr + " grade fahr in celsius = " + result);
	}

	public static void convertToFahr(float celsius)
	{
		result = (celsius * (float)9/5) + 32;
		System.out.println("\n" + celsius + " grade celsius in fahr = " + result);
	}
}

