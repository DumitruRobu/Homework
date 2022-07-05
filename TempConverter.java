public class TempConverter{

	
	public static void main (String[] args)
	{
		
		int tempCelsius = 20;
		float tempFahrenheit = 75.55F;
		
		float celsiusToFahrenheit = ( tempCelsius * (float) 9/5 ) + 32;  
		float fahrenheitToCelsius = ( tempFahrenheit -32 ) * (float) 5/9;		

		System.out.println(celsiusToFahrenheit);
		System.out.println(fahrenheitToCelsius);

	}
	
	
}