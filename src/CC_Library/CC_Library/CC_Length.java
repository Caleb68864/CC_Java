package CC_Library;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Length.
 */
public class CC_Length {
	
	/**
	 * Conv_in_2_m.
	 *
	 * @param varInches the var inches
	 * @return the double
	 */
	public static double conv_in_2_m(double varInches)
	{
		//1 inches = 0.0254 meters
		double varResult = 0;
		varResult = (varInches * .0254);
		return varResult;
	}
	
	/**
	 * Conv_in_2_ft.
	 *
	 * @param varInches the var inches
	 * @return the double
	 */
	public static double conv_in_2_ft(double varInches)
	{
		//1 foot = 12 inches
		double varResult = 0;
		varResult = (varInches / 12);
		return varResult;
	}
	
	/**
	 * Conv_in_2_yd.
	 *
	 * @param varInches the var inches
	 * @return the double
	 */
	public static double conv_in_2_yd(double varInches)
	{
		//1 yard = 36 inches
		double varResult = 0;
		varResult = (varInches / 36);
		return varResult;
	}
	
	/**
	 * Conv_ft_2_m.
	 *
	 * @param varFeet the var feet
	 * @return the double
	 */
	public static double conv_ft_2_m(double varFeet)
	{
		//1 foot = 0.3048 meters
		double varResult = 0;
		varResult = varFeet * .3048;
		return varResult;
	}
	
	/**
	 * Conv_yd_2_m.
	 *
	 * @param varYard the var yard
	 * @return the double
	 */
	public static double conv_yd_2_m(double varYard)
	{
		//1 yard = 0.9144 meters
		double varResult = 0;
		varResult = varYard * .9144;
		return varResult;
	}
	
	/**
	 * Conv_yd_2_in.
	 *
	 * @param varYard the var yard
	 * @return the double
	 */
	public static double conv_yd_2_in(double varYard)
	{
		//1 yard = 36 inches
		double varResult = 0;
		varResult = varYard * 36;
		return varResult;
	}
	
	/**
	 * Conv_yd_2_ft.
	 *
	 * @param varYard the var yard
	 * @return the double
	 */
	public static double conv_yd_2_ft(double varYard)
	{
		//1 yard = 3 feet
		double varResult = 0;
		varResult = varYard * 3;
		return varResult;
	}
	
	/**
	 * Conv_m_2_in.
	 *
	 * @param varMeter the var meter
	 * @return the double
	 */
	public static double conv_m_2_in(double varMeter)
	{
		//1 meter = 39.3700787 inches
		double varResult = 0;
		varResult = varMeter * 39.3701;
		return varResult;
	}
	
	/**
	 * Conv_m_2_ft.
	 *
	 * @param varMeter the var meter
	 * @return the double
	 */
	public static double conv_m_2_ft(double varMeter)
	{
		//1 meter = 3.2808399 feet
		double varResult = 0;
		varResult = varMeter * 3.2808;
		return varResult;
	}
	
	/**
	 * Conv_m_2_yd.
	 *
	 * @param varMeter the var meter
	 * @return the double
	 */
	public static double conv_m_2_yd(double varMeter)
	{
		//1 meter = 1.0936133 yard
		double varResult = 0;
		varResult = varMeter * 1.0936;
		return varResult;
	}

}
