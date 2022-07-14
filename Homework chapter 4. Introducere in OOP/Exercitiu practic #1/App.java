public class App {
	public static void main (String[] args)
	{
		TempConverter tempValue = new TempConverter();
		tempValue.celsius = 100;
		tempValue.fahr = 100;

		TempConverter.convertToCelsius(tempValue.fahr);
		TempConverter.convertToFahr(tempValue.celsius);
	}
}