public class App {
	public static void main (String[] args)
	{
		TempConverter abc = new TempConverter();
		abc.celsius = 100;
		abc.fahr = 100;

		TempConverter.convertToCelsius(abc.fahr);
		TempConverter.convertToFahr(abc.celsius);
	}
}